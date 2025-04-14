// OUChangePasswordModal.js
import React, { useState } from 'react';
import { Modal, Button, Form, Alert } from 'react-bootstrap';
import axios from 'axios';

const OUChangePasswordModal = ({ show, onHide }) => {
  const [email, setEmail] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [message, setMessage] = useState('');

  const handleChangePassword = async () => {
    try {
      await axios.post('http://localhost:8080/api/ouuser/change-password', {
        email,
        password: newPassword,
      });
      setMessage('Password updated successfully!');
    } catch (err) {
      setMessage('Failed to update password.');
    }
  };

  const handleReset = () => {
    setEmail('');
    setNewPassword('');
    setMessage('');
  };

  return (
    <Modal show={show} onHide={onHide}>
      <Modal.Header closeButton>
        <Modal.Title>Change Password</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {message && <Alert variant={message.includes('successfully') ? 'success' : 'danger'}>{message}</Alert>}
        <Form>
          <Form.Group className="mb-3">
            <Form.Label>Email ID</Form.Label>
            <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
          </Form.Group>
          <Form.Group className="mb-3">
            <Form.Label>New Password</Form.Label>
            <Form.Control type="password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleReset}>Reset</Button>
        <Button variant="primary" onClick={handleChangePassword}>Submit</Button>
      </Modal.Footer>
    </Modal>
  );
};

export default OUChangePasswordModal;
