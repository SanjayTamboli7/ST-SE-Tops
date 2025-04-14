import React, { useState } from "react";
import { Modal, Button, Form } from "react-bootstrap";

const OUForgotPasswordModal = ({ show, handleClose }) => {
  const [email, setEmail] = useState("");

  const handleSubmit = async () => {
    if (!email) {
      alert("Please enter email");
      return;
    }

    // Call your backend logic to handle forgot password
    const response = await fetch("http://localhost:8080/api/ouuser/forgot-password", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email }),
    });

    if (response.ok) {
      alert("Reset instructions sent to your email.");
      handleClose();
    } else {
      alert("Failed to send instructions. Please try again.");
    }
  };

  const handleReset = () => {
    setEmail("");
  };

  return (
    <Modal show={show} onHide={handleClose} centered>
      <Modal.Header closeButton>
        <Modal.Title>Forgot Password</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group>
            <Form.Label>Email ID</Form.Label>
            <Form.Control
              type="email"
              placeholder="Enter your registered email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </Form.Group>

          <div className="d-flex justify-content-between mt-4">
            <Button variant="primary" onClick={handleSubmit}>
              Submit
            </Button>
            <Button variant="secondary" onClick={handleReset}>
              Reset
            </Button>
          </div>
        </Form>
      </Modal.Body>
    </Modal>
  );
};

export default OUForgotPasswordModal;
