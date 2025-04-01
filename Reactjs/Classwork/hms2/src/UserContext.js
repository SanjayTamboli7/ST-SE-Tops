import React, { createContext, useState, useContext } from 'react';

// Create a context for user data
const UserContext = createContext();

// Create a provider component to provide the context to the rest of the app
export const UserProvider = ({ children }) => {
  const [email, setEmail] = useState('');
  const [auserid, setAUserId] = useState(null);
  const [auserstatus, setAUserStatus] = useState('');

  // Function to update user details in global context
  const updateUserDetails = (email, auserid, auserstatus) => {

    console.log("Usercontext 15 : " + email);
    console.log("Usercontext 16 : " + auserid);
    console.log("Usercontext 17 : " + auserstatus);

    setEmail(email);
    setAUserId(auserid);
    setAUserStatus(auserstatus);
  };

  // Providing the user data and the update function to the rest of the app
  return (
    <UserContext.Provider value={{ email, auserid, auserstatus, updateUserDetails }}>
      {children}
    </UserContext.Provider>
  );
};

// Custom hook to use the user context
export const useUserContext = () => {
  return useContext(UserContext);
};
