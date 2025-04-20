import React, { useState, useEffect } from 'react';
import { addDesignation, updateDesignation } from './DesignationService';
import { Button, Form, Toast, ToastContainer } from 'react-bootstrap';

const DesignationForm = ({ selected, onSaveComplete }) => {
  const [form, setForm] = useState({
    designationname: '',
    dutytype: 'General',
    lastaddeditby: sessionStorage.getItem('userid')
  });
  const [toastMsg, setToastMsg] = useState('');
  const [errorMsg, setErrorMsg] = useState('');

  useEffect(() => {
    if (selected) {
      setForm({
        designationname: selected.designationname || '',
        dutytype: selected.dutytype || 'General',
        lastaddeditby: sessionStorage.getItem('userid')
      });
    }
  }, [selected]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const save = selected
      ? updateDesignation(selected.designationid, form)
      : addDesignation(form);

    save
      .then(() => {
        setToastMsg('Designation saved successfully.');
        setForm({
          designationname: '',
          dutytype: 'General',
          lastaddeditby: sessionStorage.getItem('userid')
        });
        onSaveComplete();
      })
      .catch(err => {
        setErrorMsg('Error saving designation');
        console.error(err);
      });
  };

  return (
    <>
      <ToastContainer position="top-start" className="p-3">
        <Toast bg="success" show={!!toastMsg} delay={3000} autohide onClose={() => setToastMsg('')}>
          <Toast.Body className="text-white">{toastMsg}</Toast.Body>
        </Toast>
        {errorMsg && (
          <Toast bg="danger" show delay={5000} autohide onClose={() => setErrorMsg('')}>
            <Toast.Body className="text-white">{errorMsg}</Toast.Body>
          </Toast>
        )}
      </ToastContainer>

      <Form onSubmit={handleSubmit}>
        <h4>{selected ? 'Edit' : 'Add'} Designation</h4>

        <Form.Group className="mb-3">
          <Form.Label>Designation Name</Form.Label>
          <Form.Control
            type="text"
            name="designationname"
            value={form.designationname}
            onChange={handleChange}
            required
          />
        </Form.Group>

        <Form.Group className="mb-3">
          <Form.Label>Duty Type</Form.Label>
          <Form.Control
            as="select"
            name="dutytype"
            value={form.dutytype}
            onChange={handleChange}
            required
          >
            <option value="General">General</option>
            <option value="Shift">Shift</option>
          </Form.Control>
        </Form.Group>

        <Button type="submit" variant="primary">Save</Button>{' '}
        <Button
          type="button"
          variant="secondary"
          onClick={() =>
            setForm({
              designationname: '',
              dutytype: 'General',
              lastaddeditby: sessionStorage.getItem('userid')
            })
          }
        >
          Reset
        </Button>
      </Form>
    </>
  );
};

export default DesignationForm;
