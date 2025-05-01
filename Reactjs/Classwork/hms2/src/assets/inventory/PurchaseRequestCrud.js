import React, { useEffect, useState } from 'react';
import { Modal, Button, Form, Alert, Table } from 'react-bootstrap';
import axios from 'axios';
import moment from 'moment';

const PurchaseRequestCrud = () => {
    const [data, setData] = useState([]);
    const [modalShow, setModalShow] = useState(false);
    const [viewMode, setViewMode] = useState(false);
    const [editMode, setEditMode] = useState(false);
    const [formData, setFormData] = useState(initialFormData());
    const [alert, setAlert] = useState({ message: '', variant: '' });
    const [search, setSearch] = useState('');
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(1);
    const [users, setUsers] = useState(() => []);
    const [items, setItems] = useState(() => []);

    const pageSize = 5;

    useEffect(() => {
        axios.get('http://localhost:8080/api/otherusers')
            .then(res => {
                console.log('Users API Response:', res.data);

                // Normalize the response to an array
                const data = Array.isArray(res.data)
                    ? res.data
                    : res.data.content ?? [];

                setUsers(data);
            })
            .catch(err => {
                console.error('Error fetching users:', err);
                setUsers([]); // fallback to empty array
            });
    }, []);

    function initialFormData() {
        return {
            prid: null,
            requestedby: '',
            itemid: '',
            qty: '',
            requestdate: moment().format('YYYY-MM-DD'),
            status: 'Pending',
        };
    }

    const fetchData = () => {
        axios.get(`http://localhost:8080/api/purchaserequests?page=${page}&size=${pageSize}&search=${search}`)
            .then(res => {
                setData(res.data.content);
                setTotalPages(res.data.totalPages);
            });
    };

    const fetchUsers = () => {
        axios.get('http://localhost:8080/api/otherusers')
            .then(res => {
                console.log('Users API Response:', res.data);
                const data = Array.isArray(res.data) ? res.data : res.data.content ?? [];
                setUsers(data);
            })
            .catch(err => {
                console.error('Error fetching users:', err);
                setUsers([]);
            });
    };

    const fetchItems = () => {
        axios.get('http://localhost:8080/api/items')
            .then(res => {
                console.log('Items API Response:', res.data);
                const data = Array.isArray(res.data) ? res.data : res.data.content ?? [];
                setItems(data);
            })
            .catch(err => {
                console.error('Error fetching items:', err);
                setItems([]); // Fallback to empty array
            });
    };

    useEffect(() => {
        fetchData();
        fetchUsers();
        fetchItems();
    }, [page, search]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSave = () => {
        // Validation
        const { requestedby, itemid, qty, requestdate, status } = formData;
        if (!requestedby || !itemid || !qty || !requestdate || !status) {
            showAlert('All fields are required.', 'danger');
            return;
        }

        const payload = {
            ...formData,
            lastaddeditby: sessionStorage.getItem('userid'),
        };

        axios.post('http://localhost:8080/api/purchaserequests', payload)
            .then(() => {
                fetchData();
                setModalShow(false);
                showAlert('Record saved successfully.', 'success');
            });
    };

    const handleDelete = (id) => {
        if (window.confirm('Are you sure to delete this record?')) {
            axios.delete(`http://localhost:8080/api/purchaserequests/${id}`)
                .then(() => {
                    fetchData();
                    showAlert('Record deleted successfully.', 'success');
                });
        }
    };

    const showAlert = (message, variant) => {
        setAlert({ message, variant });
        setTimeout(() => setAlert({ message: '', variant: '' }), 3000);
    };

    const openModal = (mode, row = initialFormData()) => {
        setFormData({ ...row, requestdate: moment(row.requestdate).format('YYYY-MM-DD') });
        setViewMode(mode === 'view');
        setEditMode(mode === 'edit');
        setModalShow(true);
    };

    return (
        <div className="container mt-3">
            <h4>Purchase Request</h4>
            {alert.message && <Alert variant={alert.variant}>{alert.message}</Alert>}

            <div className="d-flex justify-content-between align-items-center mb-2">
                <input
                    type="text"
                    className="form-control w-50"
                    placeholder="Search by status or qty"
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                />
                <Button onClick={() => openModal('add')}>Add</Button>
            </div>

            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                        <th>PR ID</th>
                        <th>Requested By</th>
                        <th>Item</th>
                        <th>Qty</th>
                        <th>Request Date</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map(row => (
                        <tr key={row.prid}>
                            <td>{row.prid}</td>
                            {/* <td>{users.find(u => u.ouserid === row.requestedby)?.ousername}</td> */}
                            {/* <td>{Array.isArray(users) ? users.find(u => u.ouserid === row.requestedby)?.ousername : ''}</td> */}
                            <td>{users.find(u => u.ouserid === row.requestedby)?.ousername || row.requestedby}</td>
                            {/* <td>{items.find(i => i.itemid === row.itemid)?.itemname}</td> */}
                            {/* <td>{Array.isArray(items) ? items.find(i => i.itemid === row.itemid)?.itemname : ''}</td> */}
                            <td>{Array.isArray(items) ? items.find(i => i.itemid === row.itemid)?.itemname : ''}</td>
                            <td>{row.qty}</td>
                            <td>{moment(row.requestdate).format('YYYY-MM-DD')}</td>
                            <td>{row.status}</td>
                            <td>
                                <Button size="sm" onClick={() => openModal('view', row)}>View</Button>{' '}
                                {/* <Button size="sm" onClick={() => openModal('edit', row)}>Edit</Button>{' '} */}
                                {(row.status === 'Pending' || row.status === 'Hold') && (
                                    <Button size="sm" onClick={() => openModal('edit', row)}>Edit</Button>
                                )}{' '}

                                {(row.status === 'Pending' || row.status === 'Hold') && (
                                    <Button size="sm" variant="danger" onClick={() => handleDelete(row.prid)}>Delete</Button>
                                )}{' '}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

            {/* Pagination */}
            <div className="d-flex justify-content-center">
                {[...Array(totalPages)].map((_, i) => (
                    <Button
                        key={i}
                        variant={i === page ? 'primary' : 'light'}
                        onClick={() => setPage(i)}
                        className="me-1"
                    >
                        {i + 1}
                    </Button>
                ))}
            </div>

            {/* Modal */}
            <Modal show={modalShow} onHide={() => setModalShow(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>
                        {viewMode ? 'View' : editMode ? 'Edit' : 'Add'} Purchase Request
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Requested By</Form.Label>
                            <Form.Select
                                name="requestedby"
                                disabled={viewMode}
                                value={formData.requestedby}
                                onChange={handleChange}
                            >
                                <option value="">Select User</option>
                                {users.map(user => (
                                    <option key={user.ouserid} value={user.ouserid}>
                                        {user.ousername}
                                    </option>
                                ))}
                            </Form.Select>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Item</Form.Label>
                            <Form.Select
                                disabled={viewMode}
                                value={formData.itemid}
                                onChange={e => setFormData({ ...formData, itemid: e.target.value })}
                            >
                                <option value="">Select</option>
                                {items.map(i => (
                                    <option key={i.itemid} value={i.itemid}>{i.itemname}</option>
                                ))}
                            </Form.Select>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Quantity</Form.Label>
                            <Form.Control
                                type="number"
                                value={formData.qty}
                                disabled={viewMode}
                                onChange={e => setFormData({ ...formData, qty: e.target.value })}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Request Date</Form.Label>
                            <Form.Control
                                type="date"
                                value={formData.requestdate}
                                disabled={viewMode}
                                onChange={e => setFormData({ ...formData, requestdate: e.target.value })}
                            />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Status</Form.Label>
                            <Form.Select
                                disabled={viewMode}
                                value={formData.status}
                                onChange={e => setFormData({ ...formData, status: e.target.value })}
                            >
                                <option>Pending</option>
                                <option>Approve</option>
                                <option>Reject</option>
                                <option>Hold</option>
                            </Form.Select>
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Modal.Footer>
                        {(editMode || !formData.prid) && <Button onClick={handleSave}>Save</Button>}
                        <Button variant="secondary" onClick={() => setModalShow(false)}>Close</Button>
                    </Modal.Footer>
                    <Button variant="secondary" onClick={() => setModalShow(false)}>Close</Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
};

export default PurchaseRequestCrud;
