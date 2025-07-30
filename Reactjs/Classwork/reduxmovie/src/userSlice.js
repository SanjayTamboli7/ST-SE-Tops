import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const API = "http://localhost:8080/api/users";

export const fetchUsers = createAsyncThunk("users/fetch", async () => {
  const res = await axios.get(API);
  return res.data;
});

export const addUser = createAsyncThunk("users/add", async (user) => {
  const res = await axios.post(API, user);
  return res.data;
});

export const updateUser = createAsyncThunk("users/update", async (user) => {
  const res = await axios.put(`${API}/${user.id}`, user);
  return res.data;
});

export const deleteUser = createAsyncThunk("users/delete", async (id) => {
  await axios.delete(`${API}/${id}`);
  return id;
});

const userSlice = createSlice({
  name: "users",
  initialState: [],
  extraReducers: (builder) => {
    builder
      .addCase(fetchUsers.fulfilled, (state, action) => action.payload)
      .addCase(addUser.fulfilled, (state, action) => void state.push(action.payload))
      .addCase(updateUser.fulfilled, (state, action) => {
        const i = state.findIndex((u) => u.id === action.payload.id);
        if (i !== -1) state[i] = action.payload;
      })
      .addCase(deleteUser.fulfilled, (state, action) =>
        state.filter((u) => u.id !== action.payload)
      );
  },
});

export default userSlice.reducer;
