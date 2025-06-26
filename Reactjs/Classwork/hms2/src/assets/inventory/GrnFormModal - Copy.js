import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Table, Alert } from 'react-bootstrap';
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
  const [itemOptions, setItemOptions] = useState([]);
  const [poOptions, setPOOptions] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        
        // Fetch users
        const usersRes = await axios.get("http://localhost:8080/api/otherusers");
        setUserOptions(usersRes.data.content || usersRes.data || []);
        
        // Fetch items
        const itemsRes = await axios.get("http://localhost:8080/api/items");
        setItemOptions(itemsRes.data.content || itemsRes.data || []);
        
        // Fetch PO options using the new endpoint
        try {
          const poRes = await axios.get("http://localhost:8080/api/grns/approved");
          setPOOptions(poRes.data || []);
          console.log('PO Options loaded from approved endpoint:', poRes.data.length);
        } catch (err) {
          console.warn('Could not load PO options from approved endpoint:', err);
          // Fallback to original endpoints if new one fails
          try {
            let poRes;
            try {
              poRes = await axios.get("http://localhost:8080/api/pos");
            } catch (err) {
              // Try alternative endpoint names
              try {
                poRes = await axios.get("http://localhost:8080/api/poheaders");
              } catch (err2) {
                poRes = await axios.get("http://localhost:8080/api/purchaseorders");
              }
            }
            setPOOptions(poRes.data.content || poRes.data || []);
          } catch (fallbackErr) {
            console.warn('Could not load PO options from fallback endpoints:', fallbackErr);
            setPOOptions([]);
          }
        }

        // Handle existing GRN data
        if ((isEdit || isView) && grn) {
          setHeader({
            poid: grn.poid || '',
            receivedDate: grn.receiveddate || grn.receivedDate || new Date().toISOString().split('T')[0],
            receivedBy: grn.receivedby || grn.receivedBy || '',
            status: grn.status || 'Draft',
            lastAddEditBy: grn.lastaddeditby || grn.lastAddEditBy || sessionStorage.getItem('userid'),
            lastEditDateTime: grn.lasteditdatetime || grn.lastEditDateTime || new Date().toISOString()
          });
          
          try {
            const detailsRes = await axios.get(`http://localhost:8080/api/grns/${grn.grnid}/details`);
            const existingDetails = detailsRes.data || [];
            setDetails(existingDetails.map(detail => ({
              grndetailid: detail.grndetailid,
              itemid: detail.itemid || '',
              orderedQty: detail.orderedqty || detail.orderedQty || 0,
              receivedQty: detail.receivedqty || detail.receivedQty || 0,
              acceptedQty: detail.acceptedqty || detail.acceptedQty || 0,
              rejectedQty: detail.rejectedqty || detail.rejectedQty || 0,
              batchNo: detail.batchno || detail.batchNo || '',
              expiryDate: detail.expirydate || detail.expiryDate || '',
              poDetailId: detail.podetailid || detail.poDetailId || null,
              lastAddEditBy: detail.lastaddeditby || detail.lastAddEditBy || sessionStorage.getItem('userid'),
              lastEditDateTime: detail.lasteditdatetime || detail.lastEditDateTime || new Date().toISOString()
            })));
          } catch (err) {
            console.error('Error fetching GRN details:', err);
            setDetails([]);
          }
        } else if (isAdd) {
          setDetails([]);
          setHeader({
            poid: '',
            receivedDate: new Date().toISOString().split('T')[0],
            receivedBy: '',
            status: 'Draft',
            lastAddEditBy: sessionStorage.getItem('userid'),
            lastEditDateTime: new Date().toISOString(),
          });
        }
        
        // Log the loaded data for debugging
        console.log('User Options loaded:', userOptions.length);
        console.log('Item Options loaded:', itemOptions.length);
      } catch (err) {
        console.error('Error fetching data:', err);
        setError('Failed to load data: ' + err.message);
      } finally {
        setLoading(false);
      }
    };

    if (show) {
      fetchData();
    }
  }, [grn, mode, show, isEdit, isView, isAdd]);

  const handleHeaderChange = (e) => {
    const { name, value } = e.target;
    setHeader(prev => ({ 
      ...prev, 
      [name]: value,
      lastEditDateTime: new Date().toISOString()
    }));
    setError(''); // Clear error when user makes changes
  };

  const handleDetailChange = (index, field, value) => {
    const updated = [...details];
    updated[index] = {
      ...updated[index],
      [field]: value,
      lastEditDateTime: new Date().toISOString()
    };
    setDetails(updated);
  };

  const addDetail = () => {
    const newDetail = {
      itemid: '',
      orderedQty: 0,
      receivedQty: 0,
      acceptedQty: 0,
      rejectedQty: 0,
      batchNo: '',
      expiryDate: '',
      poDetailId: null,
      lastAddEditBy: sessionStorage.getItem('userid'),
      lastEditDateTime: new Date().toISOString()
    };
    setDetails(prev => [...prev, newDetail]);
  };

  const removeDetail = (index) => {
    const updated = [...details];
    updated.splice(index, 1);
    setDetails(updated);
  };

  const validateForm = () => {
    const errors = [];
    
    if (!header.poid) {
      errors.push('PO ID is required');
    }
    
    if (!header.receivedBy) {
      errors.push('Received By is required');
    }
    
    if (!header.receivedDate) {
      errors.push('Received Date is required');
    }
    
    // Validate details
    if (details.length === 0) {
      errors.push('At least one detail item is required');
    } else {
      details.forEach((detail, index) => {
        if (!detail.itemid) {
          errors.push(`Item is required for row ${index + 1}`);
        }
        if (detail.receivedQty < 0) {
          errors.push(`Received quantity cannot be negative for row ${index + 1}`);
        }
        if (detail.acceptedQty < 0) {
          errors.push(`Accepted quantity cannot be negative for row ${index + 1}`);
        }
        if (detail.rejectedQty < 0) {
          errors.push(`Rejected quantity cannot be negative for row ${index + 1}`);
        }
      });
    }
    
    return errors;
  };

  const handleSave = async () => {
    const validationErrors = validateForm();
    if (validationErrors.length > 0) {
      setError(validationErrors.join(', '));
      return;
    }

    const payload = {
      poid: parseInt(header.poid),
      receivedDate: header.receivedDate,
      receivedBy: parseInt(header.receivedBy),
      status: header.status,
      lastAddEditBy: parseInt(sessionStorage.getItem('userid')),
      details: details.map(detail => ({
        itemid: parseInt(detail.itemid),
        orderedQty: parseInt(detail.orderedQty) || 0,
        receivedQty: parseInt(detail.receivedQty) || 0,
        acceptedQty: parseInt(detail.acceptedQty) || 0,
        rejectedQty: parseInt(detail.rejectedQty) || 0,
        batchNo: detail.batchNo || '',
        expiryDate: detail.expiryDate || null,
        poDetailId: detail.poDetailId ? parseInt(detail.poDetailId) : null,
        ...(detail.grndetailid && { grndetailid: detail.grndetailid })
      }))
    };

    try {
      setLoading(true);
      setError('');
      
      if (isAdd) {
        await axios.post("http://localhost:8080/api/grns", payload);
      } else if (isEdit && grn) {
        await axios.put(`http://localhost:8080/api/grns/${grn.grnid}`, payload);
      }
      
      onSave();
    } catch (err) {
      console.error("Error saving GRN:", err);
      const errorMessage = err.response?.data?.message || 
                          err.response?.data?.error || 
                          err.message || 
                          'Unknown error occurred';
      setError("Error saving GRN: " + errorMessage);
    } finally {
      setLoading(false);
    }
  };

  const getItemName = (itemid) => {
    const item = itemOptions.find(item => item.itemid === itemid);
    return item ? item.itemname : 'Unknown Item';
  };

  const getUserName = (userid) => {
    const user = userOptions.find(user => user.ouserid === userid);
    return user ? user.ousername : 'Unknown User';
  };

  const getPODisplayText = (poid) => {
    const po = poOptions.find(po => po.poid === poid);
    if (po) {
      return `${po.suppliername} (${po.podate})`;
    }
    return `PO-${poid}`;
  };

  if (loading && show) {
    return (
      <Modal show={show} onHide={onHide} size="xl">
        <Modal.Header closeButton>
          <Modal.Title>Loading...</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div className="text-center">
            <div className="spinner-border" role="status">
              <span className="visually-hidden">Loading...</span>
            </div>
          </div>
        </Modal.Body>
      </Modal>
    );
  }

  return (
    <Modal show={show} onHide={onHide} size="xl">
      <Modal.Header closeButton>
        <Modal.Title>
          {isAdd ? 'Add GRN' : isEdit ? 'Edit GRN' : 'View GRN'}
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {error && (
          <Alert variant="danger" dismissible onClose={() => setError('')}>
            {error}
          </Alert>
        )}
        
        <Form>
          <div className="row mb-3">
            <div className="col-md-6">
              <Form.Group className="mb-2">
                <Form.Label>PO ID *</Form.Label>
                {isView ? (
                  <Form.Control 
                    value={`${header.poid} - ${getPODisplayText(header.poid)}`} 
                    disabled 
                  />
                ) : (
                  <Form.Select 
                    name="poid" 
                    value={header.poid} 
                    onChange={handleHeaderChange}
                    required
                  >
                    <option value="">--Select PO--</option>
                    {poOptions.map(po => (
                      <option key={po.poid} value={po.poid}>
                        {po.suppliername} ({po.podate})
                      </option>
                    ))}
                  </Form.Select>
                )}
              </Form.Group>
            </div>
            <div className="col-md-6">
              <Form.Group className="mb-2">
                <Form.Label>Received Date *</Form.Label>
                <Form.Control 
                  type="date" 
                  name="receivedDate" 
                  value={header.receivedDate} 
                  onChange={handleHeaderChange} 
                  max={new Date().toISOString().split('T')[0]} 
                  disabled={isView}
                  required
                />
              </Form.Group>
            </div>
          </div>

          <div className="row mb-3">
            <div className="col-md-6">
              <Form.Group className="mb-2">
                <Form.Label>Received By *</Form.Label>
                {isView ? (
                  <Form.Control 
                    value={getUserName(header.receivedBy)} 
                    disabled 
                  />
                ) : (
                  <Form.Select
                    name="receivedBy"
                    value={header.receivedBy}
                    onChange={handleHeaderChange}
                    required
                  >
                    <option value="">-- Select User --</option>
                    {userOptions.map((user) => (
                      <option key={user.ouserid} value={user.ouserid}>
                        {user.ousername}
                      </option>
                    ))}
                  </Form.Select>
                )}
              </Form.Group>
            </div>
            <div className="col-md-6">
              <Form.Group className="mb-2">
                <Form.Label>Status</Form.Label>
                <Form.Select 
                  name="status" 
                  value={header.status} 
                  onChange={handleHeaderChange} 
                  disabled={isView}
                >
                  <option value="Draft">Draft</option>
                  <option value="Open">Open</option>
                  <option value="Closed">Closed</option>
                  <option value="Cancelled">Cancelled</option>
                </Form.Select>
              </Form.Group>
            </div>
          </div>

          <hr />
          <div className="d-flex justify-content-between align-items-center mb-3">
            <h5>GRN Details</h5>
            {!isView && (
              <Button variant="success" size="sm" onClick={addDetail}>
                Add Detail
              </Button>
            )}
          </div>
          
          <div className="table-responsive">
            <Table bordered size="sm">
              <thead>
                <tr>
                  <th style={{width: '50px'}}>#</th>
                  <th style={{width: '200px'}}>Item *</th>
                  <th style={{width: '100px'}}>Ordered</th>
                  <th style={{width: '100px'}}>Received</th>
                  <th style={{width: '100px'}}>Accepted</th>
                  <th style={{width: '100px'}}>Rejected</th>
                  <th style={{width: '120px'}}>Batch No</th>
                  <th style={{width: '120px'}}>Expiry</th>
                  {!isView && <th style={{width: '80px'}}>Actions</th>}
                </tr>
              </thead>
              <tbody>
                {details.length === 0 ? (
                  <tr>
                    <td colSpan={isView ? 8 : 9} className="text-center text-muted">
                      No details added yet
                    </td>
                  </tr>
                ) : (
                  details.map((row, idx) => (
                    <tr key={idx}>
                      <td>{idx + 1}</td>
                      <td>
                        {isView ? (
                          <span>{getItemName(row.itemid)}</span>
                        ) : (
                          <Form.Select 
                            value={row.itemid} 
                            onChange={(e) => handleDetailChange(idx, 'itemid', e.target.value)}
                          >
                            <option value=''>--Select--</option>
                            {itemOptions.map(item => (
                              <option key={item.itemid} value={item.itemid}>
                                {item.itemname}
                              </option>
                            ))}
                          </Form.Select>
                        )}
                      </td>
                      <td>
                        <Form.Control 
                          type="number" 
                          value={row.orderedQty} 
                          onChange={(e) => handleDetailChange(idx, 'orderedQty', +e.target.value)} 
                          disabled={isView}
                          min="0"
                        />
                      </td>
                      <td>
                        <Form.Control 
                          type="number" 
                          value={row.receivedQty} 
                          onChange={(e) => handleDetailChange(idx, 'receivedQty', +e.target.value)} 
                          disabled={isView}
                          min="0"
                        />
                      </td>
                      <td>
                        <Form.Control 
                          type="number" 
                          value={row.acceptedQty} 
                          onChange={(e) => handleDetailChange(idx, 'acceptedQty', +e.target.value)} 
                          disabled={isView}
                          min="0"
                        />
                      </td>
                      <td>
                        <Form.Control 
                          type="number" 
                          value={row.rejectedQty} 
                          onChange={(e) => handleDetailChange(idx, 'rejectedQty', +e.target.value)} 
                          disabled={isView}
                          min="0"
                        />
                      </td>
                      <td>
                        <Form.Control 
                          type="text" 
                          value={row.batchNo} 
                          onChange={(e) => handleDetailChange(idx, 'batchNo', e.target.value)} 
                          disabled={isView}
                        />
                      </td>
                      <td>
                        <Form.Control 
                          type="date" 
                          value={row.expiryDate} 
                          onChange={(e) => handleDetailChange(idx, 'expiryDate', e.target.value)} 
                          disabled={isView}
                        />
                      </td>
                      {!isView && (
                        <td>
                          <Button 
                            size="sm" 
                            variant="danger" 
                            onClick={() => removeDetail(idx)}
                          >
                            Delete
                          </Button>
                        </td>
                      )}
                    </tr>
                  ))
                )}
              </tbody>
            </Table>
          </div>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onHide} disabled={loading}>
          Close
        </Button>
        {!isView && (
          <Button variant="primary" onClick={handleSave} disabled={loading}>
            {loading ? 'Saving...' : 'Save'}
          </Button>
        )}
      </Modal.Footer>
    </Modal>
  );
};

export default GrnFormModal;
