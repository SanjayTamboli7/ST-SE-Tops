import React from 'react';
import { Badge } from 'react-bootstrap';

function StatusBadge({ status }) {
  let variant = 'secondary';
  switch (status) {
    case 'Pending':
      variant = 'warning';
      break;
    case 'Approved':
      variant = 'success';
      break;
    case 'Rejected':
      variant = 'danger';
      break;
    case 'Hold':
      variant = 'info';
      break;
    default:
      variant = 'secondary';
  }

  return <Badge bg={variant}>{status}</Badge>;
}

export default StatusBadge;
