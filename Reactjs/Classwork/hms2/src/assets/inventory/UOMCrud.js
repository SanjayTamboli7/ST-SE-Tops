import React, { useEffect, useState } from "react";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function UOMCrud() {
  const [uoms, setUoms] = useState([]);
  const [search, setSearch] = useState("");
  const [alert, setAlert] = useState(null);
  const [editingUom, setEditingUom] = useState(null);
  const [modalVisible, setModalVisible] = useState(false);
  const [form, setForm] = useState({ uomname: "", description: "" });
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [sortField, setSortField] = useState("uomname");
  const [sortDir, setSortDir] = useState("asc");

  const pageSize = 10;

  const loadData = () => {
    axios
      .get("http://localhost:8080/api/uoms", {
        params: {
          search,
          page,
          size: pageSize,
          sortField,
          sortDir
        }
      })
      .then((res) => {
        setUoms(res.data.content);
        setTotalPages(res.data.totalPages);
      });
  };

  useEffect(() => {
    loadData();
  }, [search, page, sortField, sortDir]);

  const handleSave = () => {
    const userId = sessionStorage.getItem("userid") || 1;
    const method = editingUom ? "put" : "post";
    const url = editingUom
      ? `http://localhost:8080/api/uoms/${editingUom.uomid}?userId=${userId}`
      : `http://localhost:8080/api/uoms?userId=${userId}`;

    axios[method](url, form).then(() => {
      setAlert({ type: "success", message: "Saved successfully!" });
      setModalVisible(false);
      setForm({ uomname: "", description: "" });
      setEditingUom(null);
      loadData();
    });
  };

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8080/api/uoms/${id}`).then(() => {
      setAlert({ type: "danger", message: "Deleted successfully!" });
      loadData();
    });
  };

  const handleSort = (field) => {
    const dir = sortField === field && sortDir === "asc" ? "desc" : "asc";
    setSortField(field);
    setSortDir(dir);
  };

  return (
    <div className="container mt-4">
      <h3>UOM Management</h3>

      {alert && (
        <div className={`alert alert-${alert.type} alert-dismissible`} role="alert">
          {alert.message}
          <button type="button" className="btn-close" onClick={() => setAlert(null)}></button>
        </div>
      )}

      <div className="d-flex justify-content-between mb-2">
        <input
          type="text"
          placeholder="Search UOM or Description..."
          className="form-control w-50"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
        <button className="btn btn-primary" onClick={() => setModalVisible(true)}>
          Add
        </button>
      </div>

      <table className="table table-bordered">
        <thead>
          <tr>
            <th onClick={() => handleSort("uomname")} style={{ cursor: "pointer" }}>
              UOM Name {sortField === "uomname" && (sortDir === "asc" ? "↑" : "↓")}
            </th>
            <th onClick={() => handleSort("description")} style={{ cursor: "pointer" }}>
              Description {sortField === "description" && (sortDir === "asc" ? "↑" : "↓")}
            </th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {uoms.map((uom) => (
            <tr key={uom.uomid}>
              <td>{uom.uomname}</td>
              <td>{uom.description}</td>
              <td>
                <button
                  className="btn btn-sm btn-warning me-2"
                  onClick={() => {
                    setEditingUom(uom);
                    setForm({ uomname: uom.uomname, description: uom.description });
                    setModalVisible(true);
                  }}
                >
                  Edit
                </button>
                <button className="btn btn-sm btn-danger" onClick={() => handleDelete(uom.uomid)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
          {uoms.length === 0 && (
            <tr>
              <td colSpan="3" className="text-center">
                No data found
              </td>
            </tr>
          )}
        </tbody>
      </table>

      <nav>
        <ul className="pagination">
          {Array.from({ length: totalPages }, (_, i) => (
            <li key={i} className={`page-item ${i === page ? "active" : ""}`}>
              <button className="page-link" onClick={() => setPage(i)}>
                {i + 1}
              </button>
            </li>
          ))}
        </ul>
      </nav>

      {/* Modal */}
      {modalVisible && (
        <div className="modal show fade d-block" tabIndex="-1">
          <div className="modal-dialog">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">{editingUom ? "Edit UOM" : "Add UOM"}</h5>
                <button type="button" className="btn-close" onClick={() => setModalVisible(false)}></button>
              </div>
              <div className="modal-body">
                <input
                  type="text"
                  className="form-control mb-2"
                  placeholder="UOM Name"
                  value={form.uomname}
                  onChange={(e) => setForm({ ...form, uomname: e.target.value })}
                />
                <input
                  type="text"
                  className="form-control mb-2"
                  placeholder="Description"
                  value={form.description}
                  onChange={(e) => setForm({ ...form, description: e.target.value })}
                />
              </div>
              <div className="modal-footer">
                <button className="btn btn-secondary" onClick={() => setModalVisible(false)}>
                  Cancel
                </button>
                <button className="btn btn-success" onClick={handleSave}>
                  Save
                </button>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

// export default UomManager;
