import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/poheaders';

export const getPOHeaders = (search, page, size, sortBy, asc) =>
  axios.get(`${BASE_URL}?search=${search}&page=${page}&size=${size}&sortBy=${sortBy}&asc=${asc}`);

export const getPOHeaderById = (id) => axios.get(`${BASE_URL}/${id}`);

export const createPO = (data) => axios.post(`${BASE_URL}?sortBy=poid&asc=true`, data);

export const updatePO = (id, data) => axios.put(`${BASE_URL}/${id}`, data);

export const deletePO = (id) => axios.delete(`${BASE_URL}/${id}`);

export const getSuppliers = () => axios.get('http://localhost:8080/api/suppliers');

export const getItems = () => axios.get('http://localhost:8080/api/items');

export const getItemsFromPurchaseRequest = (supplierid) =>
  axios.get(`http://localhost:8080/api/txnpurchaserequest/frompo?supplierid=${supplierid}`);
