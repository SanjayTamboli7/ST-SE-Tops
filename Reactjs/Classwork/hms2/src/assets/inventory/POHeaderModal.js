import React, { useEffect, useState } from "react";
import { Modal, Button, Form, Alert } from "react-bootstrap";
import axios from "axios";
import PODetailModal from "./PODetailModal";

const POHeaderModal = ({ show, onClose, poData, action, setPOData, setShowAlert }) => {
  const [suppliers, setSuppliers] = useState([]);
  const [formData, setFormData] = useState({
    supplierid: "",
    status: "",
    totalAmount: 0,
  });
  const [errors, setErrors] = useState({});
  const [poid, setPoid] = useState(null); // saved PO ID
  const [showDetailModal, setShowDetailModal] = useState(false);

  const isView = action === "view";

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/suppliers")
      .then((res) => setSuppliers(Array.isArray(res.data) ? res.data : []))
      .catch((err) => {
        console.error("Error fetching suppliers:", err);
        setSuppliers([]);
      });

    if (poData) {
      setFormData({
        supplierid: poData.supplierid || "",
        status: poData.status || "",
        totalAmount: poData.totalAmount || 0,
      });
      setPoid(poData.poid || null);
    } else {
      setFormData({ supplierid: "", status: "", totalAmount: 0 });
      setPoid(null);
    }

    setErrors({});
    setShowDetailModal(false);
  }, [poData, show]);

  const validate = () => {
    const errs = {};
    if (!formData.supplierid) errs.supplierid = "Supplier is required.";
    if (!formData.status) errs.status = "Status is required.";
    setErrors(errs);
    return Object.keys(errs).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = () => {
    if (!validate()) return;

    const payload = {
      ...poData,
      ...formData,
      lastaddeditby: sessionStorage.getItem("userid"),
    };

    const request =
      action === "edit"
        ? axios.put(`http://localhost:8080/api/txnpoheader/${poData.poid}`, payload)
        : axios.post("http://localhost:8080/api/txnpoheader", payload);

    request
      .then((res) => {
        const newPoid = res.data.poid;
        setShowAlert({ type: "success", message: `PO ${action === "edit" ? "updated" : "created"} successfully.` });
        setPOData(); // Refresh list
        setPoid(newPoid); // capture for detail
        if (action === "add") {
          // switch to edit mode after add to allow adding details
          setFormData({ ...formData });
        }
        onClose();
      })
      .catch((err) => {
        console.error("Save error:", err);
        setShowAlert({ type: "danger", message: "Failed to save PO Header." });
      });
  };

  const openDetails = () => {
    if (!poid) {
      setShowAlert({ type: "warning", message: "Please save the PO Header before adding details." });
      return;
    }
    setShowDetailModal(true);
  };

  return (
    <>
      <Modal show={show} onHide={onClose} size="lg">
        <Modal.Header closeButton>
          <Modal.Title>
            {action === "edit" && "Edit PO Header"}
            {action === "add" && "Add PO Header"}
            {action === "view" && "View PO Header"}
          </Modal.Title>
        </Modal.Header>

        <Modal.Body>
          {Object.values(errors).length > 0 && (
            <Alert variant="danger">
              {Object.values(errors).map((err, idx) => (
                <div key={idx}>{err}</div>
              ))}
            </Alert>
          )}

          <Form>
            <Form.Group controlId="formSupplier">
              <Form.Label>Supplier</Form.Label>
              <Form.Control
                as="select"
                name="supplierid"
                value={formData.supplierid}
                onChange={handleChange}
                disabled={isView}
                isInvalid={!!errors.supplierid}
              >
                <option value="">Select Supplier</option>
                {suppliers.map((s) => (
                  <option key={s.supplierid} value={s.supplierid}>
                    {s.suppliername}
                  </option>
                ))}
              </Form.Control>
            </Form.Group>

            <Form.Group controlId="formStatus">
              <Form.Label>Status</Form.Label>
              <Form.Control
                as="select"
                name="status"
                value={formData.status}
                onChange={handleChange}
                disabled={isView}
                isInvalid={!!errors.status}
              >
                <option value="">Select Status</option>
                <option value="Draft">Draft</option>
                <option value="Submitted">Submitted</option>
                <option value="Approved">Approved</option>
              </Form.Control>
            </Form.Group>

            <Form.Group controlId="formTotalAmount">
              <Form.Label>Total Amount</Form.Label>
              <Form.Control
                type="number"
                value={formData.totalAmount}
                name="totalAmount"
                readOnly
              />
            </Form.Group>

            {action !== "add" && (
              <div className="mt-3">
                <Button
                  variant="outline-secondary"
                  onClick={openDetails}
                  disabled={!poid}
                >
                  View/Edit PO Details
                </Button>
              </div>
            )}
          </Form>
        </Modal.Body>

        <Modal.Footer>
          <Button variant="secondary" onClick={onClose}>
            Close
          </Button>
          {!isView && (
            <Button variant="primary" onClick={handleSubmit}>
              Save
            </Button>
          )}
        </Modal.Footer>
      </Modal>

      {/* Nested PO Detail Modal */}
      {showDetailModal && (
        <PODetailModal
          show={showDetailModal}
          poid={poid}
          onClose={() => setShowDetailModal(false)}
        />
      )}
    </>
  );
};

export default POHeaderModal;
