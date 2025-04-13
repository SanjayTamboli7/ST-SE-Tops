// OtherUserForm.js
import React, { useEffect, useState } from 'react';
import { Button, Form, FormGroup, Label, Input } from 'reactstrap';
import { getUserById, saveUser, updateUser } from './OtherAPI';
import { getDepartments } from './OtherAPI';
import { getDesignations } from './OtherAPI';

const OtherUserForm = ({ userId, mode, onClose }) => {
  // const sessionUser = sessionStorage.getItem('userid');
  const [user, setUser] = useState({
    ousername: '',
    ouserdeptid: '',
    ouserdesignationid: '',
    ousercontactno: '',
    ouseremailid: '',
    ouserstatus: 1,
    lastaddeditby: sessionStorage.getItem('userid'),
  });
  const [departments, setDepartments] = useState([]);
  const [designations, setDesignations] = useState([]);

  const readOnly = mode === 'view';

  useEffect(() => {
    getDepartments().then(res => setDepartments(res.data.content));
    getDesignations().then(res => setDesignations(res.data.content));

    if ((mode === 'edit' || mode === 'view') && userId) {
      getUserById(userId).then(res => setUser(res.data));
    }
  }, [userId, mode]);

  const handleChange = e => {
    const { name, value } = e.target;
    let newValue = value;
  
    // convert specific fields to number
    if (["ouserdeptid", "ouserdesignationid", "ouserstatus"].includes(name)) {
      newValue = parseInt(value, 10);
    }
  
    setUser(prev => ({ ...prev, [name]: newValue }));
  }; 

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      console.log("Submitting user payload:", user);
      if (mode === 'add') {
        await saveUser(user);
      } else if (mode === 'edit') {
        await updateUser(userId, user);
      }
      onClose();
    } catch (error) {
      console.error("Error saving user:", error.response?.data || error.message);
      alert("Failed to save user. See console for details.");
    }
  };
  

  return (
    <Form onSubmit={handleSubmit}>
      <FormGroup>
        <Label>User Name</Label>
        <Input name="ousername" value={user.ousername} onChange={handleChange} readOnly={readOnly} required />
      </FormGroup>
      <FormGroup>
        <Label>Department</Label>
        <Input type="select" name="ouserdeptid" value={user.ouserdeptid} onChange={handleChange} disabled={readOnly} required>
          <option value="">Select Department</option>
          {Array.isArray(departments) && departments.map(dep => (
            <option key={dep.deptid} value={dep.deptid}>{dep.deptname}</option>
          ))}
        </Input>
      </FormGroup>
      <FormGroup>
        <Label>Designation</Label>
        <Input type="select" name="ouserdesignationid" value={user.ouserdesignationid} onChange={handleChange} disabled={readOnly} required>
          <option value="">Select Designation</option>
          {Array.isArray(designations) && designations.map(des => (
            <option key={des.designationid} value={des.designationid}>{des.designationname}</option>
          ))}
        </Input>
      </FormGroup>
      <FormGroup>
        <Label>Contact No</Label>
        <Input name="ousercontactno" value={user.ousercontactno} onChange={handleChange} readOnly={readOnly} required />
      </FormGroup>
      <FormGroup>
        <Label>Email ID</Label>
        <Input name="ouseremailid" type="email" value={user.ouseremailid} onChange={handleChange} readOnly={readOnly} required />
      </FormGroup>
      <FormGroup>
        <Label>Password</Label>
        <Input
          type="password"
          name="ouserpassword"
          value={user.ouserpassword || ''}
          onChange={handleChange}
          required
        />
      </FormGroup>
      <FormGroup>
        <Label>Status</Label>
        <Input type="select" name="ouserstatus" value={user.ouserstatus} onChange={handleChange} disabled={readOnly} required>
          <option value={1}>Active</option>
          <option value={0}>Inactive</option>
        </Input>
      </FormGroup>
      {!readOnly && <Button color="success" type="submit">{mode === 'edit' ? 'Update' : 'Save'}</Button>}
    </Form>
  );
};

export default OtherUserForm;
