import axios from "axios";

// Define API base URL
const API_URL = "http://localhost:8080/api/adminusers"; // Ensure this matches your backend

export const getUsers = async (page, size) =>
  axios.get(`${API_URL}?page=${page}&size=${size}`);

export const searchUsers = async (keyword, page, size) =>
  axios.get(`${API_URL}/search?keyword=${keyword}&page=${page}&size=${size}`);

export const addUser = async (user) => axios.post(API_URL, user);

export const updateUser = async (id, user) =>
  axios.put(`${API_URL}/${id}`, user);

export const deleteUser = async (id) => axios.delete(`${API_URL}/${id}`);
