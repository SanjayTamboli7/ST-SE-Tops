import React, { useEffect, useState, useCallback } from "react";
import axios from "axios";
import { Table, Button, Form, Alert, Modal } from "react-bootstrap";

const DepartmentList = () => {

  const [departments, setDepartments] = useState([]);
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);
  const [sortBy, setSortBy] = useState("deptname");
  const [sortOrder, setSortOrder] = useState("asc");
  const [filterStatus, setFilterStatus] = useState("");
  const [alert, setAlert] = useState({ show: false, message: "", variant: "" });
  const [showModal, setShowModal] = useState(false);
  const [formData, setFormData] = useState({ deptname: "", deptheadname: "", activestatus: "Active" });
  const [editMode, setEditMode] = useState(false);
  const [editId, setEditId] = useState(null);

  const useremailid = sessionStorage.getItem('useremailid');
  const userid = sessionStorage.getItem('userid');
  const userstatus = sessionStorage.getItem('userstatus');

  console.log(useremailid);
  console.log(userid);
  console.log(userstatus);
  console.log("Values from DeprtmentList.js");

  const [reload, setReload] = useState(false);

  useEffect(() => {
    fetchDepartments();
    setReload((prev) => !prev);  // 🔥 Force re-render
  }, [page]);
  
  useEffect(() => {
    setPage(0);  // Reset to first page when search changes
    fetchDepartments();
  }, [search, page, sortBy, sortOrder, filterStatus]);

  // const fetchDepartments = useCallback(async () => {
  //   try {
  //     console.log(`Fetching page ${page}, size 5, filter: ${filterStatus}`);
  //     const response = await axios.get("http://localhost:8080/api/departments", {
  //       params: {
  //         page,
  //         size: 5,
  //         search,
  //         sortBy,
  //         sortOrder,
  //         filterStatus
  //       },
  //     });
  //     console.log("Response:", response.data);
  //     setDepartments(response.data.content);
  //     setTotalPages(response.data.totalPages);
  //   } catch (error) {
  //     console.error("Pagination error:", error);
  //     setAlert({ show: true, message: "Error fetching data", variant: "danger" });
  //   }
  // }, [page, search, sortBy, sortOrder, filterStatus]);

  const fetchDepartments = async () => {
    console.log("📡 Fetching Data for Page:", page);  // Debugging
  
    try {
      const response = await axios.get("http://localhost:8080/api/departments", {
        params: { 
          page,  // Make sure this is correctly passed
          size: 5,
          search 
        }
      });
  
      console.log("✅ API Response:", response.data);
      setDepartments(response.data.content);
      setTotalPages(response.data.totalPages);
    } catch (error) {
      console.error("🚨 Error fetching departments:", error);
    }
  };
  
  useEffect(() => {
    fetchDepartments();
  }, [fetchDepartments]);

  useEffect(() => {
    console.log("🌀 Page Changed, Fetching New Data for Page:", page);
  
    if (page >= 0) {  // Prevents running on first load
      fetchDepartments();
    }
  }, [page]);  
  
  // Update these button handlers to be more explicit
  // const handlePrevPage = () => {
  //   const newPage = Math.max(0, page - 1);
  //   console.log(`Moving to previous page: ${newPage}`);
  //   setPage(newPage);
  // };

  // const handleNextPage = () => {
  //   const newPage = page + 1;
  //   console.log(`Moving to next page: ${newPage}`);
  //   setPage(newPage);
  // };

  const handleNextPage = () => {
    if (page + 1 < totalPages) {
      console.log("➡️ Next Page Clicked. Changing to:", page + 1); // Debugging
      setPage(page + 1);
    }
  }; 
  
  const handlePrevPage = () => {
    if (page > 0) {
      setPage((prevPage) => prevPage - 1);
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

  const handleSort = (field) => {
    // If clicking the same field, toggle direction
    if (sortBy === field) {
      setSortOrder(sortOrder === "asc" ? "desc" : "asc");
    } else {
      // If clicking a new field, default to ascending
      setSortBy(field);
      setSortOrder("asc");
    }
  };

  const handleSubmit = async () => {
    // Add userid to the data being sent
    const dataToSubmit = { ...formData, lastaddeditby: userid };

    try {
      if (editMode) {
        await axios.put(`http://localhost:8080/api/departments/${editId}`, dataToSubmit);
        setAlert({ show: true, message: "Department updated successfully", variant: "success" });
      } else {
        await axios.post("http://localhost:8080/api/departments", dataToSubmit);
        setAlert({ show: true, message: "Department added successfully", variant: "success" });
      }
      setShowModal(false);
      fetchDepartments();
    } catch (error) {
      // Error handling as discussed previously
      console.error("Error details:", error);
      const errorMessage = error.response?.data?.message ||
        error.response?.data?.error ||
        error.response?.data ||
        error.message ||
        "Error saving department";

      setAlert({
        show: true,
        message: `Error saving department: ${errorMessage}`,
        variant: "danger"
      });
    }
  };

  return (
    <div className="container mt-4">
      <h2>Department List</h2>
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
            <th onClick={() => handleSort("deptname")} style={{ cursor: 'pointer' }}>
              Department Name {sortBy === "deptname" ? (sortOrder === "asc" ? "↑" : "↓") : ""}
            </th>
            <th onClick={() => handleSort("deptheadname")} style={{ cursor: 'pointer' }}>
              Head Name {sortBy === "deptheadname" ? (sortOrder === "asc" ? "↑" : "↓") : ""}
            </th>
            <th onClick={() => handleSort("activestatus")} style={{ cursor: 'pointer' }}>
              Status {sortBy === "activestatus" ? (sortOrder === "asc" ? "↑" : "↓") : ""}
            </th>
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

      <div className="d-flex justify-content-between align-items-center mt-3">
        <Button 
          disabled={page === 0} 
          onClick={handlePrevPage}
          variant={page === 0 ? "secondary" : "primary"}
        >
          Previous
        </Button>
        <span>
          Page {page + 1} of {totalPages || 1} 
          (Debug: page={page}, totalPages={totalPages})
        </span>
        <Button 
          disabled={page + 1 >= totalPages} 
          onClick={handleNextPage}
          variant={page + 1 >= totalPages ? "secondary" : "primary"}
        >
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
          {/* style={{ display: 'none' }} */}
          <Form.Group className="mb-3">
            <Form.Label>User ID</Form.Label>
            <Form.Control
              type="number"
              value={formData.lastaddeditby || userid}
              onChange={(e) => setFormData({ ...formData, lastaddeditby: userid })}
            />
          </Form.Group>
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
