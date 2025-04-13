import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Table, Button, Form, Pagination } from 'react-bootstrap';
import { toast } from 'react-toastify';
import LeaveAppModal from './LeaveAppModal';

const LeaveAppList = () => {
  const [data, setData] = useState([]);
  const [formData, setFormData] = useState({});
  const [showModal, setShowModal] = useState(false);
  const [isViewOnly, setIsViewOnly] = useState(false);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [keyword, setKeyword] = useState('');
  const [sortBy, setSortBy] = useState('leaveappid');
  const [direction, setDirection] = useState('asc');

  const fetchData = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/api/leaves`, {
        params: { page, keyword, sortBy, direction }
      });
      setData(res.data.content);
      setTotalPages(res.data.totalPages);
    } catch (error) {
      toast.error('Failed to load data');
    }
  };

  useEffect(() => { fetchData(); }, [page, keyword, sortBy, direction]);

  const handleDelete = async (id) => {
    if (window.confirm('Delete this record?')) {
      await axios.delete(`http://localhost:8080/api/leaves/${id}`);
      toast.success('Deleted successfully');
      fetchData();
    }
  };

  const handleSave = async () => {
    try {
      if (formData.leaveappid) {
        await axios.put(`http://localhost:8080/api/leaves/${formData.leaveappid}`, formData);
        toast.success('Updated successfully');
      } else {
        await axios.post(`http://localhost:8080/api/leaves`, formData);
        toast.success('Saved successfully');
      }
      setShowModal(false);
      setFormData({});
      fetchData();
    } catch {
      toast.error('Save failed');
    }
  };

  const handleStatusChange = async (id, newStatus) => {
    try {
      await axios.patch(`http://localhost:8080/api/leaves/${id}/status`, null, {
        params: { status: newStatus }
      });
      toast.success(`Leave ${newStatus}`);
      fetchData();
    } catch (error) {
      toast.error('Failed to update status');
    }
  };


  return (
    <div className="container mt-4">
      <h4 className="mb-3">Leave Applications</h4>
      <div className="d-flex justify-content-between mb-2">
        <Form.Control style={{ width: '300px' }} placeholder="Search..." value={keyword} onChange={(e) => setKeyword(e.target.value)} />
        <Button onClick={() => { setFormData({}); setIsViewOnly(false); setShowModal(true); }}>+ Add New</Button>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th onClick={() => setSortBy('leaveappid')}>ID</th>
            <th onClick={() => setSortBy('leaveappdate')}>App Date</th> {/* NEW */}
            <th onClick={() => setSortBy('leaveapptype')}>Type</th>
            <th onClick={() => setSortBy('leaveappstatus')}>Status</th>
            <th>From</th>
            <th>To</th>
            <th>Full/Half</th> {/* NEW */}
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item) => {
            console.log('Row status:', item.leaveappid, `"${item.leaveappstatus}"`);

            return (
              <tr key={item.leaveappid}>
                <td>{item.leaveappid}</td>
                <td>{new Date(item.leaveappdate).toLocaleDateString()}</td>
                <td>{item.leaveapptype}</td>
                <td>
                  <span className={`badge ${item.leaveappstatus === 'Approved' ? 'bg-success' :
                      item.leaveappstatus === 'Rejected' ? 'bg-danger' :
                        'bg-secondary'
                    }`}>
                    {item.leaveappstatus}
                  </span>
                </td>
                <td>{item.leavefromdate}</td>
                <td>{item.leavetodate}</td>
                <td>{item.leavefullhalfflag}</td>
                <td>
                  <Button size="sm" variant="secondary" onClick={() => {
                    setFormData(item);
                    setIsViewOnly(true);
                    setShowModal(true);
                  }}>
                    View
                  </Button>{' '}

                  {item.leaveappstatus === 'Pending' && (
                    <>
                      <Button size="sm" variant="info" onClick={() => {
                        setFormData(item);
                        setIsViewOnly(false);
                        setShowModal(true);
                      }}>
                        Edit
                      </Button>{' '}
                      <Button size="sm" variant="danger" onClick={() => handleDelete(item.leaveappid)}>
                        Delete
                      </Button>{' '}
                      <Button size="sm" variant="success" onClick={() => handleStatusChange(item.leaveappid, 'Approved')}>
                        Approve
                      </Button>{' '}
                      <Button size="sm" variant="warning" onClick={() => handleStatusChange(item.leaveappid, 'Rejected')}>
                        Reject
                      </Button>
                    </>
                  )}

                  {/* ✅ Withdraw button debug */}
                  {item.leaveappstatus?.trim().toLowerCase() === 'approved' && (
                    <Button size="sm" variant="warning" onClick={() => handleStatusChange(item.leaveappid, 'Withdrawn')}>
                      Withdraw
                    </Button>
                  )}
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>

      <Pagination>
        {[...Array(totalPages).keys()].map((num) => (
          <Pagination.Item key={num} active={num === page} onClick={() => setPage(num)}>
            {num + 1}
          </Pagination.Item>
        ))}
      </Pagination>

      <LeaveAppModal
        show={showModal}
        handleClose={() => setShowModal(false)}
        handleSave={handleSave}
        formData={formData}
        setFormData={setFormData}
        isViewOnly={isViewOnly}
      />
    </div>
  );
};

export default LeaveAppList;
