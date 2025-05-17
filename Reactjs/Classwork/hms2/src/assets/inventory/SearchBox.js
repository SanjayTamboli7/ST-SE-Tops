import React from 'react';
import { Form } from 'react-bootstrap';

function SearchBox({ value, onChange }) {
  return (
    <Form.Control
      type="text"
      placeholder="Search PO No or Supplier..."
      value={value}
      onChange={(e) => onChange(e.target.value)}
    />
  );
}

export default SearchBox;
