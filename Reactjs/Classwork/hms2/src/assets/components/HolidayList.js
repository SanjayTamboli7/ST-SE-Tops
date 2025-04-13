// src/components/HolidayList.js
import React, { useEffect, useState } from 'react';
import { Table, Button, Form, Pagination } from 'react-bootstrap';
import { getHolidays, createHoliday, updateHoliday, deleteHoliday } from './holidayService';
import HolidayFormModal from './HolidayFormModal';
import { toast } from 'react-toastify';

const HolidayList = () => {
  const [holidays, setHolidays] = useState([]);
  const [pagination, setPagination] = useState({ page: 0, size: 5, totalPages: 0 });
  const [sortField, setSortField] = useState('holidaydate');
  const [sortDir, setSortDir] = useState('asc');
  const [search, setSearch] = useState('');
  const [modalShow, setModalShow] = useState(false);
  const [editData, setEditData] = useState(null);

  const fetchData = async () => {
    try {
      const res = await getHolidays({
        page: pagination.page,
        size: pagination.size,
        sortField,
        sortDir,
        search
      });
      setHolidays(res.data.content);
      setPagination(prev => ({ ...prev, totalPages: res.data.totalPages }));
    } catch (err) {
      toast.error('Failed to fetch holidays.');
    }
  };

  useEffect(() => {
    fetchData();
  }, [pagination.page, sortField, sortDir, search]);

  const handleDelete = async (date) => {
    if (window.confirm('Delete this holiday?')) {
      try {
        await deleteHoliday(date);
        toast.success('Deleted successfully');
        fetchData();
      } catch {
        toast.error('Delete failed');
      }
    }
  };

  const handleSave = async (data) => {
    try {
      if (editData) {
        await updateHoliday(editData.holidaydate, data);
        toast.success('Updated');
      } else {
        await createHoliday(data);
        toast.success('Created');
      }
      setModalShow(false);
      fetchData();
    } catch {
      toast.error('Save failed');
    }
  };

  const changePage = (newPage) => setPagination(prev => ({ ...prev, page: newPage }));

  return (
    <div className="container mt-4">
      <h4>Holiday Management</h4>

      <div className="d-flex justify-content-between mb-2">
        <Form.Control
          type="text"
          placeholder="Search..."
          value={search}
          onChange={(e) => { setSearch(e.target.value); setPagination(p => ({ ...p, page: 0 })) }}
          style={{ width: '250px' }}
        />
        <Button onClick={() => { setEditData(null); setModalShow(true); }}>Add Holiday</Button>
      </div>

      <Table bordered hover>
        <thead>
          <tr>
            {['holidaydate', 'holidayname', 'holidaytype'].map(col => (
              <th key={col} onClick={() => {
                setSortField(col);
                setSortDir(d => d === 'asc' ? 'desc' : 'asc');
              }} style={{ cursor: 'pointer' }}>
                {col} {sortField === col ? (sortDir === 'asc' ? '▲' : '▼') : ''}
              </th>
            ))}
            <th>Description</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {holidays.map(holiday => (
            <tr key={holiday.holidaydate}>
              <td>{holiday.holidaydate}</td>
              <td>{holiday.holidayname}</td>
              <td>{holiday.holidaytype}</td>
              <td>{holiday.holidaydescription}</td>
              <td>
                <Button size="sm" variant="warning" onClick={() => { setEditData(holiday); setModalShow(true); }}>Edit</Button>{' '}
                <Button size="sm" variant="danger" onClick={() => handleDelete(holiday.holidaydate)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      <Pagination>
        {[...Array(pagination.totalPages).keys()].map(p => (
          <Pagination.Item key={p} active={p === pagination.page} onClick={() => changePage(p)}>
            {p + 1}
          </Pagination.Item>
        ))}
      </Pagination>

      <HolidayFormModal
        show={modalShow}
        handleClose={() => setModalShow(false)}
        handleSave={handleSave}
        isEdit={!!editData}
        initialData={editData}
        holidays={holidays}
      />
    </div>
  );
};

export default HolidayList;
