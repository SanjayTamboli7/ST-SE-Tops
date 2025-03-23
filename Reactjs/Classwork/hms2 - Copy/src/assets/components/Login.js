// src/components/Login.js
import React, { useState } from "react";
import axios from "axios";
import { Button, Form, Container, Alert } from "react-bootstrap";

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [showError, setShowError] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/login', {
                auserEmailId: email,
                auserPassword: password
            });
            // Handle successful login (e.g., save token)
        } catch (error) {
            setErrorMessage(error.response?.data?.message || 'Invalid credentials');
            setShowError(true);
        }
    };

    return (
        <Container className="d-flex justify-content-center align-items-center" style={{ height: '100vh' }}>
            <div className="w-100" style={{ maxWidth: '400px' }}>
                <h2 className="text-center mb-4">Login</h2>
                {showError && <Alert variant="danger">{errorMessage}</Alert>}
                <Form onSubmit={handleLogin}>
                    <Form.Group controlId="formEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control
                            type="email"
                            placeholder="Enter email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </Form.Group>
                    <Form.Group controlId="formPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="Enter password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </Form.Group>
                    <Button variant="primary" type="submit" className="w-100">
                        Login
                    </Button>
                    <div className="mt-3 text-center">
                        <a href="#" onClick={() => window.location.href = '/forgot-password'}>Forgot Password?</a>
                    </div>
                </Form>
            </div>
        </Container>
    );
};

export default Login;
