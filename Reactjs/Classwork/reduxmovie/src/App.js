import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchUsers, addUser, updateUser, deleteUser } from "./userSlice";

function App() {
  const users = useSelector((state) => state.users);
  const dispatch = useDispatch();
  const [form, setForm] = useState({ id: null, name: "", email: "" });

  useEffect(() => {
    dispatch(fetchUsers());
  }, [dispatch]);

  const handleSubmit = (e) => {
    e.preventDefault();
    form.id ? dispatch(updateUser(form)) : dispatch(addUser(form));
    setForm({ id: null, name: "", email: "" });
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>React + Redux Toolkit + MySQL (Spring Boot Backend)</h2>
      <form onSubmit={handleSubmit}>
        <input value={form.name} placeholder="Name" onChange={(e) => setForm({ ...form, name: e.target.value })} />
        <input value={form.email} placeholder="Email" onChange={(e) => setForm({ ...form, email: e.target.value })} />
        <button type="submit">{form.id ? "Update" : "Add"}</button>
      </form>
      <ul>
        {users.map((u) => (
          <li key={u.id}>
            {u.name} ({u.email}){" "}
            <button onClick={() => setForm(u)}>Edit</button>
            <button onClick={() => dispatch(deleteUser(u.id))}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
