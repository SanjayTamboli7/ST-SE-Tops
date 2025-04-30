import React, { useEffect, useState } from "react";
import axios from "axios";
import { Modal, Button, Form, Table, Alert } from "react-bootstrap";

export default function SupplierItemCrud() {
    const [currentPage, setCurrentPage] = useState(0);
    const [items, setItems] = useState([]);
    const [suppliers, setSuppliers] = useState([]);
    const [products, setProducts] = useState([]);
    const [search, setSearch] = useState("");
    const [showModal, setShowModal] = useState(false);
    const [modalMode, setModalMode] = useState("Add");
    const [selectedItem, setSelectedItem] = useState({});
    const [alert, setAlert] = useState({ show: false, message: "", variant: "" });

    const [page, setPage] = useState(0);
    const [size] = useState(5);
    const [totalPages, setTotalPages] = useState(0);

    const userid = sessionStorage.getItem("userid") || 1;

    const apiUrl = "http://localhost:8080/api/supplieritems";

    useEffect(() => {
        fetchSuppliers();
        fetchProducts();
        fetchItems();
    }, [page, search]);

    useEffect(() => {
        if (showModal) {
          fetchSuppliers();
          fetchItems();
        }
      }, [showModal]);
      
      const fetchSuppliers = async () => {
        try {
            const res = await axios.get("http://localhost:8080/api/suppliers");
            setSuppliers(res.data.content || []);  // Use content if data is wrapped in it
        } catch (error) {
            console.error("Error fetching suppliers:", error);
            // Log error response for more details
            if (error.response) {
                console.error("Response data:", error.response.data);
                console.error("Response status:", error.response.status);
            }
        }
    };    

    const fetchProducts = async () => {
        const res = await axios.get("http://localhost:8080/api/items");
        setProducts(res.data.content || []);
    };

    const fetchItems = async () => {
        const res = await axios.get(apiUrl, {
            params: { search, page, size }
        });
        setItems(res.data.content);
        setTotalPages(res.data.totalPages);
    };

    const handleShowModal = (mode, item = {}) => {
        setModalMode(mode);
        setSelectedItem(item);
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setSelectedItem({});
        setShowModal(false);
    };

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setSelectedItem({ ...selectedItem, [name]: value });
    };

    const handleSave = async () => {
        const { supplierid, itemid, leadtimedays } = selectedItem;

        if (!supplierid || !itemid || !leadtimedays) {
            setAlert({ show: true, message: "All fields are required!", variant: "danger" });
            return;
        }

        const data = {
            supplierid: parseInt(supplierid),
            itemid: parseInt(itemid),
            leadtimedays: parseInt(leadtimedays),
            lastaddeditby: parseInt(userid)
        };

        try {
            await axios.post(apiUrl, data);
            fetchItems();
            setAlert({ show: true, message: "Saved successfully!", variant: "success" });
            handleCloseModal();
        } catch {
            setAlert({ show: true, message: "Save failed!", variant: "danger" });
        }
    };

    const handleDelete = async (supplierid, itemid) => {
        if (window.confirm("Are you sure to delete this item?")) {
            try {
                await axios.delete(`${apiUrl}/${supplierid}/${itemid}`);
                fetchItems();
                setAlert({ show: true, message: "Deleted successfully!", variant: "success" });
            } catch {
                setAlert({ show: true, message: "Delete failed!", variant: "danger" });
            }
        }
    };

    return (
        <div className="container mt-4">
            <h4>Supplier Items</h4>
            {alert.show && <Alert variant={alert.variant}>{alert.message}</Alert>}

            <div className="d-flex mb-2">
                <input
                    type="text"
                    className="form-control me-2"
                    placeholder="Search by supplier or item..."
                    value={search}
                    onChange={(e) => { setSearch(e.target.value); setPage(0); }}
                />
                <Button variant="primary" onClick={() => handleShowModal("Add")}>Add</Button>
            </div>

            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Supplier</th>
                        <th>Item</th>
                        <th>Lead Time (days)</th>
                        <th>Last Edited</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {items.map(row => (
                        <tr key={`${row.supplierid}-${row.itemid}`}>
                            <td>{row.suppliername}</td>
                            <td>{row.itemname}</td>
                            <td>{row.leadtimedays}</td>
                            <td>{row.lasteditdatetime}</td>
                            <td>
                                <Button size="sm" variant="info" className="me-1" onClick={() => handleShowModal("View", row)}>View</Button>
                                <Button size="sm" variant="warning" className="me-1" onClick={() => handleShowModal("Edit", row)}>Edit</Button>
                                <Button size="sm" variant="danger" onClick={() => handleDelete(row.supplierid, row.itemid)}>Delete</Button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>

            {/* <div className="d-flex justify-content-center">
                <Button disabled={page <= 0} onClick={() => setPage(page - 1)}>Prev</Button>
                <span className="mx-3">Page {page + 1} of {totalPages}</span>
                <Button disabled={page + 1 >= totalPages} onClick={() => setPage(page + 1)}>Next</Button>
            </div> */}
            <div className="mt-2">
                {Array.from({ length: totalPages }, (_, i) => (
                    <button
                        key={i}
                        className={`btn btn-sm ${i === currentPage ? 'btn-primary' : 'btn-outline-primary'} me-1`}
                        onClick={() => setPage(i)}
                    >
                        {i + 1}
                    </button>
                ))}
            </div>

            {/* Modal */}
            <Modal show={showModal} onHide={handleCloseModal}>
                <Modal.Header closeButton>
                    <Modal.Title>{modalMode} Supplier Item</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Supplier</Form.Label>
                            <Form.Select
                                name="supplierid"
                                value={selectedItem.supplierid || ""}
                                disabled={modalMode === "View"}
                                onChange={handleInputChange}
                            >
                                <option value="">Select Supplier</option>
                                {/* {suppliers.map(s => (
                  <option key={s.supplierid} value={s.supplierid}>
                    {s.suppliername}
                  </option>
                ))} */}
                                {suppliers.map(s => (
                                    <option key={s.supplierid} value={s.supplierid}>{s.suppliername}</option>
                                ))}

                            </Form.Select>
                        </Form.Group>

                        <Form.Group className="mt-2">
                            <Form.Label>Item</Form.Label>
                            <Form.Select
                                name="itemid"
                                value={selectedItem.itemid || ""}
                                disabled={modalMode === "View"}
                                onChange={handleInputChange}
                            >
                                <option value="">Select Item</option>
                                {products.map(p => (
                                    <option key={p.itemid} value={p.itemid}>
                                        {p.itemname}
                                    </option>
                                ))}
                            </Form.Select>
                        </Form.Group>

                        <Form.Group className="mt-2">
                            <Form.Label>Lead Time (Days)</Form.Label>
                            <Form.Control
                                type="number"
                                name="leadtimedays"
                                value={selectedItem.leadtimedays || ""}
                                disabled={modalMode === "View"}
                                onChange={handleInputChange}
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                {modalMode !== "View" && (
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleCloseModal}>Cancel</Button>
                        <Button variant="primary" onClick={handleSave}>Save</Button>
                    </Modal.Footer>
                )}
            </Modal>
        </div>
    );
};

// export default SupplierItemCrud;
