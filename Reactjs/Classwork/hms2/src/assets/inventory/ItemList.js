import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Modal, Button, Table, Form, Alert } from 'react-bootstrap';

function ItemList() {
    const [search, setSearch] = useState('');
    const [size] = useState(5);
    const [categories, setCategories] = useState([]);
    const [uoms, setUoms] = useState([]);
    const [message, setMessage] = useState('');
    const [isEditing, setIsEditing] = useState(false);
    const [searchKeyword, setSearchKeyword] = useState('');
    const [page, setPage] = useState(0);
    const [items, setItems] = useState([]);
    const [totalPages, setTotalPages] = useState(0);    
    const pageSize = 10;
    const initialItem = {
        itemid: '',
        itemname: '',
        itemcode: '',
        categoryid: '',
        uomid: '',
        reorderlevel: '',
        maxstock: '',
        lastaddeditby: '',
        lasteditdatetime: ''
    };

    const [currentItem, setCurrentItem] = useState(initialItem);
    const [isViewMode, setIsViewMode] = useState(false);
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        loadItems();
    }, [page, searchKeyword]);
    
    const loadItems = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/items`, {
                params: {
                    page: page,
                    size: 10,
                    search: searchKeyword
                }
            });
            setItems(response.data.content);
            setTotalPages(response.data.totalPages);
        } catch (error) {
            console.error("Error fetching items:", error);
        }
    };

    const highlightText = (text, keyword) => {
        if (!keyword) return text;

        const regex = new RegExp(`(${keyword})`, 'gi');
        return text.split(regex).map((part, i) =>
            regex.test(part) ? <mark key={i}>{part}</mark> : part
        );
    };

    const loadCategories = () => {
        axios.get(`http://localhost:8080/api/categories`).then(res => setCategories(res.data.content));
    };

    const loadUoms = () => {
        axios.get(`http://localhost:8080/api/uoms`).then(res => setUoms(res.data.content));
    };

    useEffect(() => {
        loadItems();
        loadCategories();
        loadUoms();
    }, [page, search]);

    const handleSave = () => {
        if (!currentItem.itemname || !currentItem.itemcode || !currentItem.categoryid || !currentItem.uomid || !currentItem.reorderlevel || !currentItem.maxstock) {
            setMessage("Please fill all required fields.");
            return;
        }
        const itemToSave = {
            ...currentItem,
            lastaddeditby: sessionStorage.getItem('userid') || 1
        };

        if (currentItem.itemid) {
            // PUT for update
            axios.put(`http://localhost:8080/api/items/${currentItem.itemid}`, itemToSave)
                .then(() => {
                    setMessage("Updated successfully.");
                    loadItems();
                    setShowModal(false);
                });
        } else {
            // POST for new
            axios.post('http://localhost:8080/api/items', itemToSave)
                .then(() => {
                    setMessage("Added successfully.");
                    loadItems();
                    setShowModal(false);
                });
        }
    };

    const handleAdd = () => {
        setCurrentItem(initialItem);
        setIsViewMode(false);
        setShowModal(true);
    };

    const handleEdit = (item) => {
        setCurrentItem(item);
        setIsViewMode(false);
        setShowModal(true);
    };

    const handleView = (item) => {
        setCurrentItem(item);
        setIsViewMode(true);
        setShowModal(true);
    };

    const handleDelete = (id) => {
        if (window.confirm('Are you sure to delete?')) {
            axios.delete(`http://localhost:8080/api/items/${id}`)
                .then(() => {
                    setMessage("Deleted successfully.");
                    loadItems();
                });
        }
    };

    return (
        <div>
            <Modal.Title>
                {isViewMode ? "View Item" : (currentItem.itemid ? "Edit Item" : "Add Item")}
            </Modal.Title>


            {message && <Alert variant="success">{message}</Alert>}

            <div className="d-flex justify-content-between mb-2">
                <div className="d-flex justify-content-between mb-2">
                    <Form.Control
                        type="text"
                        placeholder="Search..."
                        value={searchKeyword}
                        onChange={(e) => {
                            setSearchKeyword(e.target.value);
                            setPage(0); // Reset to first page
                        }}
                        style={{ width: '1350px' }}
                    />
                    <Button variant="primary" onClick={handleAdd}>
                        Add
                    </Button>
                </div>
            </div>

            <Table bordered hover>
                <thead>
                    <tr>
                        <th>Item Code</th>
                        <th>Item Name</th>
                        <th>Category</th>
                        <th>UOM</th>
                        <th>Reorder Level</th>
                        <th>Max Stock</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {items.map(item => (
                        <tr key={item.itemid}>
                            <td>{highlightText(item.itemcode, searchKeyword)}</td>
                            <td>{highlightText(item.itemname, searchKeyword)}</td>
                            <td>{categories.find(c => c.categoryid === item.categoryid)?.categoryname}</td>
                            <td>{uoms.find(u => u.uomid === item.uomid)?.uomname}</td>
                            {/* <td>{uoms.find(u => u.uomid === item.uomid)?.Description}</td> */}
                            <td>{item.reorderlevel}</td>
                            <td>{item.maxstock}</td>
                            <td>
                                <Button variant="info" size="sm" onClick={() => handleView(item)}>View</Button>{' '}
                                <Button variant="warning" size="sm" onClick={() => handleEdit(item)}>Edit</Button>{' '}
                                <Button variant="danger" size="sm" onClick={() => handleDelete(item.itemid)}>Delete</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

            <div className="d-flex justify-content-center">
                {[...Array(totalPages)].map((_, i) => (
                    <Button
                        key={i}
                        variant={i === page ? 'primary' : 'light'}
                        onClick={() => setPage(i)}
                        className="mx-1"
                    >
                        {i + 1}
                    </Button>
                ))}
            </div>

            <Modal show={showModal} onHide={() => setShowModal(false)}>
                <Modal.Header closeButton>
                    <Modal.Title>{isEditing ? 'Edit Item' : 'Add Item'}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Item Code</Form.Label>
                            <Form.Control type="text" value={currentItem.itemcode || ''} onChange={e => setCurrentItem({ ...currentItem, itemcode: e.target.value })} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Item Name</Form.Label>
                            <Form.Control type="text" value={currentItem.itemname || ''} onChange={e => setCurrentItem({ ...currentItem, itemname: e.target.value })} />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Category</Form.Label>
                            <Form.Select
                                value={currentItem.categoryid}
                                onChange={(e) => setCurrentItem({ ...currentItem, categoryid: e.target.value })}
                                disabled={isViewMode}
                            >
                                <option value="">Select Category</option>
                                {categories.map((cat) => (
                                    <option key={cat.categoryid} value={cat.categoryid}>
                                        {cat.categoryname}
                                    </option>
                                ))}
                            </Form.Select>
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>UOM</Form.Label>
                            <Form.Control as="select" value={currentItem.uomid || ''} onChange={e => setCurrentItem({ ...currentItem, uomid: Number(e.target.value) })}>
                                <option value="">--Select--</option>
                                {uoms.map(u => (
                                    <option key={u.uomid} value={u.uomid}>{u.uomname}</option>
                                    // <option key={u.uomid} value={u.uomid}>{u.Description}</option>
                                ))}
                            </Form.Control>
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Reorder Level</Form.Label>
                            <Form.Control type="number" value={currentItem.reorderlevel || ''} onChange={e => setCurrentItem({ ...currentItem, reorderlevel: e.target.value })} />
                        </Form.Group>

                        <Form.Group>
                            <Form.Label>Max Stock</Form.Label>
                            <Form.Control type="number" value={currentItem.maxstock || ''} onChange={e => setCurrentItem({ ...currentItem, maxstock: e.target.value })} />
                        </Form.Group>

                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={() => setShowModal(false)}>
                        Close
                    </Button>
                    {!isViewMode && (
                        <Button variant="primary" onClick={handleSave}>
                            {currentItem.itemid ? "Update" : "Save"}
                        </Button>
                    )}
                </Modal.Footer>
            </Modal>
        </div>
    );
}

export default ItemList;
