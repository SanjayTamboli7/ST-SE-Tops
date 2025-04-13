import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/holidays';

export const getHolidays = (params) => axios.get(BASE_URL, { params });
export const getHoliday = (date) => axios.get(`${BASE_URL}/${date}`);
export const createHoliday = (data) => axios.post(BASE_URL, data);
export const updateHoliday = (date, data) => axios.put(`${BASE_URL}/${date}`, data);
export const deleteHoliday = (date) => axios.delete(`${BASE_URL}/${date}`);
