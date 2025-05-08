import React, { useEffect, useState } from "react";
import { Modal, Button, Table, Form, Alert } from "react-bootstrap";
import axios from "axios";

const PODetailModal = ({ show, onClose, poid }) => {
  const [details, setDetails] = useState([]);
  const [items, setItems] = useState([]);
  const [newDetail, setNewDetail] = useState({
    itemid: "",
    qty: 0,
    rate: 0,
    amount: 0,
  });
  const [error, setError] = useState("");

  useEffect(() => {
    if (!show || !poid) return;

    axios.get("http://localhost:8080/api/items")
      .then(res => setItems(Array.isArray(res.data) ? res.data : []))
      .catch(err => {
        console.error("Error fetching items:", err);
        setItems([]);
      });

    axios.get(`http://localhost:8080/api/txnpodetails/${poid}`)
      .then(res => setDetails(Array.isArray(res.data) ? res.data : []))
      .catch(err => {
        console.error("Error fetching PO details:", err);
        setDetails([]);
      });
  }, [show, poid]);

  const handleFieldChange = (e) => {
    const { name, value } = e.target;
    let updatedDetail = {
      ...newDetail,
      [name]: value,
    };

    // Update amount automatically
    if (name === "qty" || name === "rate") {
      const qty = parseFloat(name === "qty" ? value : newDetail.qty || 0);
      const rate = parseFloat(name === "rate" ? value : newDetail.rate || 0);
      updatedDetail.amount = qty * rate;
    }

    setNewDetail(updatedDetail);
  };

  const handleAddDetail = () => {
    const { itemid, qty, rate } = newDetail;
    if (!itemid || qty <= 0 || rate <= 0) {
      setError("Please fill all fields with valid values.");
      return;
    }

    const payload = {
      ...newDetail,
      poid,
      lastaddeditby: sessionStorage.getItem("userid"),
    };

    axios.post("http://localhost:8080/api/txnpodetails", payload)
      .then((res) => {
        setDetails(prev => [...prev, res.data]);
        setNewDetail({ itemid: "", qty: 0, rate: 0, amount: 0 });
        setError("");
      })
      .catch((err) => {
        console.error("Error adding detail:", err);
        setError("Failed to add PO detail.");
      });
  };

  const handleDelete = (detailid) => {
    axios.delete(`http://localhost:8080/api/txnpodetails/${detailid}`)
      .then(() => setDetails(prev => prev.filter(d => d.detailid !== detailid)))
      .catch(err => {
        console.error("Error deleting detail:", err);
        setError("Failed to delete PO detail.");
      });
  };

  return (
    <Modal show={show} onHide={onClose} size="lg">
      <Modal.Header closeButton>
        <Modal.Title>PO Details - PO #{poid}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        {error && <Alert variant="danger">{error}</Alert>}

        {/* Detail entry form */}
        <Form className="mb-3">
          <Form.Row>
            <Form.Group className="col-md-4">
              <Form.Label>Item</Form.Label>
              <Form.Control
                as="select"
                name="itemid"
                value={newDetail.itemid}
                onChange={handleFieldChange}
              >
                <option value="">Select Item</option>
                {items.map(item => (
                  <option key={item.itemid} value={item.itemid}>
                    {item.itemname}
                  </option>
                ))}
              </Form.Control>
            </Form.Group>

            <Form.Group className="col-md-2">
              <Form.Label>Qty</Form.Label>
              <Form.Control
                type="number"
                name="qty"
                value={newDetail.qty}
                onChange={handleFieldChange}
                min="0"
              />
            </Form.Group>

            <Form.Group className="col-md-2">
              <Form.Label>Rate</Form.Label>
              <Form.Control
                type="number"
                name="rate"
                value={newDetail.rate}
                onChange={handleFieldChange}
                min="0"
              />
            </Form.Group>

            <Form.Group className="col-md-2">
              <Form.Label>Amount</Form.Label>
              <Form.Control
                type="number"
                value={newDetail.amount}
                readOnly
              />
            </Form.Group>

            <Form.Group className="col-md-2 d-flex align-items-end">
              <Button variant="primary" onClick={handleAddDetail}>
                Add
              </Button>
            </Form.Group>
          </Form.Row>
        </Form>

        {/* Detail list table */}
        <Table striped bordered hover size="sm">
          <thead>
            <tr>
              <th>#</th>
              <th>Item</th>
              <th>Qty</th>
              <th>Rate</th>
              <th>Amount</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {details.length === 0 ? (
              <tr><td colSpan="6" className="text-center">No details found.</td></tr>
            ) : (
              details.map((d, i) => (
                <tr key={d.detailid}>
                  <td>{i + 1}</td>
                  <td>{items.find(it => it.itemid === d.itemid)?.itemname || d.itemid}</td>
                  <td>{d.qty}</td>
                  <td>{d.rate}</td>
                  <td>{d.amount}</td>
                  <td>
                    <Button
                      variant="danger"
                      size="sm"
                      onClick={() => handleDelete(d.detailid)}
                    >
                      Delete
                    </Button>
                  </td>
                </tr>
              ))
            )}
          </tbody>
        </Table>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onClose}>
          Done
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default PODetailModal;
