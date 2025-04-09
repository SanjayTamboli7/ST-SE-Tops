import axios from "axios";
const BASE_URL = "http://localhost:8080/api";

export const getUsers = (search, page, size, sortBy, direction) =>
  axios.get(`${BASE_URL}/otherusers`, {
    params: { search, page, size, sortBy, direction }
  });

export const getUser = (id) => axios.get(`${BASE_URL}/otherusers/${id}`);
export const addUser = (data) => axios.post(`${BASE_URL}/otherusers`, data);
export const getDepartments = () => axios.get(`${BASE_URL}/departments`);
export const getDesignations = () => axios.get(`${BASE_URL}/designations`);

const API_BASE_URL = 'http://localhost:8080/api/otherusers'; // Update base URL if different

export const getAllUsers = (search = '', page = 0, size = 10, sortBy = 'ouserid', direction = 'asc') => {
  return axios.get(`${API_BASE_URL}?search=${search}&page=${page}&size=${size}&sortBy=${sortBy}&direction=${direction}`);
};

export const getUserById = (id) => {
  return axios.get(`${API_BASE_URL}/${id}`);
};

// export const saveUser = (user) => {
//   return axios.post(API_BASE_URL, user);
// };

export const saveUser = (user) => {
    return axios.post(`${BASE_URL}/otherusers`, user);
  };
  
export const updateUser = (id, user) => {
  return axios.put(`${API_BASE_URL}/${id}`, user);
};

export const deleteUser = (id) => {
  return axios.delete(`${API_BASE_URL}/${id}`);
};
