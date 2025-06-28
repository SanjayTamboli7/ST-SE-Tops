import React, { useState, useEffect } from 'react';
import { Button, Table, Form, Spinner, Pagination } from 'react-bootstrap';
import { Row, Col, Container } from 'react-bootstrap';
import axios from 'axios';
import GrnFormModal from './GrnFormModal';

const GrnList = () => {
  const [search, setSearch] = useState('');
  const [grns, setGrns] = useState([]);
  const [loading, setLoading] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [modalMode, setModalMode] = useState('add');
  const [selectedGrn, setSelectedGrn] = useState(null);
  const [receivedByNames, setReceivedByNames] = useState({});
  const [error, setError] = useState(null);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);

  const fetchGrns = async (pageNumber = 0) => {
    setLoading(true);
    setError(null);

    try {
      const response = await axios.get("http://localhost:8080/api/grns", {
        params: {
          keyword: search,
          page: pageNumber,
          size: 10,
          sortField: 'grnid',
          sortDir: 'DESC'
        }
      });

      const data = response.data;
      const content = data.content || [];

      const normalized = content.map(grn => ({
        grnid: grn.grnid || grn.id || grn.grnId,
        poid: grn.poid || grn.poId || grn.purchaseOrderId,
        receivedBy: grn.receivedBy || grn.receivedby || grn.received_by,
        receivedDate: grn.receivedDate || grn.receiveddate || grn.received_date,
        status: grn.status || 'Draft'
      }));

      setGrns(normalized);
      setTotalPages(data.totalPages);
      setPage(data.number);

      const userIds = [...new Set(normalized.map(grn => grn.receivedBy).filter(Boolean))];
      const nameMap = { ...receivedByNames };

      for (const id of userIds) {
        if (!nameMap[id]) {
          try {
            const res = await axios.get(`http://localhost:8080/api/otherusers/${id}`);
            nameMap[id] = res.data.ousername || res.data.username || res.data.name || `User-${id}`;
          } catch (error) {
            nameMap[id] = `User-${id}`;
          }
        }
      }
      setReceivedByNames(nameMap);
    } catch (error) {
      setError(error.message || 'Failed to fetch GRNs');
      setGrns([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchGrns(0);
  }, []);

  useEffect(() => {
    const delayDebounce = setTimeout(() => {
      fetchGrns(0); // restart from page 0 on search
    }, 500); // 500ms debounce

    return () => clearTimeout(delayDebounce);
  }, [search]);

  const openModal = async (mode, grn = null) => {
    setModalMode(mode);

    if ((mode === 'view' || mode === 'edit') && grn?.grnid) {
      try {
        const res = await axios.get(`http://localhost:8080/api/grns/${grn.grnid}`);
        setSelectedGrn(res.data);
      } catch (err) {
        alert("Failed to load GRN details: " + err.message);
        return;
      }
    } else {
      setSelectedGrn(null);
    }

    setShowModal(true);
  };

  const handleDelete = async (grnid) => {
    if (!window.confirm('Are you sure you want to delete this GRN?')) return;
    try {
      await axios.delete(`http://localhost:8080/api/grns/${grnid}`);
      fetchGrns(page);
    } catch (err) {
      alert('Delete failed: ' + (err.response?.data?.message || err.message));
    }
  };

  const handlePageChange = (pageNum) => {
    fetchGrns(pageNum);
  };

  const formatDate = (dateString) => {
    if (!dateString) return 'N/A';
    try {
      return new Date(dateString).toLocaleDateString();
    } catch (error) {
      return dateString;
    }
  };

  return (
    <div className="container mt-4">
      <h3>Goods Receipt Note (GRN) List</h3>

      <div className="d-flex justify-content-between my-2">
        <Form.Control
          type="text"
          placeholder="Search by GRN ID, PO ID, etc."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          style={{ width: '300px' }}
        />
        <Button onClick={() => openModal('add')}>Add GRN</Button>
      </div>

      {error && (
        <div className="alert alert-danger" role="alert">
          <strong>Error:</strong> {error}
          <Button variant="link" size="sm" onClick={() => fetchGrns(page)} className="ms-2">Retry</Button>
        </div>
      )}

      {loading ? (
        <div className="text-center my-5">
          <Spinner animation="border" />
          <p className="mt-2">Loading GRNs...</p>
        </div>
      ) : (
        <Container fluid>
          <Row className="mt-3">
            <Col>
              <Table striped bordered hover responsive size="sm">
                <thead>
                  <tr>
                    <th>GRN ID</th>
                    <th>PO ID</th>
                    <th>Received By</th>
                    <th>Status</th>
                    <th>Received Date</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {grns.length === 0 ? (
                    <tr>
                      <td colSpan="6" className="text-center">
                        No GRNs found.
                      </td>
                    </tr>
                  ) : (
                    grns.map((grn) => (
                      <tr key={grn.grnid}>
                        <td>{grn.grnid}</td>
                        <td>{grn.poid}</td>
                        <td>{receivedByNames[grn.receivedBy] || grn.receivedBy || 'N/A'}</td>
                        <td>
                          <span className={`badge ${grn.status === 'Closed' ? 'bg-success' : grn.status === 'Open' ? 'bg-warning' : grn.status === 'Cancelled' ? 'bg-danger' : 'bg-secondary'}`}>
                            {grn.status}
                          </span>
                        </td>
                        <td>{formatDate(grn.receivedDate)}</td>
                        <td>
                          <Button size="sm" variant="info" onClick={() => openModal('view', grn)} className="me-1">View</Button>
                          {(grn.status === 'Draft' || grn.status === 'Open') && (
                            <>
                              <Button size="sm" variant="warning" onClick={() => openModal('edit', grn)} className="me-1">Edit</Button>
                              <Button size="sm" variant="danger" onClick={() => handleDelete(grn.grnid)}>Delete</Button>
                            </>
                          )}
                        </td>
                      </tr>
                    ))
                  )}
                </tbody>
              </Table>

              <Pagination className="justify-content-center">
                {[...Array(totalPages).keys()].map((p) => (
                  <Pagination.Item key={p} active={p === page} onClick={() => handlePageChange(p)}>
                    {p + 1}
                  </Pagination.Item>
                ))}
              </Pagination>
            </Col>
          </Row>
        </Container>
      )}

      {showModal && (
        <GrnFormModal
          show={showModal}
          mode={modalMode}
          grn={selectedGrn}
          onHide={() => setShowModal(false)}
          onSave={() => {
            setShowModal(false);
            fetchGrns(page);
          }}
        />
      )}
    </div>
  );
};

export default GrnList;
