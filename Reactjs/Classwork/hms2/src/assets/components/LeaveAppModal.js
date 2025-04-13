import React, { useState, useEffect } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

const LeaveAppModal = ({ show, handleClose, handleSave, formData, setFormData, isViewOnly = false }) => {
  const leaveTypes = ["Casual", "Sick", "Privilege", "Maternity", "Paternity"];
  const leaveStatuses = ["Pending", "Approved", "Rejected", "Withdrawn"];
  const fullHalfOptions = ["Full", "Half"];

  useEffect(() => {
    if (!formData.leaveappid && show && !isViewOnly) {
      const today = new Date().toISOString().split('T')[0];
      setFormData((prev) => ({
        ...prev,
        leaveappdate: today,
        leavefromdate: today,
        leavetodate: today,
        lastaddeditby: sessionStorage.getItem('userid')
      }));
    }
  }, [show]);

  const handleChange = (e) => {
    if (isViewOnly) return;

    const { name, value } = e.target;
    if (name === 'leavefromdate') {
      setFormData((prev) => ({
        ...prev,
        leavefromdate: value,
        leavetodate: value > prev.leavetodate ? value : prev.leavetodate
      }));
    } else if (name === 'leavetodate') {
      if (value < formData.leavefromdate) {
        alert('To Date cannot be before From Date');
        return;
      }
      setFormData({ ...formData, [name]: value });
    } else {
      setFormData({ ...formData, [name]: value });
    }
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>
          {isViewOnly ? 'View Leave Application' : (formData.leaveappid ? 'Edit' : 'Add') + ' Leave Application'}
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group className="mb-2">
            <Form.Label>Leave App Date</Form.Label>
            <Form.Control type="date" name="leaveappdate" value={formData.leaveappdate || ''} onChange={handleChange} disabled={isViewOnly} />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Leave Type</Form.Label>
            <Form.Select name="leaveapptype" value={formData.leaveapptype || ''} onChange={handleChange} disabled={isViewOnly}>
              <option value="">Select</option>
              {leaveTypes.map((type, i) => <option key={i} value={type}>{type}</option>)}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>From Date</Form.Label>
            <Form.Control type="date" name="leavefromdate" value={formData.leavefromdate || ''} onChange={handleChange} disabled={isViewOnly} />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>To Date</Form.Label>
            <Form.Control type="date" name="leavetodate" value={formData.leavetodate || ''} onChange={handleChange} disabled={isViewOnly} />
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Full/Half Flag</Form.Label>
            <Form.Select name="leavefullhalfflag" value={formData.leavefullhalfflag || ''} onChange={handleChange} disabled={isViewOnly}>
              <option value="">Select</option>
              {fullHalfOptions.map((flag, i) => <option key={i} value={flag}>{flag}</option>)}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Status</Form.Label>
            <Form.Select name="leaveappstatus" value={formData.leaveappstatus || ''} onChange={handleChange} disabled={isViewOnly}>
              <option value="">Select</option>
              {leaveStatuses.map((status, i) => <option key={i} value={status}>{status}</option>)}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2">
            <Form.Label>Remark</Form.Label>
            <Form.Control as="textarea" name="leaveappremark" rows={3} value={formData.leaveappremark || ''} onChange={handleChange} disabled={isViewOnly} />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleClose}>Close</Button>
        {!isViewOnly && (
          <Button variant="primary" onClick={handleSave}>Save</Button>
        )}
      </Modal.Footer>
    </Modal>
  );
};

export default LeaveAppModal;
