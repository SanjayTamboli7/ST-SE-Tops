import React, { useEffect, useState } from 'react';
import {
  Button, Modal, ModalHeader, ModalBody, Table, Input, Pagination, PaginationItem, PaginationLink
} from 'reactstrap';
import {
  getAllUsers, deleteUser, getDepartments, getDesignations
} from './OtherAPI';
import OtherUserForm from './OtherUserForm';

const ManageOtherUsers = () => {
  const [users, setUsers] = useState([]);
  const [modalOpen, setModalOpen] = useState(false);
  const [selectedUserId, setSelectedUserId] = useState(null);
  const [formMode, setFormMode] = useState('add');
  const [search, setSearch] = useState('');
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1);
  const [departments, setDepartments] = useState([]);
  const [designations, setDesignations] = useState([]);

  const pageSize = 5;

  useEffect(() => {
    fetchLookupData();
  }, []);

  useEffect(() => {
    fetchUsers();
  }, [search, page]);

  const fetchLookupData = async () => {
    const deptRes = await getDepartments();
    const desgRes = await getDesignations();
    setDepartments(deptRes.data.content || []);
    setDesignations(desgRes.data.content || []);
  };

  const fetchUsers = async () => {
    try {
      const res = await getAllUsers(search, page, pageSize);
      setUsers(res.data.content || []);
      setTotalPages(res.data.totalPages || 1);
    } catch (err) {
      console.error('Failed to fetch users:', err);
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm("Are you sure to delete this user?")) {
      await deleteUser(id);
      fetchUsers();
    }
  };

  const toggleModal = () => {
    setModalOpen(!modalOpen);
  };

  const handleOpenForm = (mode, userId = null) => {
    setFormMode(mode);
    setSelectedUserId(userId);
    setModalOpen(true);
  };

  const resolveDeptName = (id) => {
    const found = departments.find(d => d.deptid === id);
    return found ? found.deptname : 'N/A';
  };

  const resolveDesignationName = (id) => {
    const found = designations.find(d => d.designationid === id);
    return found ? found.designationname : 'N/A';
  };

  return (
    <div className="container mt-3">
      <h4 className="mb-3">Manage Other Users</h4>
      <div className="d-flex justify-content-between mb-2">
        <Input
          placeholder="Search by name or email..."
          value={search}
          onChange={(e) => {
            setSearch(e.target.value);
            setPage(0);
          }}
          style={{ width: '300px' }}
        />
        <Button color="primary" onClick={() => handleOpenForm('add')}>
          + Add User
        </Button>
      </div>
      <Table bordered responsive>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Department</th>
            <th>Designation</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((u, index) => (
            <tr key={u.ouserid}>
              <td>{index + 1 + page * pageSize}</td>
              <td>{u.ousername}</td>
              <td>{resolveDeptName(u.ouserdeptid)}</td>
              <td>{resolveDesignationName(u.ouserdesignationid)}</td>
              <td>{u.ouseremailid}</td>
              <td>{u.ousercontactno}</td>
              <td>{u.ouserstatus === 1 ? 'Active' : 'Inactive'}</td>
              <td>
                <Button size="sm" color="info" onClick={() => handleOpenForm('view', u.ouserid)}>View</Button>{' '}
                <Button size="sm" color="warning" onClick={() => handleOpenForm('edit', u.ouserid)}>Edit</Button>{' '}
                <Button size="sm" color="danger" onClick={() => handleDelete(u.ouserid)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {/* Pagination */}
      <Pagination>
        {[...Array(totalPages)].map((_, i) => (
          <PaginationItem key={i} active={i === page}>
            <PaginationLink onClick={() => setPage(i)}>
              {i + 1}
            </PaginationLink>
          </PaginationItem>
        ))}
      </Pagination>

      <Modal isOpen={modalOpen} toggle={toggleModal}>
        <ModalHeader toggle={toggleModal}>{formMode === 'view' ? 'View User' : formMode === 'edit' ? 'Edit User' : 'Add User'}</ModalHeader>
        <ModalBody>
          <OtherUserForm
            userId={selectedUserId}
            mode={formMode}
            onClose={() => {
              toggleModal();
              fetchUsers();
            }}
          />
        </ModalBody>
      </Modal>
    </div>
  );
};

export default ManageOtherUsers;
