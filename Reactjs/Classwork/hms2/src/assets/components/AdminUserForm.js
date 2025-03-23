import React, { useState, useEffect } from "react";
import { Form, Button } from "react-bootstrap";
import { addUser, updateUser } from "./Api";

const AdminUserForm = ({ selectedUser, onSave }) => {
  const [formData, setFormData] = useState({
    ausername: "",
    auseremailid: "",
    ausercontactno: "",
    auserpassword: "",
    auserstatus: "",
  });

  useEffect(() => {
    if (selectedUser) {
      setFormData(selectedUser);
    }
  }, [selectedUser]);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (selectedUser) {
      await updateUser(selectedUser.auserid, formData);
    } else {
      await addUser(formData);
    }
    onSave();
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group>
        <Form.Label>Username</Form.Label>
        <Form.Control type="text" name="ausername" value={formData.ausername} onChange={handleChange} required />
      </Form.Group>

      <Form.Group>
        <Form.Label>Email</Form.Label>
        <Form.Control type="email" name="auseremailid" value={formData.auseremailid} onChange={handleChange} required />
      </Form.Group>

      <Form.Group>
        <Form.Label>Contact</Form.Label>
        <Form.Control type="text" name="ausercontactno" value={formData.ausercontactno} onChange={handleChange} />
      </Form.Group>

      {!selectedUser && (
        <Form.Group>
          <Form.Label>Password</Form.Label>
          <Form.Control type="password" name="auserpassword" value={formData.auserpassword} onChange={handleChange} required />
        </Form.Group>
      )}

      <Form.Group>
        <Form.Label>Status</Form.Label>
        <Form.Control as="select" name="auserstatus" value={formData.auserstatus} onChange={handleChange}>
          <option value="Active">Active</option>
          <option value="Inactive">Inactive</option>
        </Form.Control>
      </Form.Group>

      <Button type="submit">{selectedUser ? "Update" : "Add"} User</Button>
    </Form>
  );
};

export default AdminUserForm;
