import { useCallback, useEffect, useState } from 'react';
import axios from 'axios';

const PAGE_SIZE = 10;

export default function usePurchaseOrder(searchTerm) {
  const [headers, setHeaders] = useState([]);
  const [pagination, setPagination] = useState({ page: 1, totalPages: 1 });

  const fetchHeaders = useCallback(async (page = 1) => {
    try {
      const response = await axios.get('/api/poheaders', {
        params: {
          page: page - 1, // Spring Boot uses 0-based paging
          size: PAGE_SIZE,
          sortBy: 'podate',
          direction: 'DESC',
          search: searchTerm || ''
        }
      });
      setHeaders(response.data.content || []);
      setPagination({
        page: response.data.number + 1,
        totalPages: response.data.totalPages
      });
    } catch (err) {
      console.error('Failed to fetch POs', err);
    }
  }, [searchTerm]);

  useEffect(() => {
    fetchHeaders(1);
  }, [fetchHeaders]);

  const handleAdd = async (data) => {
    try {
      await axios.post('/api/poheaders', data);
      await fetchHeaders(1);
    } catch (err) {
      console.error('Add failed', err);
      throw err;
    }
  };

  const handleUpdate = async (data) => {
    try {
      await axios.put(`/api/poheaders/${data.poid}`, data);
      await fetchHeaders(pagination.page);
    } catch (err) {
      console.error('Update failed', err);
      throw err;
    }
  };

  const handleDelete = async (poid) => {
    try {
      await axios.delete(`/api/poheaders/${poid}`);
      await fetchHeaders(pagination.page);
    } catch (err) {
      console.error('Delete failed', err);
    }
  };

  const handleFetchFromPR = async (supplierid) => {
    if (!supplierid) return [];
    try {
      const response = await axios.get(`/api/pritems/${supplierid}`);
      return response.data.map((pr) => ({
        itemid: pr.itemid,
        qty: pr.qty,
        rate: 0,
        amount: 0,
        prid: pr.prid
      }));
    } catch (err) {
      console.error('Fetch from PR failed', err);
      return [];
    }
  };

  return {
    headers,
    pagination,
    fetchHeaders,
    handleAdd,
    handleUpdate,
    handleDelete,
    handleFetchFromPR
  };
}
