import React, { useEffect, useState } from "react";
import { Table, Button } from "react-bootstrap";
import { getUsers, deleteUser, searchUsers } from "./Api";

const AdminUserList = ({ onEdit }) => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  const handleDelete = async (id) => {
    await deleteUser(id);
    loadUsers();
  };

  const [page, setPage] = useState(0);

  useEffect(() => {
    loadUsers();
  }, [page]);
   
  const loadUsers = async () => {
    try {
        const response = await getUsers(page, 5);
        setUsers(response.data?.content || []);  // ✅ Ensure it's always an array
    } catch (error) {
        console.error("Error fetching users:", error);
        setUsers([]);  // ✅ Fallback to an empty array
    }
};

  const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = async () => {
    try {
        const response = await searchUsers(searchTerm, page, 5);
        setUsers(response.data?.content || []);  // ✅ Ensure it's always an array
    } catch (error) {
        console.error("Error searching users:", error);
        setUsers([]);  // ✅ Fallback to an empty array
    }
};

  return (
    <div>
      <input type="text" value={searchTerm} onChange={(e) => setSearchTerm(e.target.value)} />
      <Button onClick={handleSearch}>Search</Button>

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
    </div>
  );
};

export default AdminUserList;
