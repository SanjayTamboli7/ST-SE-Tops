import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Table, Button, Spinner, Alert, Pagination, Form, InputGroup } from 'react-bootstrap';

const DesignationList = ({ onEdit }) => {
  const [designations, setDesignations] = useState([]);
  const [filteredDesignations, setFilteredDesignations] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [sortField, setSortField] = useState('designationname');
  const [sortDir, setSortDir] = useState('asc');
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [searchTerm, setSearchTerm] = useState('');
  const pageSize = 5;

  useEffect(() => {
    fetchDesignations();
  }, [sortField, sortDir, currentPage]);

  useEffect(() => {
    applySearchFilter();
  }, [searchTerm, designations]);

  const fetchDesignations = async () => {
    try {
      setLoading(true);
      const response = await axios.get(`http://localhost:8080/api/designations`, {
        params: {
          page: currentPage,
          size: pageSize,
          sort: `${sortField},${sortDir}`,
          search: searchTerm  // pass search term
        }
      });
      const result = response.data;
      if (Array.isArray(result.content)) {
        setDesignations(result.content);
        setTotalPages(result.totalPages);
      } else {
        setDesignations([]);
        setTotalPages(0);
      }
      setError(null);
    } catch (err) {
      console.error("Error fetching data:", err);
      setError("Error fetching data!");
      setDesignations([]);
      setTotalPages(0);
    } finally {
      setLoading(false);
    }
  }; 

  const applySearchFilter = () => {
    if (searchTerm.trim() === '') {
      setFilteredDesignations(designations);
    } else {
      const lower = searchTerm.toLowerCase();
      const filtered = designations.filter(d =>
        d.designationname.toLowerCase().includes(lower)
      );
      setFilteredDesignations(filtered);
    }
  };

  const handleSort = (field) => {
    if (sortField === field) {
      setSortDir(prev => (prev === 'asc' ? 'desc' : 'asc'));
    } else {
      setSortField(field);
      setSortDir('asc');
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure you want to delete this designation?")) {
      try {
        await axios.delete(`http://localhost:8080/api/designations/${id}`);
        fetchDesignations();
      } catch (err) {
        console.error("Delete error:", err);
        alert("Failed to delete designation");
      }
    }
  };

  const handlePageChange = (pageNumber) => {
    setCurrentPage(pageNumber);
  };

  const renderPagination = () => {
    let items = [];
    for (let i = 0; i < totalPages; i++) {
      items.push(
        <Pagination.Item
          key={i}
          active={i === currentPage}
          onClick={() => handlePageChange(i)}
        >
          {i + 1}
        </Pagination.Item>
      );
    }
    return <Pagination>{items}</Pagination>;
  };

  return (
    <div>
      <h2 className="mb-3">Designation List</h2>

      <InputGroup className="mb-3">
        <Form.Control
          type="text"
          placeholder="Search by designation name"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </InputGroup>

      {error && <Alert variant="danger">{error}</Alert>}

      {loading ? (
        <div className="text-center py-5">
          <Spinner animation="border" />
        </div>
      ) : (
        Array.isArray(filteredDesignations) && filteredDesignations.length > 0 ? (
          <>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>ID</th>
                  <th onClick={() => handleSort('designationname')} style={{ cursor: 'pointer' }}>
                    Designation Name {sortField === 'designationname' && (sortDir === 'asc' ? '↑' : '↓')}
                  </th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {filteredDesignations.map((designation) => (
                  <tr key={designation.designationid}>
                    <td>{designation.designationid}</td>
                    <td>{designation.designationname}</td>
                    <td>{designation.dutytype}</td>
                    <td>
                      <Button variant="primary" size="sm" onClick={() => onEdit(designation)} className="me-2">
                        Edit
                      </Button>
                      <Button variant="danger" size="sm" onClick={() => handleDelete(designation.designationid)}>
                        Delete
                      </Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <div className="d-flex justify-content-center">{renderPagination()}</div>
          </>
        ) : (
          <div className="text-center py-4">
            <p>No designations found.</p>
          </div>
        )
      )}
    </div>
  );
};

export default DesignationList;
