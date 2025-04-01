import React, { useEffect, useState } from "react";
import axios from "axios";
import { Table, Button, Form, Alert, Modal } from "react-bootstrap";
import { useUserContext } from '../../UserContext';
import { useContext } from 'react';

const DepartmentList = () => {
  const [departments, setDepartments] = useState([]);
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [sortBy, setSortBy] = useState("deptname");
  const [sortOrder, setSortOrder] = useState("asc");
  const [filterStatus, setFilterStatus] = useState("");
  const [alert, setAlert] = useState({ show: false, message: "", variant: "" });
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({ deptname: "", deptheadname: "", activestatus: "Active" });
  const [editMode, setEditMode] = useState(false);
  const [editId, setEditId] = useState(null);
  const { email, auserid, auserstatus } = useUserContext();

  useEffect(() => {
    fetchDepartments();
  }, [search, page, sortBy, sortOrder, filterStatus]);

  useEffect(() => {
    console.log('🔍 DepartmentList.js - Email:', email);
    console.log('🔍 DepartmentList.js - User ID:', auserid);
    console.log('🔍 DepartmentList.js - User Status:', auserstatus);
  }, [email, auserid, auserstatus]);  // Effect will run when context values change
    
  const fetchDepartments = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/departments", {
        params: { page, size: 5, search, sortBy, sortOrder, filterStatus },
      });
      setDepartments(response.data.content);
      setTotalPages(response.data.totalPages);
    } catch (error) {
      setAlert({ show: true, message: "Error fetching data", variant: "danger" });
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this department?")) {
      try {
        await axios.delete(`http://localhost:8080/api/departments/${id}`);
        setAlert({ show: true, message: "Department deleted successfully", variant: "success" });
        fetchDepartments();
      } catch (error) {
        setAlert({ show: true, message: "Error deleting department", variant: "danger" });
      }
    }
  };

  const handleShowModal = (dept = null) => {
    if (dept) {
      setEditMode(true);
      setEditId(dept.deptid);
      setFormData({ deptname: dept.deptname, deptheadname: dept.deptheadname, activestatus: dept.activestatus });
    } else {
      setEditMode(false);
      setEditId(null);
      setFormData({ deptname: "", deptheadname: "", activestatus: "Active" });
    }
    setShowModal(true);
  };

  const handleCloseModal = () => setShowModal(false);

  const handleSubmit = async () => {
    try {
      if (editMode) {
        await axios.put(`http://localhost:8080/api/departments/${editId}`, formData);
        setAlert({ show: true, message: "Department updated successfully", variant: "success" });
      } else {
        await axios.post("http://localhost:8080/api/departments", formData);
        setAlert({ show: true, message: "Department added successfully", variant: "success" });
      }
      setShowModal(false);
      fetchDepartments();
    } catch (error) {
      setAlert({ show: true, message: "Error saving department", variant: "danger" });
    }
  };

  return (
    <div className="container mt-4">
      <h2>Department List</h2>
      <div>
            <h1>Departments</h1>
            <p>User ID: {auserid !== null ? auserid : "Not Set"}</p>
            <p>User Status: {auserstatus || "Not Set"}</p>            
            {/* Render department list here */}
        </div>      
      {alert.show && <Alert variant={alert.variant}>{alert.message}</Alert>}
      <div className="d-flex mb-3">
        <Form.Control
          type="text"
          placeholder="Search..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
        <Form.Select onChange={(e) => setFilterStatus(e.target.value)} className="mx-2">
          <option value="">All</option>
          <option value="Active">Active</option>
          <option value="Inactive">Inactive</option>
        </Form.Select>
        <Button variant="primary" onClick={() => handleShowModal()} className="ms-auto">Add Department</Button>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th onClick={() => setSortBy("deptname")}>Department Name</th>
            <th onClick={() => setSortBy("deptheadname")}>Head Name</th>
            <th onClick={() => setSortBy("activestatus")}>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {departments.map((dept) => (
            <tr key={dept.deptid}>
              <td>{dept.deptname}</td>
              <td>{dept.deptheadname}</td>
              <td>{dept.activestatus}</td>
              <td>
                <Button variant="warning" size="sm" className="mx-1" onClick={() => handleShowModal(dept)}>Edit</Button>
                <Button variant="danger" size="sm" onClick={() => handleDelete(dept.deptid)}>
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
      <div className="d-flex justify-content-between">
        <Button disabled={page === 0} onClick={() => setPage(page - 1)}>
          Previous
        </Button>
        <span>Page {page + 1} of {totalPages}</span>
        <Button disabled={page + 1 >= totalPages} onClick={() => setPage(page + 1)}>
          Next
        </Button>
      </div>

      {/* Add/Edit Modal */}
      <Modal show={showModal} onHide={handleCloseModal}>
        <Modal.Header closeButton>
          <Modal.Title>{editMode ? "Edit Department" : "Add Department"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label>Department Name</Form.Label>
              <Form.Control type="text" value={formData.deptname} onChange={(e) => setFormData({ ...formData, deptname: e.target.value })} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Head Name</Form.Label>
              <Form.Control type="text" value={formData.deptheadname} onChange={(e) => setFormData({ ...formData, deptheadname: e.target.value })} />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Status</Form.Label>
              <Form.Select value={formData.activestatus} onChange={(e) => setFormData({ ...formData, activestatus: e.target.value })}>
                <option value="Active">Active</option>
                <option value="Inactive">Inactive</option>
              </Form.Select>
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleCloseModal}>Cancel</Button>
          <Button variant="primary" onClick={handleSubmit}>Save</Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default DepartmentList;
