import React, { createContext, useState, useContext, useCallback } from "react";

const UserContext = createContext();

// export const useUserContext = () => useContext(UserContext);
export const useUserContext = () => {
  return useContext(UserContext);
};

export const UserProvider = ({ children }) => {
  const [userDetails, setUserDetails] = useState({
    email: undefined,
    auserid: null,
    auserstatus: 'Error'
  });

  const updateUserDetails = (email, auserid, auserstatus) => {
    console.log('🔄 Updating UserContext...');
    setUserDetails({ email, auserid, auserstatus });
  };

  return (
    <UserContext.Provider value={{ ...userDetails, updateUserDetails }}>
      {children}
    </UserContext.Provider>
  );
};
