import React, { useEffect, useState } from 'react';
import { Modal, Button, Form, Table, Alert, Row, Col, Spinner } from 'react-bootstrap';
import axios from 'axios';

function PurchaseOrderModal({
  show,
  mode,
  header,
  onClose,
  onSave,
  onFetchFromPR,
  isFetchFromPROk,
  isEditable
}) {
  const [localHeader, setLocalHeader] = useState(header);
  const [suppliers, setSuppliers] = useState([]);
  const [items, setItems] = useState([]);
  const [errors, setErrors] = useState([]);

  const userId = parseInt(sessionStorage.getItem('userid'));
  let lastaddeditby = 0;
  let lasteditdatetime = new Date().toISOString();

  useEffect(() => {
    setLocalHeader(header);
  }, [header]);

  useEffect(() => {
    // axios.get('/api/suppliers').then(res => setSuppliers(res.data)).catch(console.error);
    axios.get('/api/suppliers')
      .then(res => {
        // If the response is paged (e.g., { content: [...], totalPages: ... })
        if (Array.isArray(res.data)) {
          setSuppliers(res.data); // flat list
        } else if (Array.isArray(res.data.content)) {
          setSuppliers(res.data.content); // paginated format
        } else {
          setSuppliers([]); // fallback
        }
      })
      .catch(err => {
        console.error('Failed to load suppliers', err);
        setSuppliers([]);
      });

    // axios.get('/api/items').then(res => setItems(res.data)).catch(console.error);
    axios.get('/api/items')
      .then(res => {
        if (Array.isArray(res.data)) {
          setItems(res.data); // flat array of items
        } else if (Array.isArray(res.data.content)) {
          setItems(res.data.content); // paginated format
        } else {
          setItems([]); // fallback
        }
      })
      .catch(err => {
        console.error('Failed to load items', err);
        setItems([]);
      });

  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setLocalHeader(prev => ({ ...prev, [name]: value }));
  };

  const handleDetailChange = (index, field, value) => {
    const newDetails = [...(localHeader.details || [])];
    newDetails[index][field] = value;
    if (newDetails[index].qty > 0 && newDetails[index].rate > 0) {
      newDetails[index].amount = newDetails[index].qty * newDetails[index].rate;
    } else {
      newDetails[index].amount = 0;
    }
    setLocalHeader(prev => ({ ...prev, details: newDetails }));
  };

  const handleAddDetail = () => {
    setLocalHeader(prev => ({
      ...prev,
      details: [...(prev.details || []), { itemid: '', qty: 1, rate: 0, amount: 0, prid: null }]
    }));
  };

  const handleRemoveDetail = (index) => {
    const newDetails = localHeader.details.filter((_, i) => i !== index);
    setLocalHeader(prev => ({ ...prev, details: newDetails }));
  };

  const handleSubmit = () => {
    const err = [];
    if (!localHeader.supplierid) err.push('Supplier is required.');
    if (!localHeader.podate) err.push('PO Date is required.');
    if ((mode === 'edit') && localHeader.deliverydate && localHeader.deliverydate < localHeader.podate) {
      err.push('Delivery date cannot be before PO date.');
    }
    setErrors(err);
    if (err.length === 0) {
      const payload = {
        ...localHeader,
        lastaddeditby: userId,
        lasteditdatetime: new Date().toISOString(),
        details: (localHeader.details || []).map(d => ({
          ...d,
          amount: d.qty * d.rate,
          lastaddeditby: userId,
          lasteditdatetime: new Date().toISOString()
        }))
      };
      onSave(payload); // localHeader
    }
  };

  const handleFetchFromPRClick = async () => {
    if (!localHeader.supplierid) return;
    const prItems = await onFetchFromPR(localHeader.supplierid);
    setLocalHeader(prev => ({
      ...prev,
      details: [...(prev.details || []), ...prItems]
    }));
  };

  if (!localHeader) return null;

  return (
    <Modal show={show} onHide={onClose} size="xl">
      <Modal.Header closeButton>
        <Modal.Title>{mode === 'add' ? 'Add PO' : mode === 'edit' ? 'Edit PO' : 'View PO'}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {errors.length > 0 && <Alert variant="danger">{errors.map((e, i) => <div key={i}>{e}</div>)}</Alert>}
        <Form>
          <Row className="mb-3">
            <Col md={6}>
              <Form.Label>Supplier</Form.Label>
              <Form.Select name="supplierid" value={localHeader.supplierid || ''} onChange={handleChange} disabled={!isEditable}>
                <option value=''>-- Select Supplier --</option>
                {(suppliers || []).map(s => (
                  <option key={s.supplierid} value={s.supplierid}>{s.suppliername}</option>
                ))}
              </Form.Select>
            </Col>
            <Col md={3}>
              <Form.Label>PO Date</Form.Label>
              <Form.Control type="date" name="podate" value={localHeader.podate || ''} onChange={handleChange} disabled={!isEditable} />
            </Col>
            <Col md={3}>
              <Form.Label>Delivery Date</Form.Label>
              <Form.Control type="date" name="deliverydate" value={localHeader.deliverydate || ''} onChange={handleChange} disabled={mode === 'view'} />
            </Col>
          </Row>

          <Row className="mb-2">
            <Col md={4}>
              <Form.Label>Status</Form.Label>
              <Form.Select name="status" value={localHeader.status || 'Pending'} onChange={handleChange} disabled={!isEditable}>
                {['Pending', 'Hold', 'Approve', 'Reject'].map((status, i) => (
                  <option key={i} value={status}>{status}</option>
                ))}
              </Form.Select>
            </Col>
            <Col md={4} className="d-flex align-items-end">
              {isEditable && (
                <Button variant="info" onClick={handleFetchFromPRClick} disabled={!localHeader.supplierid}>PO from Purchase Request</Button>
              )}
            </Col>
          </Row>

          <h5>PO Details</h5>
          <Table bordered responsive>
            <thead>
              <tr>
                <th>Item</th>
                <th>Qty</th>
                <th>Rate</th>
                <th>Amount</th>
                {isEditable && <th>Action</th>}
              </tr>
            </thead>
            <tbody>
              {(localHeader.details || []).map((detail, index) => {
                const isPRLinked = detail.prid !== null && detail.prid !== 0;
                return (
                  <tr key={index}>
                    <td>
                      {isEditable && !isPRLinked ? (
                        <Form.Select value={detail.itemid || ''} onChange={(e) => handleDetailChange(index, 'itemid', parseInt(e.target.value))}>
                          <option value=''>-- Select Item --</option>
                          {(items || []).map(i => (
                            <option key={i.itemid} value={i.itemid}>{i.itemname}</option>
                          ))}
                        </Form.Select>
                      ) : (
                        items.find(i => i.itemid === detail.itemid)?.itemname || 'N/A'
                      )}
                    </td>
                    <td>{detail.qty}</td>
                    <td>
                      {isEditable ? (
                        <Form.Control
                          type="number"
                          min="0"
                          value={detail.rate}
                          onChange={(e) => handleDetailChange(index, 'rate', parseFloat(e.target.value))}
                        />
                      ) : detail.rate}
                    </td>
                    <td>{(detail.qty * detail.rate).toFixed(2)}</td>
                    {isEditable && !isPRLinked && (
                      <td>
                        <Button variant="danger" size="sm" onClick={() => handleRemoveDetail(index)}>
                          Delete
                        </Button>
                      </td>
                    )}
                  </tr>
                );
              })}
            </tbody>
          </Table>
          {isEditable && (
            <Button variant="secondary" onClick={handleAddDetail}>+ Add Item</Button>
          )}
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onClose}>Close</Button>
        {isEditable && <Button variant="primary" onClick={handleSubmit}>Save</Button>}
      </Modal.Footer>
    </Modal>
  );
}

export default PurchaseOrderModal;
