import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Button, Modal, Form, Table, Alert, Pagination } from 'react-bootstrap';

function ItemIssueCrud() {
  const [data, setData] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);
  const [search, setSearch] = useState('');
  const [showModal, setShowModal] = useState(false);
  const [modalMode, setModalMode] = useState('add');
  const [formData, setFormData] = useState({});
  const [users, setUsers] = useState([]);
  const [departments, setDepartments] = useState([]);
  const [items, setItems] = useState([]);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchData();
    axios.get('/api/otherusers').then(res => setUsers(res.data.content));
    axios.get('/api/departments').then(res => setDepartments(res.data.content));
    axios.get('/api/items').then(res => setItems(res.data.content));
  }, [page, search]);

  const fetchData = () => {
    axios.get(`/api/itemissues?search=${search}&page=${page}&size=10`).then(res => {
      setData(res.data.content);
      setTotalPages(res.data.totalPages);
    });
  };

  const handleSave = () => {
    if (!formData.requestedby || !formData.departmentid || !formData.itemid || !formData.qty || !formData.requestdate || !formData.status) {
      setError('Please fill all required fields');
      return;
    }
    // const selectedItem = items.find(i => i.itemid === formData.itemid);
    // if (formData.qty <= 0 || formData.qty > selectedItem.maxstock) {
    //   setError('Quantity must be positive and <= maxstock');
    //   return;
    // }
    const selectedItem = items.find(i => i.itemid === formData.itemid);
    if (!selectedItem) {
      setError('Please select a valid item');
      return;
    }
    if (formData.qty <= 0 || formData.qty > selectedItem.maxstock) {
      setError(`Quantity must be positive and <= maxstock (${selectedItem.maxstock})`);
      return;
    }

    const payload = { ...formData, lastaddeditby: sessionStorage.getItem('userid'), lasteditdatetime: new Date().toISOString() };
    const req = modalMode === 'add' ? axios.post('/api/itemissues', payload) : axios.put(`/api/itemissues/${formData.issueid}`, payload);
    req.then(() => {
      fetchData();
      setShowModal(false);
    });
  };

  const handleDelete = (id) => {
    axios.delete(`/api/itemissues/${id}`).then(() => fetchData());
  };

  return (
    <div className="container mt-4">
      <div className="d-flex mb-3">
        <Form.Control placeholder="Search..." value={search} onChange={e => setSearch(e.target.value)} />
        <Button className="ms-2" onClick={() => { setModalMode('add'); setFormData({ requestdate: new Date().toISOString().split('T')[0], status: 'Pending' }); setShowModal(true); }}>Add</Button>
      </div>

      {error && <Alert variant="danger">{error}</Alert>}

      <Table bordered hover>
        <thead>
          <tr>
            <th>Issue ID</th>
            <th>Requested By</th>
            <th>Department</th>
            <th>Item</th>
            <th>Qty</th>
            <th>Request Date</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {data.map(row => (
            <tr key={row.issueid}>
              <td>{row.issueid}</td>
              <td>{users.find(u => u.ouserid === row.requestedby)?.ousername || row.requestedby}</td>
              <td>{departments.find(d => d.deptid === row.departmentid)?.deptname || row.departmentid}</td>
              <td>{items.find(i => i.itemid === row.itemid)?.itemname || row.itemid}</td>
              <td>{row.qty}</td>
              <td>{row.requestdate}</td>
              <td>{row.status}</td>
              <td>
                <Button size="sm" onClick={() => { setModalMode('view'); setFormData(row); setShowModal(true); }}>View</Button>{' '}
                {row.status === 'Pending' && <>
                  <Button size="sm" onClick={() => { setModalMode('edit'); setFormData(row); setShowModal(true); }}>Edit</Button>{' '}
                  <Button size="sm" variant="danger" onClick={() => handleDelete(row.issueid)}>Delete</Button>
                </>}
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Pagination>
        {[...Array(totalPages)].map((_, i) => (
          <Pagination.Item key={i} active={i === page} onClick={() => setPage(i)}>{i + 1}</Pagination.Item>
        ))}
      </Pagination>

      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton><Modal.Title>{modalMode === 'add' ? 'Add' : modalMode === 'edit' ? 'Edit' : 'View'} Item Issue</Modal.Title></Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group>
              <Form.Label>Requested By</Form.Label>
              <Form.Select disabled={modalMode === 'view'} value={formData.requestedby || ''} onChange={e => setFormData({ ...formData, requestedby: parseInt(e.target.value) })}>
                <option value=''>Select</option>
                {users.map(u => <option key={u.ouserid} value={u.ouserid}>{u.ousername}</option>)}
              </Form.Select>
            </Form.Group>
            <Form.Group>
              <Form.Label>Department</Form.Label>
              <Form.Select disabled={modalMode === 'view'} value={formData.departmentid || ''} onChange={e => setFormData({ ...formData, departmentid: parseInt(e.target.value) })}>
                <option value=''>Select</option>
                {departments.map(d => <option key={d.deptid} value={d.deptid}>{d.deptname}</option>)}
              </Form.Select>
            </Form.Group>
            <Form.Group>
              <Form.Label>Item</Form.Label>
              <Form.Select disabled={modalMode === 'view'} value={formData.itemid || ''} onChange={e => setFormData({ ...formData, itemid: parseInt(e.target.value) })}>
                <option value=''>Select</option>
                {items.map(i => <option key={i.itemid} value={i.itemid}>{i.itemname}</option>)}
              </Form.Select>
            </Form.Group>
            <Form.Group>
              <Form.Label>Quantity</Form.Label>
              <Form.Control type="number" disabled={modalMode === 'view'} value={formData.qty || ''} onChange={e => setFormData({ ...formData, qty: parseInt(e.target.value) })} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Remark</Form.Label>
              <Form.Control disabled={modalMode === 'view'} value={formData.remark || ''} onChange={e => setFormData({ ...formData, remark: e.target.value })} />
            </Form.Group>
            <Form.Group>
              <Form.Label>Status</Form.Label>
              <Form.Select disabled={modalMode === 'view'} value={formData.status || ''} onChange={e => setFormData({ ...formData, status: e.target.value })}>
                <option value=''>Select</option>
                {['Pending', 'Approved', 'Issued', 'Closed', 'Rejected', 'Cancelled'].map(status => <option key={status} value={status}>{status}</option>)}
              </Form.Select>
            </Form.Group>
          </Form>
        </Modal.Body>
        {modalMode !== 'view' && <Modal.Footer>
          <Button onClick={handleSave}>Save</Button>
        </Modal.Footer>}
      </Modal>
    </div>
  );
}

export default ItemIssueCrud;
