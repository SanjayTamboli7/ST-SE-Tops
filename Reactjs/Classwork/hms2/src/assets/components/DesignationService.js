import axios from './axiosInstance';

const API_URL = '/designations';

export const getDesignations = (search = '', page = 0, size = 5, sortField = 'designationname', sortDir = 'asc') =>
  axios.get(`${API_URL}?search=${search}&page=${page}&size=${size}&sortField=${sortField}&sortDir=${sortDir}`);

export const getDesignationById = id => axios.get(`${API_URL}/${id}`);

export const addDesignation = data => axios.post(API_URL, data);

export const updateDesignation = (id, data) => axios.put(`${API_URL}/${id}`, data);

export const deleteDesignation = id => axios.delete(`${API_URL}/${id}`);
