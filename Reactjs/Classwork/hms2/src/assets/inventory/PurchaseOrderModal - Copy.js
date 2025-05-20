// Final fix: Ensure total_amount display, saving, and delete button in edit mode
import React, { useEffect, useState } from 'react';
import { Modal, Button, Form, Table, Row, Col } from 'react-bootstrap';
import axios from 'axios';

function PurchaseOrderModal({
  show,
  mode,
  header,
  onClose,
  onSave,
  onFetchFromPR,
  isFetchFromPROk,
  isEditable,
  onHeaderChange,
  supplierList
}) {
  const [localHeader, setLocalHeader] = useState(header);
  // const [suppliers, setSuppliers] = useState([]);
  const [items, setItems] = useState([]);
  const [showDetailModal, setShowDetailModal] = useState(false);
  const [currentDetailIndex, setCurrentDetailIndex] = useState(null);
  const [editDetail, setEditDetail] = useState({ itemid: '', qty: 1, rate: 0 });

  console.log(isFetchFromPROk);

  useEffect(() => {
    setLocalHeader(header);
  }, [header]);

  useEffect(() => {
    // axios.get('/api/suppliers')
    //   .then(res => setSuppliers(Array.isArray(res.data) ? res.data : res.data.content || []));

    axios.get('/api/items')
      .then(res => setItems(Array.isArray(res.data) ? res.data : res.data.content || []));
  }, []);

  useEffect(() => {
    if (header) {
      const total = (header.details || []).reduce((sum, d) => sum + (d.qty * d.rate), 0);
      setLocalHeader({ ...header, total_amount: total });
    }
  }, [JSON.stringify(header)]);

  const handleEditDetail = (index) => {
    const detail = localHeader.details[index];
    setCurrentDetailIndex(index);
    setEditDetail({ ...detail });
    setShowDetailModal(true);
  };

  const handleSaveDetailEdit = () => {
    const updatedDetails = [...localHeader.details];
    updatedDetails[currentDetailIndex] = {
      ...editDetail,
      amount: editDetail.qty * editDetail.rate
    };

    setLocalHeader(prev => ({
      ...prev,
      details: updatedDetails,
      total_amount: updatedDetails.reduce((sum, d) => sum + d.qty * d.rate, 0)
    }));

    setShowDetailModal(false);
  };

  const handleDetailChange = (index, field, value) => {
    const updated = [...localHeader.details];
    updated[index][field] = value;
    updated[index].amount = updated[index].qty * updated[index].rate;
    setLocalHeader(prev => ({
      ...prev,
      details: updated,
      total_amount: updated.reduce((sum, d) => sum + (d.qty * d.rate), 0)
    }));
  };

  const handleAddDetail = () => {
    setLocalHeader(prev => ({
      ...prev,
      details: [...(prev.details || []), { itemid: '', qty: 1, rate: 0, amount: 0, prid: null }]
    }));
  };

  const handleRemoveDetail = (index) => {
    const updated = [...localHeader.details];
    updated.splice(index, 1);
    setLocalHeader(prev => ({
      ...prev,
      details: updated,
      total_amount: updated.reduce((sum, d) => sum + (d.qty * d.rate), 0)
    }));
  };

  const handleSubmit = () => {
    const updatedDetails = (localHeader.details || []).map(d => ({
      ...d,
      amount: d.qty * d.rate
    }));

    const payload = {
      ...localHeader,
      total_amount: updatedDetails.reduce((sum, d) => sum + d.amount, 0),
      details: updatedDetails
    };

    onSave(payload);
  };

  const handleHeaderChange = (e) => {
    const { name, value } = e.target;
    setLocalHeader(prev => ({ ...prev, [name]: value }));
    if (onHeaderChange) onHeaderChange(name, value);
  };

  return (
    <Modal show={show} onHide={onClose} size="lg">
      <Modal.Header closeButton>
        <Modal.Title>{mode === 'add' ? 'Add PO' : mode === 'edit' ? 'Edit PO' : 'View PO'}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Row className="mb-2">
            <Col>
              <Form.Group>
                <Form.Label>Supplier</Form.Label>
                <Form.Select
                  name="supplierid"
                  value={localHeader.supplierid || ''}
                  onChange={handleHeaderChange}
                >
                  <option value="">-- Select Supplier --</option>
                  {supplierList.map((s) => (
                    <option key={s.supplierid} value={s.supplierid}>
                      {s.suppliername}
                    </option>
                  ))}
                </Form.Select>
              </Form.Group>
            </Col>
            <Col>
              <Form.Label>Status</Form.Label>
              <Form.Select
                name="status"
                value={localHeader.status}
                onChange={handleHeaderChange}
                disabled={mode === 'view'}
              >
                {['Pending', 'Reject', 'Hold', 'Approve', 'Confirmed'].map((s, idx) => (
                  <option key={idx} value={s}>{s}</option>
                ))}
              </Form.Select>
            </Col>
          </Row>

          <Row className="mb-2">
            <Col>
              <Form.Label>PO Date</Form.Label>
              <Form.Control
                type="date"
                name="podate"
                value={localHeader.podate || ''}
                onChange={handleHeaderChange}
                disabled={mode !== 'add'}
              />
            </Col>
            {mode === 'edit' ?
              <Col>
                <Form.Label>Delivery Date</Form.Label>
                <Form.Control
                  type="date"
                  name="deliverydate"
                  value={localHeader.deliverydate || ''}
                  onChange={handleHeaderChange}
                  disabled={mode === 'view'}
                />
              </Col>
              : null}
          </Row>

          <Row className="mb-2">
            <Col>
              <Form.Label>Total Amount</Form.Label>
              <Form.Control
                type="text"
                value={localHeader.total_amount?.toFixed(2) || '0.00'}
                readOnly
              />
            </Col>
          </Row>

          {/* {(mode === 'add' || mode === 'edit') && ( */}
          {(mode === 'add') && (
            <Button
              variant="outline-info"
              className="mb-3"
              onClick={() => {
                console.log('Fetch From PR clicked');
                onFetchFromPR();
              }}
              disabled={!localHeader?.supplierid}
            >
              PO From Purchase Request
            </Button>
          )}

          <h5>PO Details</h5>
          <Table striped bordered>
            <thead>
              <tr>
                <th style={{ width: "600px" }}>Item</th>
                <th style={{ width: "30px" }}>Qty</th>
                <th style={{ width: "30px" }}>Rate</th>
                <th style={{ width: "50px" }}>Amount</th>
                <th style={{ width: "200px" }}>Action</th>
              </tr>
            </thead>
            <tbody>
              {(localHeader.details || []).map((detail, index) => {
                const isPRLinked = detail.prid !== null && detail.prid !== 0;

                return (
                  <tr key={index} className={isPRLinked ? 'table-info' : ''}>
                    <td>
                      {isEditable && !isPRLinked ? (
                        <Form.Select
                          value={detail.itemid || ''}
                          onChange={(e) => handleDetailChange(index, 'itemid', parseInt(e.target.value))}
                        >
                          <option value=''>-- Select Item --</option>
                          {items.map(i => (
                            <option key={i.itemid} value={i.itemid}>{i.itemname}</option>
                          ))}
                        </Form.Select>
                      ) : (
                        items.find(i => i.itemid === detail.itemid)?.itemname || 'N/A'
                      )}
                    </td>
                    <td>
                      {isEditable ? (
                        <Form.Control
                          type="number"
                          min="1"
                          value={detail.qty}
                          onChange={(e) => handleDetailChange(index, 'qty', parseFloat(e.target.value))}
                          disabled={isPRLinked}
                        />
                      ) : detail.qty}
                    </td>
                    <td>
                      {isEditable ? (
                        <Form.Control
                          type="number"
                          min="0.01"
                          step="0.01"
                          value={detail.rate}
                          onChange={(e) => handleDetailChange(index, 'rate', parseFloat(e.target.value))}
                          disabled={isPRLinked}
                        />
                      ) : detail.rate}
                    </td>
                    <td>{(detail.qty * detail.rate).toFixed(2)}</td>
                    <td>
                      {isEditable && (!detail.prid || detail.prid === 0) && (
                        <>
                          <Button
                            variant="warning"
                            // size="sm"
                            style={{ width: "70px" }}                            
                            className="me-1"
                            onClick={() => handleEditDetail(index)}
                          >
                            Edit
                          </Button>
                          {isEditable && (!detail.prid || detail.prid === 0) ? (
                            <Button
                              variant="danger"
                              // size="sm"
                              style={{ width: "70px" }}                            
                              onClick={() => handleRemoveDetail(index)}
                            >
                              Delete
                            </Button>
                          ) : null}
                        </>
                      )}
                    </td>
                    <td>
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </Table>
          {isEditable && (
            <Button variant="secondary" onClick={handleAddDetail}>Add Detail</Button>
          )}
        </Form>
        <Modal show={showDetailModal} onHide={() => setShowDetailModal(false)}>
          <Modal.Header closeButton>
            <Modal.Title>Edit PO Detail</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form.Group className="mb-2">
              <Form.Label>Item</Form.Label>
              <Form.Select
                value={editDetail.itemid}
                onChange={(e) => setEditDetail(prev => ({ ...prev, itemid: parseInt(e.target.value) }))}
              >
                <option value="">-- Select Item --</option>
                {items.map(i => (
                  <option key={i.itemid} value={i.itemid}>{i.itemname}</option>
                ))}
              </Form.Select>
            </Form.Group>
            <Form.Group className="mb-2">
              <Form.Label>Quantity</Form.Label>
              <Form.Control
                type="number"
                min="1"
                value={editDetail.qty}
                onChange={(e) => setEditDetail(prev => ({ ...prev, qty: parseFloat(e.target.value) }))}
              />
            </Form.Group>
            <Form.Group className="mb-2">
              <Form.Label>Rate</Form.Label>
              <Form.Control
                type="number"
                min="0.01"
                step="0.01"
                value={editDetail.rate}
                onChange={(e) => setEditDetail(prev => ({ ...prev, rate: parseFloat(e.target.value) }))}
              />
            </Form.Group>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={() => setShowDetailModal(false)}>Cancel</Button>
            <Button variant="primary" onClick={handleSaveDetailEdit}>Save</Button>
          </Modal.Footer>
        </Modal>

      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onClose}>Close</Button>
        {mode !== 'view' && (
          <Button variant="primary" onClick={handleSubmit}>Save</Button>
        )}
      </Modal.Footer>
    </Modal>
  );
}

export default PurchaseOrderModal;
