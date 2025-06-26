import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Table } from 'react-bootstrap';
import axios from 'axios';

const GrnFormModal = ({ show, mode, grn, onHide, onSave }) => {
  const isView = mode === 'view';
  const isEdit = mode === 'edit';
  const isAdd = mode === 'add';

  const [header, setHeader] = useState({
    poid: '',
    receivedDate: new Date().toISOString().split('T')[0],
    receivedBy: '',
    status: 'Draft',
    lastAddEditBy: sessionStorage.getItem('userid'),
    lastEditDateTime: new Date().toISOString(),
  });

  const [details, setDetails] = useState([]);
  const [userOptions, setUserOptions] = useState([]);
  const [poOptions, setPoOptions] = useState([]);
  const [itemOptions, setItemOptions] = useState([]);

  useEffect(() => {
    // Load dropdowns
    axios.get("http://localhost:8080/api/otherusers")
      .then(res => setUserOptions(res.data.content || []));

    axios.get("http://localhost:8080/api/items")
      .then(res => setItemOptions(res.data.content || []));

    axios.get("http://localhost:8080/api/grns/approved")
      .then(res => setPoOptions(res.data || []));

    // Load data for view/edit
    if ((isEdit || isView) && grn) {
      console.log("Loading GRN header:", grn);

      setHeader({
        poid: grn.poid || '',
        receivedDate: grn.receivedDate || new Date().toISOString().split('T')[0],
        receivedBy: grn.receivedBy || '',
        status: grn.status || 'Draft',
        lastAddEditBy: grn.lastAddEditBy || sessionStorage.getItem('userid'),
        lastEditDateTime: grn.lastEditDateTime || new Date().toISOString(),
      });

      const processedDetails = Array.isArray(grn.details)
        ? grn.details.map(detail => ({
            grndetailid: detail.grndetailid,
            itemid: detail.itemid,
            orderedQty: detail.orderedQty || 0,
            receivedQty: detail.receivedQty || 0,
            acceptedQty: detail.acceptedQty || 0,
            rejectedQty: detail.rejectedQty || 0,
            batchNo: detail.batchNo || '',
            expiryDate: detail.expiryDate || '',
            poDetailId: detail.poDetailId || null,
            lastAddEditBy: detail.lastaddeditby || sessionStorage.getItem('userid'),
            lastEditDateTime: detail.lasteditdatetime || new Date().toISOString(),
          }))
        : [];

      console.log("Processed GRN details:", processedDetails);
      setDetails(processedDetails);
    }

    if (isAdd) {
      setDetails([]);
    }
  }, [grn, mode, show]); // Include `show` to re-trigger when modal opens

  const handleHeaderChange = (e) => {
    const { name, value } = e.target;
    setHeader(prev => ({ ...prev, [name]: value }));
  };

  const handleDetailChange = (index, field, value) => {
    const updated = [...details];
    updated[index][field] = value;
    setDetails(updated);
  };

  const addDetail = () => {
    setDetails(prev => [...prev, {
      itemid: '',
      orderedQty: 0,
      receivedQty: 0,
      acceptedQty: 0,
      rejectedQty: 0,
      batchNo: '',
      expiryDate: '',
      poDetailId: null,
      lastAddEditBy: sessionStorage.getItem('userid'),
      lastEditDateTime: new Date().toISOString(),
    }]);
  };

  const removeDetail = (index) => {
    const updated = [...details];
    updated.splice(index, 1);
    setDetails(updated);
  };

  const fetchPoItems = async () => {
    if (!header.poid) return;
    try {
      const res = await axios.get(`http://localhost:8080/api/poitems/${header.poid}`);
      const rows = res.data || [];
      const mappedDetails = rows.map(item => ({
        itemid: item.itemid,
        orderedQty: item.orderedqty,
        receivedQty: 0,
        acceptedQty: 0,
        rejectedQty: 0,
        batchNo: '',
        expiryDate: '',
        poDetailId: item.podetailid,
        lastAddEditBy: sessionStorage.getItem('userid'),
        lastEditDateTime: new Date().toISOString(),
      }));
      setDetails(mappedDetails);
    } catch (error) {
      alert("Failed to fetch PO Items: " + error.message);
    }
  };

  const handleSave = async () => {
    if (!header.receivedBy) {
      alert("Please select 'Received By'");
      return;
    }
    const payload = {
      ...header,
      details,
      lastEditDateTime: new Date().toISOString(),
      lastAddEditBy: sessionStorage.getItem('userid')
    };
    try {
      if (isAdd) {
        await axios.post("http://localhost:8080/api/grns", payload);
      } else if (isEdit && grn) {
        await axios.put(`http://localhost:8080/api/grns/${grn.grnid}`, payload);
      }
      onSave();
    } catch (err) {
      alert("Error saving GRN: " + err.message);
    }
  };

  return (
    <Modal show={show} onHide={onHide} size="xl">
      <Modal.Header closeButton>
        <Modal.Title>{isAdd ? 'Add GRN' : isEdit ? 'Edit GRN' : 'View GRN'}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group className="mb-2">
            <Form.Label>PO ID</Form.Label>
            <div className="d-flex gap-2">
              <Form.Select
                name="poid"
                value={header.poid}
                onChange={handleHeaderChange}
                disabled={isView}
              >
                <option value="">--Select PO--</option>
                {poOptions.map(po => (
                  <option key={po.poid} value={po.poid}>
                    {po.poid} - {po.suppliername} ({po.podate})
                  </option>
                ))}
              </Form.Select>
              {isAdd && (
                <Button
                  variant="outline-primary"
                  size="sm"
                  onClick={fetchPoItems}
                  disabled={!header.poid}
                >
                  GRN From PO
                </Button>
              )}
            </div>
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Received Date</Form.Label>
            <Form.Control
              type="date"
              name="receivedDate"
              value={header.receivedDate}
              onChange={handleHeaderChange}
              max={new Date().toISOString().split('T')[0]}
              disabled={isView}
            />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Received By</Form.Label>
            <Form.Select
              name="receivedBy"
              value={header.receivedBy}
              onChange={handleHeaderChange}
              disabled={isView}
            >
              <option value="">--Select--</option>
              {userOptions.map(u => (
                <option key={u.ouserid} value={u.ouserid}>{u.ousername}</option>
              ))}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Status</Form.Label>
            <Form.Select
              name="status"
              value={header.status}
              onChange={handleHeaderChange}
              disabled={isView}
            >
              <option>Draft</option>
              <option>Open</option>
              <option>Closed</option>
              <option>Cancelled</option>
            </Form.Select>
          </Form.Group>

          <hr />
          <h5>GRN Details</h5>
          <Table bordered size="sm">
            <thead>
              <tr>
                <th>Item</th>
                <th>Ordered</th>
                <th>Received</th>
                <th>Accepted</th>
                <th>Rejected</th>
                <th>Batch No</th>
                <th>Expiry</th>
                {!isView && <th>Actions</th>}
              </tr>
            </thead>
            <tbody>
              {details.map((row, idx) => (
                <tr key={idx}>
                  <td>
                    <Form.Select
                      value={row.itemid}
                      onChange={(e) => handleDetailChange(idx, 'itemid', e.target.value)}
                      disabled={isView}
                    >
                      <option value=''>--Select--</option>
                      {itemOptions.map(it => (
                        <option key={it.itemid} value={it.itemid}>{it.itemname}</option>
                      ))}
                    </Form.Select>
                  </td>
                  <td><Form.Control type="number" value={row.orderedQty} onChange={(e) => handleDetailChange(idx, 'orderedQty', +e.target.value)} disabled={isView} /></td>
                  <td><Form.Control type="number" value={row.receivedQty} onChange={(e) => handleDetailChange(idx, 'receivedQty', +e.target.value)} disabled={isView} /></td>
                  <td><Form.Control type="number" value={row.acceptedQty} onChange={(e) => handleDetailChange(idx, 'acceptedQty', +e.target.value)} disabled={isView} /></td>
                  <td><Form.Control type="number" value={row.rejectedQty} onChange={(e) => handleDetailChange(idx, 'rejectedQty', +e.target.value)} disabled={isView} /></td>
                  <td><Form.Control type="text" value={row.batchNo} onChange={(e) => handleDetailChange(idx, 'batchNo', e.target.value)} disabled={isView} /></td>
                  <td><Form.Control type="date" value={row.expiryDate} onChange={(e) => handleDetailChange(idx, 'expiryDate', e.target.value)} disabled={isView} /></td>
                  {!isView && (
                    <td>
                      <Button size="sm" variant="danger" onClick={() => removeDetail(idx)}>Delete</Button>
                    </td>
                  )}
                </tr>
              ))}
            </tbody>
          </Table>
          {!isView && <Button onClick={addDetail}>Add Detail</Button>}
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onHide}>Close</Button>
        {!isView && <Button variant="primary" onClick={handleSave}>Save</Button>}
      </Modal.Footer>
    </Modal>
  );
};

export default GrnFormModal;
