// OUForgotPassword.js
import React, { useState } from 'react';
import { Form, Button, Alert } from 'react-bootstrap';

const OUForgotPassword = () => {
  const [email, setEmail] = useState('');
  const [msg, setMsg] = useState('');

  const handleReset = () => {
    setEmail('');
    setMsg('');
  };

  const handleSubmit = () => {
    // Logic to trigger email/OTP etc. to reset password
    setMsg('If your email is valid, password reset instructions will be sent.');
  };

  return (
    <div className="container mt-5" style={{ maxWidth: '400px' }}>
      <h4>Forgot Password</h4>
      {msg && <Alert variant="info">{msg}</Alert>}
      <Form>
        <Form.Group className="mb-3">
          <Form.Label>Email ID</Form.Label>
          <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        </Form.Group>
        <div className="d-flex justify-content-between">
          <Button variant="primary" onClick={handleSubmit}>Submit</Button>
          <Button variant="secondary" onClick={handleReset}>Reset</Button>
        </div>
      </Form>
    </div>
  );
};

export default OUForgotPassword;
