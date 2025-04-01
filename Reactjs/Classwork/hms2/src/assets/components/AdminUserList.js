import React, { useEffect, useState } from "react";
import { Table, Button } from "react-bootstrap";
import { getUsers, deleteUser, searchUsers } from "./Api";
import "./styles.css";

const AdminUserList = ({ onEdit }) => {
  const [users, setUsers] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(1); // Default to 1
  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    loadUsers();
  }, [page]); // Re-fetch users when `page` changes

  const handleDelete = async (id) => {
    await deleteUser(id);
    loadUsers();
  };

  // const [page, setPage] = useState(0);

  useEffect(() => {
    loadUsers();
  }, [page]);
   
  const loadUsers = async () => {
    try {
      const response = await getUsers(page, 5); // Fetch 5 records per page
      setUsers(response.data?.content || []);
      setTotalPages(response.data?.totalPages || 1); // Set total pages
    } catch (error) {
      console.error("Error fetching users:", error);
      setUsers([]);
    }
  };

  // const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = async () => {
    try {
      const response = await searchUsers(searchTerm, page, 5);
      setUsers(response.data?.content || []);
      setTotalPages(response.data?.totalPages || 1);
    } catch (error) {
      console.error("Error searching users:", error);
      setUsers([]);
    }
  };

  return (
    <div>
      {/* Search Box */}
      <input
        type="text"
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      <Button onClick={handleSearch}>Search</Button>

      {/* User Table */}
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.auserid}>
              <td>{user.auserid}</td>
              <td>{user.ausername}</td>
              <td>{user.auseremailid}</td>
              <td>{user.ausercontactno}</td>
              <td>{user.auserstatus}</td>
              <td>
                <Button variant="primary" onClick={() => onEdit(user)}>Edit</Button>{" "}
                <Button variant="danger" onClick={() => handleDelete(user.auserid)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>

      {/* Pagination Controls */}
      <div className="pagination">
        <Button
          onClick={() => setPage(page - 1)}
          disabled={page === 0}
        >
          Previous
        </Button>{" "}
        <span>Page {page + 1} of {totalPages}</span>{" "}
        <Button
          onClick={() => setPage(page + 1)}
          disabled={page + 1 >= totalPages}
        >
          Next
        </Button>
      </div>
    </div>
  );
}
export default AdminUserList;
