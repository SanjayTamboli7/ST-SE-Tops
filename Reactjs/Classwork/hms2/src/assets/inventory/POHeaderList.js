import React, { useEffect, useState } from "react";
import axios from "axios";
import { Button, Table, Alert, Form, Pagination } from "react-bootstrap";
import POHeaderModal from "./POHeaderModal";

const POHeaderList = () => {
  const [poHeaders, setPoHeaders] = useState([]);
  const [filteredData, setFilteredData] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [pageSize] = useState(5);
  const [showModal, setShowModal] = useState(false);
  const [modalMode, setModalMode] = useState("add"); // add | edit | view
  const [selectedPO, setSelectedPO] = useState(null);
  const [showAlert, setShowAlert] = useState({ type: "", message: "" });

  // Fetch PO Headers
  useEffect(() => {
    fetchPOHeaders();
  }, []);

  const fetchPOHeaders = () => {
    axios
      .get("http://localhost:8080/api/poheaders")
      .then((res) => {
        console.log(res.data);
        const data = Array.isArray(res.data) ? res.data : [];
        setPoHeaders(data);
        setFilteredData(data);
      })
      .catch((err) => {
        console.error("Error fetching PO headers:", err);
        setShowAlert({ type: "danger", message: "Failed to load PO headers." });
      });
  };

  // Search handling
  useEffect(() => {
    const term = searchTerm.toLowerCase();
    const filtered = poHeaders.filter(
      (po) =>
        po.poid?.toString().includes(term) ||
        po.suppliername?.toLowerCase().includes(term) ||
        po.status?.toLowerCase().includes(term)
    );
    setFilteredData(filtered);
    setCurrentPage(1);
  }, [searchTerm, poHeaders]);

  const totalPages = Math.ceil(filteredData.length / pageSize);
  const currentData = filteredData.slice(
    (currentPage - 1) * pageSize,
    currentPage * pageSize
  );

  const handleAdd = () => {
    setModalMode("add");
    setSelectedPO(null);
    setShowModal(true);
  };

  const handleEdit = (po) => {
    setModalMode("edit");
    setSelectedPO(po);
    setShowModal(true);
  };

  const handleView = (po) => {
    setModalMode("view");
    setSelectedPO(po);
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
    setSelectedPO(null);
  };

  return (
    <div className="container mt-3">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <Form.Control
          type="text"
          placeholder="Search by PO ID, Supplier, or Status"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={{ width: "60%" }}
        />
        <Button variant="primary" onClick={handleAdd}>
          Add PO
        </Button>
      </div>

      {showAlert.message && (
        <Alert
          variant={showAlert.type}
          onClose={() => setShowAlert({ type: "", message: "" })}
          dismissible
        >
          {showAlert.message}
        </Alert>
      )}

      <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>PO ID</th>
            <th>Supplier</th>
            <th>Total Amount</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {currentData.length > 0 ? (
            currentData.map((po) => (
              <tr key={po.poid}>
                <td>{po.poid}</td>
                <td>{po.suppliername}</td>
                <td>{po.totalAmount}</td>
                <td>{po.status}</td>
                <td>
                  <Button
                    variant="outline-success"
                    size="sm"
                    onClick={() => handleView(po)}
                  >
                    View
                  </Button>{" "}
                  <Button
                    variant="outline-primary"
                    size="sm"
                    onClick={() => handleEdit(po)}
                    disabled={po.status !== "Draft"}
                  >
                    Edit
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="5" className="text-center">
                No records found.
              </td>
            </tr>
          )}
        </tbody>
      </Table>

      {totalPages > 1 && (
        <Pagination>
          {[...Array(totalPages)].map((_, index) => (
            <Pagination.Item
              key={index}
              active={index + 1 === currentPage}
              onClick={() => setCurrentPage(index + 1)}
            >
              {index + 1}
            </Pagination.Item>
          ))}
        </Pagination>
      )}

      {showModal && (
        <POHeaderModal
          show={showModal}
          onClose={handleCloseModal}
          poData={selectedPO}
          action={modalMode}
          setPOData={fetchPOHeaders}
          setShowAlert={setShowAlert}
        />
      )}
    </div>
  );
};

export default POHeaderList;
