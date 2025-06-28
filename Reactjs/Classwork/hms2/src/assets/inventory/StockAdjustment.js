import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Modal, Button, Form, Table, Pagination } from 'react-bootstrap';

const StockAdjustment = () => {
    const [adjustments, setAdjustments] = useState([]);
    const [items, setItems] = useState([]);
    const [users, setUsers] = useState([]);
    const [modalShow, setModalShow] = useState(false);
    const [mode, setMode] = useState('addMode');
    const [currentAdjustment, setCurrentAdjustment] = useState({
        itemId: '',
        qty: '',
        reason: '',
        adjustedBy: '',
        adjustedDate: new Date().toISOString().split('T')[0],
        remark: '',
        status: 'Pending',
    });
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(0);
    const [search, setSearch] = useState('');
    const [sortBy, setSortBy] = useState('adjustmentId');
    const [sortDir, setSortDir] = useState('asc');
    const [loading, setLoading] = useState(false);
    const [modalLoading, setModalLoading] = useState(true); // Separate loading state for modal

    useEffect(() => {
        fetchItems();
        fetchUsers();
        fetchAdjustments();
    }, [page, search, sortBy, sortDir]);

    useEffect(() => {
        // Ensure modalLoading is false only when both items and users are fetched
        if (items.length > 0 && users.length > 0) {
            setModalLoading(false);
        } else {
            setModalLoading(true);
        }
    }, [items, users]);

    const fetchItems = async () => {
        setLoading(true);
        try {
            const response = await axios.get(
                'http://localhost:8080/api/items?search=&page=0&size=100&sortBy=itemname&sortDir=asc'
            );
            console.log('Items response:', response.data);
            const mappedItems = (response.data.content || []).map(item => ({
                itemId: item.itemid,
                itemName: item.itemname,
            }));
            console.log('Mapped items:', mappedItems);
            setItems(mappedItems);
        } catch (error) {
            console.error('Error fetching items:', error);
            toast.error('Failed to fetch items');
            setItems([]);
        } finally {
            setLoading(false);
        }
    };

    const fetchUsers = async () => {
        setLoading(true);
        try {
            const response = await axios.get('http://localhost:8080/api/otherusers?page=0&size=100');
            console.log('Users response:', response.data);
            const mappedUsers = (response.data.content || []).map(user => ({
                ouserId: user.ouserid,
                ouserName: user.ousername,
            }));
            console.log('Mapped users:', mappedUsers);
            setUsers(mappedUsers);
        } catch (error) {
            console.error('Error fetching users:', error);
            toast.error('Failed to fetch users');
            setUsers([]);
        } finally {
            setLoading(false);
        }
    };

    const fetchAdjustments = async () => {
        setLoading(true);
        try {
            const response = await axios.get(
                `http://localhost:8080/api/stockadjustments?search=${search}&page=${page}&size=10&sortBy=${sortBy}&sortDir=${sortDir}`
            );
            console.log('Adjustments response:', response.data);
            setAdjustments(response.data.content || []);
            setTotalPages(response.data.totalPages || 0);
        } catch (error) {
            console.error('Error fetching adjustments:', error);
            toast.error('Failed to fetch stock adjustments');
        } finally {
            setLoading(false);
        }
    };

    const handleModalOpen = (mode, adjustment = null) => {
        setMode(mode);
        if (mode === 'addMode') {
            setCurrentAdjustment({
                itemId: '',
                qty: '',
                reason: '',
                adjustedBy: '',
                adjustedDate: new Date().toISOString().split('T')[0],
                remark: '',
                status: 'Pending',
            });
        } else if (adjustment) {
            setCurrentAdjustment({
                adjustmentId: adjustment.adjustmentId,
                itemId: adjustment.itemId ? String(adjustment.itemId) : '', // Convert to string for <Form.Select>
                qty: adjustment.qty ? String(adjustment.qty) : '',
                reason: adjustment.reason || '',
                adjustedBy: adjustment.adjustedBy ? String(adjustment.adjustedBy) : '', // Convert to string
                adjustedDate: adjustment.adjustedDate ? adjustment.adjustedDate.split('T')[0] : '',
                remark: adjustment.remark || '',
                status: adjustment.status || 'Pending',
            });
        }
        setModalShow(true);
    };

    const handleModalClose = () => {
        setModalShow(false);
        setCurrentAdjustment({
            itemId: '',
            qty: '',
            reason: '',
            adjustedBy: '',
            adjustedDate: new Date().toISOString().split('T')[0],
            remark: '',
            status: 'Pending',
        });
    };

    const validateForm = () => {
        if (!currentAdjustment.itemId) {
            toast.error('Item is required');
            return false;
        }
        if (!currentAdjustment.qty || parseInt(currentAdjustment.qty) <= 0) {
            toast.error('Quantity must be positive');
            return false;
        }
        if (!currentAdjustment.status) {
            toast.error('Status is required');
            return false;
        }
        if (!sessionStorage.getItem('userid')) {
            toast.error('Session expired. Please log in again.');
            return false;
        }
        const adjustedDate = new Date(currentAdjustment.adjustedDate);
        const currentDate = new Date();
        if (adjustedDate > currentDate) {
            toast.error('Adjusted date cannot be in the future');
            return false;
        }
        return true;
    };
    
const handleSave = async () => {
  if (!validateForm()) return;

  const lastEditDateTime = new Date().toISOString().split('.')[0]; // Remove milliseconds and Z
  const payload = {
    ...currentAdjustment,
    itemId: parseInt(currentAdjustment.itemId),
    adjustedBy: currentAdjustment.adjustedBy ? parseInt(currentAdjustment.adjustedBy) : null,
    qty: parseInt(currentAdjustment.qty),
    adjustedDate: currentAdjustment.adjustedDate ? `${currentAdjustment.adjustedDate}T00:00:00` : null,
    lastAddEditBy: parseInt(sessionStorage.getItem('userid')),
    lastEditDateTime: lastEditDateTime, // e.g., 2025-06-28T14:18:47
  };

  console.log('Saving payload:', payload);

  try {
    if (mode === 'addMode') {
      await axios.post('http://localhost:8080/api/stockadjustments', payload);
      toast.success('Stock Adjustment created successfully');
    } else if (mode === 'editMode') {
      await axios.put(`http://localhost:8080/api/stockadjustments/${currentAdjustment.adjustmentId}`, payload);
      toast.success('Stock Adjustment updated successfully');
    }
    fetchAdjustments();
    handleModalClose();
  } catch (error) {
    console.error('Error saving adjustment:', error.response?.data || error.message);
    toast.error('Failed to save stock adjustment: ' + (error.response?.data?.message || error.message));
  }
};

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/stockadjustments/${id}`);
            toast.success('Stock Adjustment deleted successfully');
            fetchAdjustments();
        } catch (error) {
            console.error('Error deleting adjustment:', error);
            toast.error('Failed to delete stock adjustment');
        }
    };

    const handlePageChange = (newPage) => {
        setPage(newPage);
    };

    const handleSort = (field) => {
        setSortBy(field);
        setSortDir(sortDir === 'asc' ? 'desc' : 'asc');
    };

    const getItemName = (itemId) => {
        const item = items.find((i) => i.itemId === parseInt(itemId));
        return item ? item.itemName : 'Unknown';
    };

    const getUserName = (userId) => {
        const user = users.find((u) => u.ouserId === parseInt(userId));
        return user ? user.ouserName : 'Unknown';
    };

    return (
        <div className="container mt-4">
            <h2>Stock Adjustments</h2>
            <div className="d-flex mb-3">
                <Form.Control
                    type="text"
                    placeholder="Search..."
                    value={search}
                    onChange={(e) => {
                        setSearch(e.target.value);
                        setPage(0);
                    }}
                    className="me-2"
                />
                <Button onClick={() => handleModalOpen('addMode')} disabled={modalLoading}>
                    Add
                </Button>
            </div>

            {loading ? (
                <p>Loading...</p>
            ) : (
                <>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th onClick={() => handleSort('adjustmentId')}>
                                    ID {sortBy === 'adjustmentId' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('itemId')}>
                                    Item {sortBy === 'itemId' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('qty')}>
                                    Quantity {sortBy === 'qty' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('reason')}>
                                    Reason {sortBy === 'reason' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('adjustedBy')}>
                                    Adjusted By {sortBy === 'adjustedBy' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('adjustedDate')}>
                                    Adjusted Date {sortBy === 'adjustedDate' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th onClick={() => handleSort('status')}>
                                    Status {sortBy === 'status' && (sortDir === 'asc' ? '↑' : '↓')}
                                </th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {adjustments.map((adjustment) => (
                                <tr key={adjustment.adjustmentId}>
                                    <td>{adjustment.adjustmentId}</td>
                                    <td>{getItemName(adjustment.itemId)}</td>
                                    <td>{adjustment.qty}</td>
                                    <td>{adjustment.reason}</td>
                                    <td>{getUserName(adjustment.adjustedBy)}</td>
                                    <td>{adjustment.adjustedDate ? adjustment.adjustedDate.split('T')[0] : ''}</td>
                                    <td>{adjustment.status}</td>
                                    <td>
                                        <Button
                                            variant="info"
                                            size="sm"
                                            onClick={() => handleModalOpen('viewMode', adjustment)}
                                            className="me-1"
                                        >
                                            View
                                        </Button>
                                        {adjustment.status === 'Pending' && (
                                            <>
                                                <Button
                                                    variant="warning"
                                                    size="sm"
                                                    onClick={() => handleModalOpen('editMode', adjustment)}
                                                    className="me-1"
                                                >
                                                    Edit
                                                </Button>
                                                <Button
                                                    variant="danger"
                                                    size="sm"
                                                    onClick={() => handleDelete(adjustment.adjustmentId)}
                                                >
                                                    Delete
                                                </Button>
                                            </>
                                        )}
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>

                    <Pagination>
                        {[...Array(totalPages).keys()].map((p) => (
                            <Pagination.Item
                                key={p}
                                active={p === page}
                                onClick={() => handlePageChange(p)}
                            >
                                {p + 1}
                            </Pagination.Item>
                        ))}
                    </Pagination>
                </>
            )}

            <Modal show={modalShow} onHide={handleModalClose}>
                <Modal.Header closeButton>
                    <Modal.Title>
                        {mode === 'addMode' ? 'Add' : mode === 'editMode' ? 'Edit' : 'View'} Stock Adjustment
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    {modalLoading ? (
                        <p>Loading data...</p>
                    ) : (
                        <Form>
                            <Form.Group className="mb-3">
                                <Form.Label>Item</Form.Label>
                                <Form.Select
                                    value={currentAdjustment.itemId}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, itemId: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                >
                                    <option value="">Select Item</option>
                                    {items.length > 0 ? (
                                        items.map((item) => (
                                            <option key={item.itemId} value={item.itemId}>
                                                {item.itemName}
                                            </option>
                                        ))
                                    ) : (
                                        <option disabled>No items available</option>
                                    )}
                                </Form.Select>
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Quantity</Form.Label>
                                <Form.Control
                                    type="number"
                                    value={currentAdjustment.qty}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, qty: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Reason</Form.Label>
                                <Form.Control
                                    type="text"
                                    value={currentAdjustment.reason
                                        ? currentAdjustment.reason : ''}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, reason: e.target.value })
                                    }
                                    disabled={mode === 'viewReason'}
                                />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Adjusted By</Form.Label>
                                <Form.Select
                                    value={currentAdjustment.adjustedBy}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, adjustedBy: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                >
                                    <option value="">Select User</option>
                                    {users.length > 0 ? (
                                        users.map((user) => (
                                            <option key={user.ouserId} value={user.ouserId}>
                                                {user.ouserName}
                                            </option>
                                        ))
                                    ) : (
                                        <option disabled>No users available</option>
                                    )}
                                </Form.Select>
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Adjusted Date</Form.Label>
                                <Form.Control
                                    type="date"
                                    value={currentAdjustment.adjustedDate}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, adjustedDate: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Remark</Form.Label>
                                <Form.Control
                                    type="text"
                                    value={currentAdjustment.remark}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, remark: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                />
                            </Form.Group>
                            <Form.Group className="mb-3">
                                <Form.Label>Status</Form.Label>
                                <Form.Select
                                    value={currentAdjustment.status}
                                    onChange={(e) =>
                                        setCurrentAdjustment({ ...currentAdjustment, status: e.target.value })
                                    }
                                    disabled={mode === 'viewMode'}
                                >
                                    <option value="Pending">Pending</option>
                                    <option value="Approved">Approved</option>
                                    <option value="Rejected">Rejected</option>
                                    <option value="Posted">Posted</option>
                                </Form.Select>
                            </Form.Group>
                        </Form>
                    )}
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleModalClose}>
                        Close
                    </Button>
                    {mode !== 'viewMode' && (
                        <Button variant="primary" onClick={handleSave}>
                            Save
                        </Button>
                    )}
                </Modal.Footer>
            </Modal>

            <ToastContainer />
        </div>
    );
};

export default StockAdjustment;
