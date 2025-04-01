import React from 'react';
import { useUserContext } from './UserContext';  // Import the custom hook

const UserDetails = () => {
  const { email, auserid, auserstatus } = useUserContext();  // Access context values

  return (
    <div>
      <h2>User Details</h2>
      <p><strong>Email:</strong> {email}</p>
      <p><strong>User ID:</strong> {auserid}</p>
      <p><strong>User Status:</strong> {auserstatus}</p>
    </div>
  );
};

export default UserDetails;
