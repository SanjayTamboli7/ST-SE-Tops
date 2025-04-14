// OULogin.js
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Form, Modal, Alert } from 'react-bootstrap';
import OUChangePasswordModal from './OUChangePasswordModal';
import axios from 'axios';

const OULogin = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showChangePassword, setShowChangePassword] = useState(false);
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/ouuser/login', {
        email,
        password,
      });
      if (response.data) {
        localStorage.setItem('ouserdata', JSON.stringify(response.data));
        navigate('/home');
      } else {
        setError('Invalid credentials');
      }
    } catch (err) {
      setError('Invalid credentials');
    }
  };

  const handleReset = () => {
    setEmail('');
    setPassword('');
    setError('');
  };

  return (
    <div className="container mt-5" style={{ maxWidth: '400px' }}>
      <h3 className="text-center mb-3">OU Login</h3>
      {error && <Alert variant="danger">{error}</Alert>}
      <Form>
        <Form.Group className="mb-3">
          <Form.Label>Email ID</Form.Label>
          <Form.Control type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </Form.Group>
        <div className="d-flex justify-content-between">
          <Button variant="primary" onClick={handleLogin}>Login</Button>
          <Button variant="secondary" onClick={handleReset}>Reset</Button>
        </div>
      </Form>
      <div className="mt-3 d-flex justify-content-between">
        <Button variant="link" onClick={() => setShowChangePassword(true)}>Change Password</Button>
        <Button variant="link" onClick={() => navigate('/forgot-password')}>Forgot Password?</Button>
      </div>

      <OUChangePasswordModal show={showChangePassword} onHide={() => setShowChangePassword(false)} />
    </div>
  );
};

export default OULogin;
