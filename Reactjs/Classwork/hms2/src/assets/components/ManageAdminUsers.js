import React, { useState } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import AdminUserList from "./AdminUserList";
import AdminUserForm from "./AdminUserForm";

export default function ManageAdminUsers() {
  const [selectedUser, setSelectedUser] = useState(null);
  const [showForm, setShowForm] = useState(false);

  const handleEdit = (user) => {
    setSelectedUser(user);
    setShowForm(true);
  };

  const handleAdd = () => {
    setSelectedUser(null);
    setShowForm(true);
  };

  const handleSave = () => {
    setShowForm(false);
  };

  return (
    <Container>
      <Row>
        <Col>
          <h4>Admin User Management</h4>
          {!showForm && <Button onClick={handleAdd}>Add User</Button>}
          {showForm ? (
            <AdminUserForm selectedUser={selectedUser} onSave={handleSave} />
          ) : (
            <AdminUserList onEdit={handleEdit} />
          )}
        </Col>
      </Row>
    </Container>
  );
}
