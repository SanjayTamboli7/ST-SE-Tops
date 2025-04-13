// src/components/HolidayFormModal.js
import React, { useState, useEffect } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

const HOLIDAY_TYPES = ['State', 'National', 'Religious', 'Company', 'Emergency'];

const HolidayFormModal = ({ show, handleClose, handleSave, isEdit, initialData, holidays }) => {
    const [form, setForm] = useState({
        holidaydate: '',
        holidayname: '',
        holidaytype: '',
        holidaydescription: '',
        lastaddeditby: 1,
    });
    const [error, setError] = useState('');

    useEffect(() => {
        if (isEdit && initialData) {
            setForm(initialData);
        } else {
            setForm({
                holidaydate: '',
                holidayname: '',
                holidaytype: '',
                holidaydescription: '',
                lastaddeditby: 1,
            });
        }
        setError('');
    }, [show]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm(prev => ({ ...prev, [name]: value }));
    };

    const onSubmit = () => {
        if (!form.holidaydate || !form.holidayname || !form.holidaytype) {
            setError('Please fill in all required fields.');
            return;
        }
        if (!isEdit && holidays.find(h => h.holidaydate === form.holidaydate)) {
            setError('A holiday already exists for this date.');
            return;
        }
        handleSave(form);
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>{isEdit ? 'Edit Holiday' : 'Add Holiday'}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {error && <div className="text-danger mb-2">{error}</div>}
                <Form>
                    {/* <Form.Group controlId="holidaydate">
            <Form.Label>Holiday Date</Form.Label>
            <Form.Control type="date" name="holidaydate" value={form.holidaydate} onChange={handleChange} disabled={isEdit} />
          </Form.Group> */}
                    <Form.Group controlId="holidaydate">
                        <Form.Label>Holiday Date</Form.Label>
                        <Form.Control
                            type="date"
                            name="holidaydate"
                            value={form.holidaydate}
                            onChange={handleChange}
                            disabled={isEdit}
                            min={new Date().toISOString().split('T')[0]} // Disable past dates
                        />
                    </Form.Group>
                    <Form.Group controlId="holidayname">
                        <Form.Label>Holiday Name</Form.Label>
                        <Form.Control type="text" name="holidayname" value={form.holidayname} onChange={handleChange} />
                    </Form.Group>

                    <Form.Group controlId="holidaytype">
                        <Form.Label>Holiday Type</Form.Label>
                        <Form.Select name="holidaytype" value={form.holidaytype} onChange={handleChange}>
                            <option value="">Select Type</option>
                            {HOLIDAY_TYPES.map(type => <option key={type}>{type}</option>)}
                        </Form.Select>
                    </Form.Group>

                    <Form.Group controlId="holidaydescription">
                        <Form.Label>Description</Form.Label>
                        <Form.Control
                            as="textarea"
                            rows={3}
                            name="holidaydescription"
                            value={form.holidaydescription}
                            onChange={handleChange}
                        />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>Cancel</Button>
                <Button variant="primary" onClick={onSubmit}>{isEdit ? 'Update' : 'Save'}</Button>
            </Modal.Footer>
        </Modal>
    );
};

export default HolidayFormModal;
