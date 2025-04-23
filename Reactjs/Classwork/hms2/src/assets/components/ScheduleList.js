// ScheduleList.js
import React, { useState, useEffect } from "react";
import axios from "axios";
import { Modal, Button, Form } from "react-bootstrap";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function ScheduleList() {
    const [scheduleList, setScheduleList] = useState([]);
    const [userList, setUserList] = useState([]);
    const [userMap, setUserMap] = useState({});
    const [designationMap, setDesignationMap] = useState({});
    const [showModal, setShowModal] = useState(false);
    const [formData, setFormData] = useState({
        schuserid: "",
        schdesignationid: "",
        scheduledate: "",
        fromtime: "",
        totime: "",
        attendance: "Yes",
        lastaddeditby: 1,
    });
    const [isEditMode, setIsEditMode] = useState(false);
    const [editId, setEditId] = useState(null);
    const [searchTerm, setSearchTerm] = useState("");
    const [pagination, setPagination] = useState({ page: 0, size: 5, totalPages: 0 });

    const fetchDesignations = async (designationId) => {
        try {
            const res = await axios.get(`http://localhost:8080/api/designations/${designationId}`);
            return res.data;
        } catch (error) {
            console.error("Error fetching designations", error);
            throw error;
        }
    };

    const fetchSchedules = async () => {
        try {
            const url = searchTerm.trim()
                ? `http://localhost:8080/api/schedules/search-v2?keyword=${searchTerm}&page=${pagination.page}&size=${pagination.size}`
                : `http://localhost:8080/api/schedules?page=${pagination.page}&size=${pagination.size}`;

            const res = await axios.get(url);
            setScheduleList(res.data.content);
            setPagination(prev => ({ ...prev, totalPages: res.data.totalPages }));
        } catch (error) {
            console.error("Error fetching schedules", error);
            toast.error("Failed to fetch schedules");
        }
    };

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        const res = await axios.get("http://localhost:8080/api/otherusers");
        const users = res.data.content || [];
        setUserList(users);

        // Build map: schuserid -> ousername
        const map = {};
        users.forEach(user => {
            map[user.ouserid] = user.ousername;
        });
        setUserMap(map);
    };

    useEffect(() => {
        fetchSchedules();
    }, [pagination.page, searchTerm]);

    useEffect(() => {
        setPagination(prev => ({ ...prev, page: 0 }));
    }, [searchTerm]);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleUserChange = async (e) => {
        const schuserid = e.target.value;
        setFormData(prev => ({ ...prev, schuserid }));

        try {
            const userRes = await axios.get(`http://localhost:8080/api/otherusers/${schuserid}`);
            const user = userRes.data;
            const designationRes = await axios.get(`http://localhost:8080/api/designations/${user.ouserdesignationid}`);
            const designation = designationRes.data;

            setFormData(prev => ({
                ...prev,
                schdesignationid: designation.designationid
            }));

            setDesignationMap(prev => ({
                ...prev,
                [designation.designationid]: designation.designationname
            }));
        } catch {
            toast.error("Failed to fetch user/designation details");
        }
    };

    const openAddModal = () => {
        setIsEditMode(false);
        setEditId(null);
        setFormData({
            schuserid: "",
            schdesignationid: "",
            scheduledate: "",
            fromtime: "",
            totime: "",
            attendance: "Yes",
            lastaddeditby: 1,
        });
        setShowModal(true);
    };

    const handleEdit = (item) => {
        setIsEditMode(true);
        setEditId(item.id);
        setFormData({ ...item });
        setShowModal(true);
    };

    const handleDelete = async (id) => {
        if (window.confirm("Are you sure you want to delete this schedule?")) {
            await axios.delete(`http://localhost:8080/api/schedules/${id}`);
            toast.success("Deleted successfully");
            fetchSchedules();
        }
    };

    const handleSubmit = async () => {
        if (!formData.schuserid || !formData.scheduledate || !formData.fromtime || !formData.totime) {
            toast.warning("Please fill all required fields");
            return;
        }
        try {
            if (isEditMode && editId) {
                await axios.put(`http://localhost:8080/api/schedules/${editId}`, formData);
            } else {
                await axios.post("http://localhost:8080/api/schedules", formData);
            }
            toast.success("Saved successfully");
            setShowModal(false);
            fetchSchedules();
        } catch (err) {
            toast.error(err.response?.data?.message || "Error saving schedule");
        }
        // Inside handleSubmit(), modify validation:
        if (!formData.schuserid || !formData.scheduledate || !formData.fromtime || !formData.totime) {
            toast.warning("Please fill all required fields");
            return;
        }

        // Only validate future date during *Add* mode
        if (!isEditMode) {
            const selectedDate = new Date(formData.scheduledate);
            const today = new Date();
            today.setHours(0, 0, 0, 0);

            if (selectedDate < today) {
                toast.warning("You can only add schedules for current or future dates.");
                return;
            }
        }
    };

    const handleAttendanceChange = async (e, item) => {
        const updated = { ...item, attendance: e.target.value };

        try {
            console.log("Updating Attendance:", updated);
            await axios.put(`http://localhost:8080/api/schedules/${item.schid}`, updated);
            fetchSchedules();
        } catch (err) {
            console.error("Failed to update attendance:", err.response?.data || err);
            toast.error("Failed to update attendance");
        }
    };

    return (
        <div className="container mt-4">
            <div className="d-flex justify-content-between align-items-center mb-3">
                <h4>Schedule List</h4>
                <Button onClick={openAddModal}>Add Schedule</Button>
            </div>

            <Form.Control
                type="text"
                placeholder="Search by name or designation"
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="mb-3"
            />

            <table className="table table-bordered table-hover">
                <thead className="table-dark">
                    <tr>
                        <th>#</th>
                        <th>User</th>
                        <th>Designation</th>
                        <th>Date</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Attendance</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {scheduleList.length > 0 ? scheduleList.map((item, i) => (
                        <tr key={item.id || i}>
                            {/* <td>{i + 1}</td> */}
                            <td>{item.schid}</td>
                            {/* <td>{item.username}</td> */}
                            <td>{userMap[item.schuserid] || "N/A"}</td>
                            <td>{item.designationname || designationMap[item.schdesignationid]}</td>
                            <td>{item.scheduledate}</td>
                            <td>{item.fromtime}</td>
                            <td>{item.totime}</td>
                            <td>
                                <Form.Select
                                    value={item.attendance || ""}
                                    onChange={(e) => handleAttendanceChange(e, item)}
                                >
                                    <option value="">--Select--</option>
                                    <option value="Yes">Yes</option>
                                    <option value="No">No</option>
                                </Form.Select>
                            </td>
                            <td>
                                <Button variant="warning" size="sm" onClick={() => handleEdit(item)}>Edit</Button>{" "}
                                <Button variant="danger" size="sm" onClick={() => handleDelete(item.schid)}>Delete</Button>
                            </td>
                        </tr>
                    )) : (
                        <tr>
                            <td colSpan="8" className="text-center">No schedules found</td>
                        </tr>
                    )}
                </tbody>
            </table>

            {/* Pagination */}
            {[...Array(pagination.totalPages).keys()]
                .filter(num => Math.abs(num - pagination.page) <= 2 || num === 0 || num === pagination.totalPages - 1)
                .map((num, i, arr) => {
                    const prev = arr[i - 1];
                    const showDots = prev !== undefined && num - prev > 1;

                    return (
                        <React.Fragment key={num}>
                            {showDots && <span className="mx-1">...</span>}
                            <Button
                                variant={pagination.page === num ? "primary" : "outline-primary"}
                                size="sm"
                                onClick={() => setPagination(prev => ({ ...prev, page: num }))}
                            >
                                {num + 1}
                            </Button>
                        </React.Fragment>
                    );
                })}

            <Modal show={showModal} onHide={() => setShowModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>{isEditMode ? "Edit" : "Add"} Schedule</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>User</Form.Label>
                            <Form.Select
                                name="schuserid"
                                value={formData.schuserid}
                                onChange={handleUserChange}
                            >
                                <option value="">--Select--</option>
                                {userList.map(user => (
                                    <option key={user.ouserid} value={user.ouserid}>
                                        {user.ousername}
                                    </option>
                                ))}
                            </Form.Select>
                        </Form.Group>

                        <Form.Group className="mt-2">
                            <Form.Label>Designation</Form.Label>
                            <Form.Control
                                value={designationMap[formData.schdesignationid] || ""}
                                readOnly
                            />
                        </Form.Group>
                        <Form.Control
                            type="date"
                            name="scheduledate"
                            value={formData.scheduledate}
                            onChange={handleInputChange}
                            min={new Date().toISOString().split("T")[0]} // disables past
                        />
                        <Form.Group className="mt-2">
                            <Form.Label>From Time</Form.Label>
                            <Form.Control
                                type="time"
                                name="fromtime"
                                value={formData.fromtime}
                                onChange={handleInputChange}
                            />
                        </Form.Group>

                        <Form.Group className="mt-2">
                            <Form.Label>To Time</Form.Label>
                            <Form.Control
                                type="time"
                                name="totime"
                                value={formData.totime}
                                onChange={handleInputChange}
                            />
                        </Form.Group>
                        {isEditMode && (
                            <Form.Group className="mt-2">
                                <Form.Label>Attendance</Form.Label>
                                <Form.Select
                                    name="attendance"
                                    value={formData.attendance}
                                    onChange={handleInputChange}
                                >
                                    <option value="Yes">Yes</option>
                                    <option value="No">No</option>
                                </Form.Select>
                            </Form.Group>
                        )}
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => setShowModal(false)}>Cancel</Button>
                    <Button variant="primary" onClick={handleSubmit}>Save</Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default ScheduleList;
