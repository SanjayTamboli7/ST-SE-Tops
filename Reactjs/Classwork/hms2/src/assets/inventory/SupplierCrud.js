// This is a simplified ReactJS + Bootstrap frontend component for CRUD operations on `mstsupplier`.
// Backend: Spring Boot REST API (provided below).

import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Table, Alert, Pagination } from 'react-bootstrap';
import axios from 'axios';

const SupplierCrud = () => {
  const [suppliers, setSuppliers] = useState([]);
  const [search, setSearch] = useState('');
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [sortField, setSortField] = useState('suppliername');
  const [sortDir, setSortDir] = useState('asc');
  const [modalShow, setModalShow] = useState(false);
  const [modalMode, setModalMode] = useState('add'); // add | edit | view
  const [selectedSupplier, setSelectedSupplier] = useState(null);
  const [message, setMessage] = useState(null);
  const [formData, setFormData] = useState({
    suppliername: '',
    contactperson: '',
    phone: '',
    email: '',
    address: '',
    creditterms: '',
  });

  const pageSize = 5;

  const loadSuppliers = async () => {
    const response = await axios.get(`/api/suppliers`, {
      params: { page: currentPage, size: pageSize, search, sortField, sortDir },
    });
    setSuppliers(response.data.content);
    setTotalPages(response.data.totalPages);
  };

  useEffect(() => { loadSuppliers(); }, [currentPage, search, sortField, sortDir]);

  const handleSubmit = async () => {
    for (let key in formData) {
      if (!formData[key]) return setMessage(`${key} is required.`);
    }
    const dataToSend = {
      ...formData,
      lastaddeditby: sessionStorage.getItem('userid'),
    };
    try {
      if (modalMode === 'add') {
        await axios.post('/api/suppliers', dataToSend);
        setMessage('Supplier added successfully.');
      } else {
        await axios.put(`/api/suppliers/${selectedSupplier.supplierid}`, dataToSend);
        setMessage('Supplier updated successfully.');
      }
      setModalShow(false);
      loadSuppliers();
    } catch (err) {
      setMessage('Error saving supplier.');
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm('Are you sure to delete?')) return;
    try {
      await axios.delete(`/api/suppliers/${id}`);
      setMessage('Supplier deleted successfully.');
      loadSuppliers();
    } catch {
      setMessage('Error deleting supplier.');
    }
  };

  const openModal = (mode, supplier = null) => {
    setModalMode(mode);
    setSelectedSupplier(supplier);
    setFormData(supplier || {
      suppliername: '', contactperson: '', phone: '', email: '', address: '', creditterms: ''
    });
    setModalShow(true);
  };

  return (
    <div className="container mt-4">
      <h4>Supplier Management</h4>

      {message && <Alert variant="info" onClose={() => setMessage(null)} dismissible>{message}</Alert>}

      <div className="d-flex justify-content-between mb-2">
        <input type="text" className="form-control w-50" placeholder="Search by name/contact" value={search} onChange={(e) => setSearch(e.target.value)} />
        <Button variant="primary" onClick={() => openModal('add')}>Add</Button>
      </div>

      <Table striped bordered hover>
        <thead>
          <tr>
            <th onClick={() => setSortField('suppliername')}>Name</th>
            <th>Contact</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Credit Terms</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {suppliers.map((s, i) => (
            <tr key={i}>
              <td>{s.suppliername}</td>
              <td>{s.contactperson}</td>
              <td>{s.phone}</td>
              <td>{s.email}</td>
              <td>{s.creditterms}</td>
              <td>
                <Button size="sm" onClick={() => openModal('view', s)}>View</Button>{' '}
                <Button size="sm" variant="warning" onClick={() => openModal('edit', s)}>Edit</Button>{' '}
                <Button size="sm" variant="danger" onClick={() => handleDelete(s.supplierid)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Pagination>
        {[...Array(totalPages).keys()].map(n => (
          <Pagination.Item key={n} active={n === currentPage} onClick={() => setCurrentPage(n)}>{n + 1}</Pagination.Item>
        ))}
      </Pagination>

      <Modal show={modalShow} onHide={() => setModalShow(false)}>
        <Modal.Header closeButton>
          <Modal.Title>{modalMode === 'add' ? 'Add Supplier' : modalMode === 'edit' ? 'Edit Supplier' : 'View Supplier'}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            {Object.keys(formData).map((field) => (
              <Form.Group key={field} className="mb-2">
                <Form.Label className="text-capitalize">{field}</Form.Label>
                <Form.Control
                  type="text"
                  value={formData[field]}
                  disabled={modalMode === 'view'}
                  onChange={(e) => setFormData({ ...formData, [field]: e.target.value })}
                />
              </Form.Group>
            ))}
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setModalShow(false)}>Close</Button>
          {modalMode !== 'view' && <Button variant="primary" onClick={handleSubmit}>Save</Button>}
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default SupplierCrud;
