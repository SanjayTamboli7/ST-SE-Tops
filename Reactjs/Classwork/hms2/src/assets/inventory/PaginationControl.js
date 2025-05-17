import React from 'react';
import { Pagination } from 'react-bootstrap';

function PaginationControl({ pagination, onPageChange }) {
  const { currentPage, totalPages } = pagination;

  if (totalPages <= 1) return null;

  const pages = [];
  for (let number = 1; number <= totalPages; number++) {
    pages.push(
      <Pagination.Item
        key={number}
        active={number === currentPage}
        onClick={() => onPageChange(number)}
      >
        {number}
      </Pagination.Item>
    );
  }

  return <Pagination>{pages}</Pagination>;
}

export default PaginationControl;
