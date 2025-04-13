import React, { useState, useEffect } from 'react';
import { addDesignation, updateDesignation } from './DesignationService';
import { Button, Form, Toast, ToastContainer } from 'react-bootstrap';
import { loadDesignations } from '../utils/designationUtils';

const DesignationForm = ({ selected, onSaveComplete }) => {
  const [form, setForm] = useState({ designationname: '', lastaddeditby: sessionStorage.getItem('userid') });
  const [toastMsg, setToastMsg] = useState('');
  const [designations, setDesignations] = useState([]);
  const [errorMsg, setErrorMsg] = useState('');

useEffect(() => {
  loadDesignations(
    setDesignations,     // local state
    () => {},            // no need for totalPages
    '',                  // search
    0,                   // page
    100,                 // size
    'designationname',   // sortField
    'asc',               // sortDir
    setErrorMsg          // local error state
  );
}, []);
  
  useEffect(() => {
    if (selected) setForm(selected);
  }, [selected]);

  const handleSubmit = (e) => {
    e.preventDefault();
    const save = selected
      ? updateDesignation(selected.designationid, form)
      : addDesignation(form);
    save.then(() => {
      setToastMsg('Designation saved successfully.');
      setForm({ designationname: '', lastaddeditby: sessionStorage.getItem('userid') });
      onSaveComplete();
    });
  };

  return (
    <>
      <ToastContainer position="top-start" className="p-3">
        <Toast bg="success" show={!!toastMsg} delay={3000} autohide onClose={() => setToastMsg('')}>
          <Toast.Body className="text-white">{toastMsg}</Toast.Body>
        </Toast>
      </ToastContainer>

      <Form onSubmit={handleSubmit}>
        <h4>{selected ? 'Edit' : 'Add'} Designation</h4>
        <Form.Group className="mb-3">
          <Form.Label>Designation Name</Form.Label>
          <Form.Control
            type="text"
            value={form.designationname}
            onChange={e => setForm({ ...form, designationname: e.target.value })}
            required
          />
        </Form.Group>
        <Button type="submit" variant="primary">Save</Button>
      </Form>
    </>
  );
};

export default DesignationForm;
