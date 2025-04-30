import React, { useEffect, useState } from "react";
import axios from "axios";
import {
  Table, Button, Form, Alert, Pagination, Modal, Row, Col
} from "react-bootstrap";

function CategoryCrud() {
  const [categories, setCategories] = useState([]);
  const [form, setForm] = useState({ categoryname: "", description: "", id: null });
  const [message, setMessage] = useState("");
  const [search, setSearch] = useState("");
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [showModal, setShowModal] = useState(false);

  const loadData = async () => {
    const res = await axios.get("http://localhost:8080/api/categories", {
      params: {
        search,
        page,
        size: 5,
        sortBy: "categoryid",
        sortDir: "asc"
      }
    });
    setCategories(res.data.content);
    setTotalPages(res.data.totalPages);
  };

  useEffect(() => {
    loadData();
  }, [page, search]);

  const openModal = (cat = null) => {
    if (cat) {
      setForm({ categoryname: cat.categoryname, description: cat.description, id: cat.categoryid });
    } else {
      setForm({ categoryname: "", description: "", id: null });
    }
    setShowModal(true);
  };

  const handleSave = async () => {
    const data = {
      categoryname: form.categoryname,
      description: form.description,
      lastaddeditby: parseInt(sessionStorage.getItem("userid")),
    };

    try {
      if (form.id == null) {
        await axios.post("http://localhost:8080/api/categories", data);
        setMessage("Category saved successfully");
      } else {
        await axios.put(`http://localhost:8080/api/categories/${form.id}`, data);
        setMessage("Category updated successfully");
      }
      setShowModal(false);
      loadData();
    } catch {
      setMessage("Error saving category");
    }
  };

  const deleteCategory = async (id) => {
    if (window.confirm("Are you sure to delete?")) {
      await axios.delete(`http://localhost:8080/api/categories/${id}`);
      setMessage("Category deleted successfully");
      loadData();
    }
  };

  return (
    <div className="container mt-4">
      <h4>Category Management</h4>
      {message && <Alert variant="info">{message}</Alert>}

      <Row className="mb-3 align-items-center">
        <Col md="4">
          <Form.Control
            size="sm"
            placeholder="Search by name or description..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
        </Col>
        <Col>
          <Button variant="primary" size="sm" onClick={() => openModal()}>
            Add
          </Button>
        </Col>
      </Row>

      <Table bordered hover responsive>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th style={{ width: "120px" }}>Actions</th>
          </tr>
        </thead>
        <tbody>
          {categories.map((c) => (
            <tr key={c.categoryid}>
              <td>{c.categoryid}</td>
              <td>{c.categoryname}</td>
              <td>{c.description}</td>
              <td>
                <Button size="sm" variant="warning" onClick={() => openModal(c)}>Edit</Button>{' '}
                <Button size="sm" variant="danger" onClick={() => deleteCategory(c.categoryid)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Pagination>
        {[...Array(totalPages)].map((_, i) => (
          <Pagination.Item key={i} active={i === page} onClick={() => setPage(i)}>
            {i + 1}
          </Pagination.Item>
        ))}
      </Pagination>

      {/* Modal */}
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>{form.id ? "Edit Category" : "Add Category"}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Group>
            <Form.Label>Category Name</Form.Label>
            <Form.Control
              value={form.categoryname}
              onChange={(e) => setForm({ ...form, categoryname: e.target.value })}
            />
          </Form.Group>
          <Form.Group className="mt-2">
            <Form.Label>Description</Form.Label>
            <Form.Control
              as="textarea"
              rows={3}
              value={form.description}
              onChange={(e) => setForm({ ...form, description: e.target.value })}
            />
          </Form.Group>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>Cancel</Button>
          <Button variant="primary" onClick={handleSave}>
            {form.id ? "Update" : "Save"}
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default CategoryCrud;
