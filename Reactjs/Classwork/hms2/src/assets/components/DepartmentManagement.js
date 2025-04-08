import React, { useEffect, useState } from "react";
import { Table, Button, Modal, Form, Pagination, Toast } from "react-bootstrap";
import axios from "axios";

const DepartmentManagement = () => {
    const [departments, setDepartments] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [showViewModal, setShowViewModal] = useState(false);
    const [showDeleteModal, setShowDeleteModal] = useState(false);
    const [currentDepartment, setCurrentDepartment] = useState(null);
    const [search, setSearch] = useState("");
    const [page, setPage] = useState(0);
    const [size, setSize] = useState(5);
    const [totalPages, setTotalPages] = useState(1);
    const [showToast, setShowToast] = useState(false);
    const [toastMessage, setToastMessage] = useState("");

    const userId = sessionStorage.getItem('userid');
    const useremailid = sessionStorage.getItem('useremailid');
    const userstatus = sessionStorage.getItem('userstatus');

    useEffect(() => {
        fetchDepartments();
    }, [page, search]);

    // useEffect(() => {
    //     if (currentDepartment) {
    //         setShowViewModal(true);
    //     }
    // }, [currentDepartment]);

    const fetchDepartments = async () => {
        try {
            const response = await axios.get(
                `http://localhost:8080/api/departments?search=${search}&page=${page}&size=${size}`
            );
            setDepartments(response.data.content);
            setTotalPages(response.data.totalPages);
        } catch (error) {
            console.error("Error fetching departments:", error);
        }
    };

    const handleShowModal = (department = null) => {
        setCurrentDepartment(department);
        setShowModal(true);
    };

    const handleSave = async (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        const data = Object.fromEntries(formData.entries());
        data.lastaddeditby = userId;

        try {
            if (currentDepartment) {
                await axios.put(`http://localhost:8080/api/departments/${currentDepartment.deptid}`, data);
                setToastMessage("Department updated successfully!");
            } else {
                await axios.post("http://localhost:8080/api/departments", data);
                setToastMessage("Department added successfully!");
            }
            fetchDepartments();
            setShowModal(false);
            setShowToast(true);
        } catch (error) {
            console.error("Error saving department:", error);
        }
    };

    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:8080/api/departments/${currentDepartment.deptid}`);
            setToastMessage("Department deleted successfully!");
            fetchDepartments();
            setShowDeleteModal(false);
            setShowToast(true);
        } catch (error) {
            console.error("Error deleting department:", error);
        }
    };

    return (
        <div className="container mt-4">
            <h2>Department Management</h2>
            <input
                type="text"
                className="form-control mb-3"
                placeholder="Search departments..."
                value={search}
                onChange={(e) => setSearch(e.target.value)}
            />
            <Button onClick={() => handleShowModal()} className="mb-3">Add Department</Button>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Head</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {departments.map((dept) => (
                        <tr key={dept.deptid}>
                            <td>{dept.deptid}</td>
                            <td>{dept.deptname}</td>
                            <td>{dept.deptheadname}</td>
                            <td>{dept.activestatus}</td>
                            <td>
                                {/* <Button variant="info" onClick={() => { setCurrentDepartment(dept); setShowViewModal(true); }}>View</Button> */}
                                <Button
                                    variant="info"
                                    onClick={() => {
                                        setCurrentDepartment(dept);
                                        setShowViewModal(true);  // Opens only when clicking View
                                    }}
                                >
                                    View
                                </Button>

                                <Button
                                    variant="warning"
                                    onClick={() => {
                                        setCurrentDepartment(dept);
                                        setShowModal(true);  // Opens only when clicking Edit
                                    }}
                                >
                                    Edit
                                </Button>

                                <Button
                                    variant="danger"
                                    onClick={() => {
                                        setCurrentDepartment(dept);
                                        setShowDeleteModal(true);  // Opens only when clicking Delete
                                    }}
                                >
                                    Delete
                                </Button>

                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
            <Pagination>
                {[...Array(totalPages).keys()].map((num) => (
                    <Pagination.Item key={num} active={num === page} onClick={() => setPage(num)}>{num + 1}</Pagination.Item>
                ))}
            </Pagination>

            <Modal show={showModal} onHide={() => setShowModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>{currentDepartment ? "Edit Department" : "Add Department"}</Modal.Title>
                </Modal.Header>
                <Form onSubmit={handleSave}>
                    <Modal.Body>
                        <Form.Group>
                            <Form.Label>Name</Form.Label>
                            <Form.Control name="deptname" defaultValue={currentDepartment?.deptname || ""} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Head Name</Form.Label>
                            <Form.Control name="deptheadname" defaultValue={currentDepartment?.deptheadname || ""} required />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Status</Form.Label>
                            {/* <Form.Control name="activestatus" defaultValue={currentDepartment?.activestatus || "Active"} required /> */}
                            <Form.Control as="select" name="activestatus" defaultValue={currentDepartment?.activestatus || "Active"} required>
                                <option value="Active">Active</option>
                                <option value="Inactive">Inactive</option>
                            </Form.Control>

                        </Form.Group>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button type="submit">Save</Button>
                        <Button variant="secondary" onClick={() => setShowModal(false)}>Cancel</Button>
                    </Modal.Footer>
                </Form>
            </Modal>

            <Modal show={showDeleteModal} onHide={() => setShowDeleteModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Confirm Delete</Modal.Title>
                </Modal.Header>
                <Modal.Body>Are you sure you want to delete this department?</Modal.Body>
                <Modal.Footer>
                    <Button variant="danger" onClick={handleDelete}>Delete</Button>
                    <Button variant="secondary" onClick={() => setShowDeleteModal(false)}>Cancel</Button>
                </Modal.Footer>
            </Modal>

            <Toast show={showToast} onClose={() => setShowToast(false)} delay={3000} autohide>
                <Toast.Body>{toastMessage}</Toast.Body>
            </Toast>

            <Modal show={showViewModal} onHide={() => setShowViewModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>Department Details</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {currentDepartment ? (
                        <>
                            <p><strong>ID:</strong> {currentDepartment.deptid}</p>
                            <p><strong>Name:</strong> {currentDepartment.deptname}</p>
                            <p><strong>Head Name:</strong> {currentDepartment.deptheadname}</p>
                            <p><strong>Status:</strong> {currentDepartment.activestatus}</p>
                        </>
                    ) : (
                        <p>No department data available.</p>
                    )}
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => setShowViewModal(false)}>Close</Button>
                </Modal.Footer>
            </Modal>

        </div>
    );
};

export default DepartmentManagement;
