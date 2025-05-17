import React, { useEffect, useState } from 'react';
import { Container, Row, Col, Button, Table } from 'react-bootstrap';
import usePurchaseOrder from './usePurchaseOrder';
import PurchaseOrderModal from './PurchaseOrderModal';
import PaginationControl from './PaginationControl';
import SearchBox from './SearchBox';
import StatusBadge from './StatusBadge';
import axios from 'axios';

function PurchaseOrderPage() {
  const [showModal, setShowModal] = useState(false);
  const [modalMode, setModalMode] = useState('view'); // view | add | edit
  const [currentHeader, setCurrentHeader] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');

  const {
    headers,
    pagination,
    fetchHeaders,
    handleAdd,
    handleUpdate,
    handleDelete,
    handleFetchFromPR
  } = usePurchaseOrder(searchTerm);

  const userId = parseInt(sessionStorage.getItem('userid'));
  console.log(userId);
  let lastaddeditby = 0;
  let lasteditdatetime = new Date().toISOString();  

  useEffect(() => {
    fetchHeaders();
  }, [fetchHeaders]);

  const handleShowModal = async (mode, header = null) => {
    setModalMode(mode);
    if (mode === 'add') {
      try {
        const res = await axios.get('/api/poheaders/maxdate');
        const maxPoDate = res.data;
        setCurrentHeader({
          pono: '',
          podate: maxPoDate || new Date().toISOString().split('T')[0],
          deliverydate: '',
          supplierid: '',
          details: [],
          status: 'Pending'
        });
      } catch (err) {
        console.error('Failed to fetch max PO date', err);
        setCurrentHeader({
          pono: '',
          podate: new Date().toISOString().split('T')[0],
          deliverydate: '',
          supplierid: '',
          details: [],
          status: 'Pending'
        });
      }
    } else {
      // setCurrentHeader(header);

    try {
      const response = await axios.get(`/api/poheaders/${header.poid}`);
      setCurrentHeader(response.data);
    } catch (err) {
      console.error('Failed to fetch full PO header with details', err);
      alert('Could not load full PO data.');
    }

    }
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
    setCurrentHeader(null);
  };

  const handleSave = async (data) => {
    if (new Date(data.deliverydate) < new Date(data.podate)) {
      alert('Delivery date cannot be before PO date.');
      return;
    }

    const payload = {
      ...data,
      lastaddeditby: userId,
      lasteditdatetime: new Date().toISOString(),
      details: (data.details || []).map((d) => ({
        ...d,
        amount: d.qty * d.rate,
        lastaddeditby: userId,
        lasteditdatetime: new Date().toISOString()
      }))
    };

    console.log(lastaddeditby);
    console.log(lasteditdatetime);
    if (modalMode === 'add') {
      await handleAdd(payload); // data
    } else if (modalMode === 'edit') {
      await handleUpdate(payload); // data
    }
    handleCloseModal();
  };

  const handleDeleteClick = async (poid) => {
    if (window.confirm('Are you sure you want to delete this PO?')) {
      await handleDelete(poid);
    }
  };

  const handleFetchFromPRClick = async () => {
    if (modalMode === 'view' || !currentHeader?.supplierid) return;
    const items = await handleFetchFromPR(currentHeader.supplierid);
    if (items) {
      setCurrentHeader(prev => ({
        ...prev,
        details: items
      }));
    }
  };

  return (
    <Container className="mt-4">
      <Row className="mb-3">
        <Col><h2>Purchase Orders</h2></Col>
        <Col className="text-end">
          <Button variant="primary" onClick={() => handleShowModal('add')}>
            + New PO
          </Button>
        </Col>
      </Row>

      <Row className="mb-3">
        <Col>
          <SearchBox value={searchTerm} onChange={setSearchTerm} />
        </Col>
      </Row>

      <Table striped bordered hover responsive>
        <thead>
          <tr>
            <th>PO ID</th>
            <th>PO Date</th>
            <th>Supplier</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {headers.map((header) => (
            <tr key={header.poid}>
              <td>{header.poid}</td>
              <td>{header.podate}</td>
              <td>{header.suppliername}</td>
              <td><StatusBadge status={header.status} /></td>
              <td>
                <Button
                  variant="info"
                  size="sm"
                  className="me-2"
                  onClick={() => handleShowModal('view', header)}
                >
                  View
                </Button>
                <Button
                  variant="warning"
                  size="sm"
                  className="me-2"
                  onClick={() => handleShowModal('edit', header)}
                  disabled={!(header.status === 'Pending' || header.status === 'Hold')}
                >
                  Edit
                </Button>
                <Button
                  variant="danger"
                  size="sm"
                  onClick={() => handleDeleteClick(header.poid)}
                  disabled={header.status !== 'Pending'}
                >
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <PaginationControl pagination={pagination} onPageChange={fetchHeaders} />

      {showModal && (
        <PurchaseOrderModal
          show={showModal}
          mode={modalMode}
          header={currentHeader}
          onClose={handleCloseModal}
          onSave={handleSave}
          onFetchFromPR={handleFetchFromPRClick}
          isFetchFromPROk={!!currentHeader?.supplierid && modalMode !== 'view'}
          isEditable={modalMode !== 'view' && (currentHeader?.status === 'Pending' || currentHeader?.status === 'Hold')}
        />
      )}
    </Container>
  );
}

export default PurchaseOrderPage;
