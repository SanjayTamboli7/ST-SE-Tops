// src/components/ResetPassword.js
import React, { useState } from "react";
import axios from "axios";
import { Button, Form, Container, Alert } from "react-bootstrap";

const ResetPassword = ({ match }) => {
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [showError, setShowError] = useState(false);

    const handleResetPassword = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/auth/reset-password', {
                password,
                token: match.params.token
            });
            alert("Password reset successfully!");
        } catch (error) {
            setErrorMessage(error.response?.data?.message || 'Error resetting password');
            setShowError(true);
        }
    };

    return (
        <Container className="d-flex justify-content-center align-items-center" style={{ height: '100vh' }}>
            <div className="w-100" style={{ maxWidth: '400px' }}>
                <h2 className="text-center mb-4">Reset Password</h2>
                {showError && <Alert variant="danger">{errorMessage}</Alert>}
                <Form onSubmit={handleResetPassword}>
                    <Form.Group controlId="formPassword">
                        <Form.Label>New Password</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="Enter new password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </Form.Group>
                    <Button variant="primary" type="submit" className="w-100">
                        Reset Password
                    </Button>
                </Form>
            </div>
        </Container>
    );
};

export default ResetPassword;
