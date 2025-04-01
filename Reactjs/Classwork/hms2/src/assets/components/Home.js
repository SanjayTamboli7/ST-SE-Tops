import React, { useEffect } from 'react';
import { Outlet, useLocation } from 'react-router-dom';
import ErrorBoundary from './ErrorBoundary';
import { useParams } from 'react-router-dom'
import Header from './Header';
import Menu from './Menu';
import Footer from './Footer';
import { menuItems } from './menuData';
import { UserProvider } from '../..//UserContext';  
import UserDetails from '../../UserDetails';
import { fetchUserDetails } from './fetchUserDetails';  

const Home = () => {

  const { email } = useParams();
  const location = useLocation();

  console.log("Home 180: "+email[0]);
  console.log("Home 181: "+email[1]);

  useEffect(() => {
    // Log when Home renders and the current path
    console.log("Home component rendered, current path:", location.pathname);
    console.log("Available menu items:", menuItems);
  }, [location]);

  // New code begins here
  useEffect(() => {
    // Fetch user details 

    // Function to update user details in global context
    const updateUserDetails = (email) => {
      console.log("Home Line 32 :" + email);
    };

    const getUserDetails = async () => {
      // await fetchUserDetails(email, fetchUserDetails);  // Call fetchUserDetails to update the context
      console.log("Home Line 37 :" + email);
      await fetchUserDetails(email, updateUserDetails);  // Call fetchUserDetails to update the context
    };

    getUserDetails();
  }, [email]);
  // New code ends here

  return (
    <div className="home-container">

      <UserProvider>
        <div>
          <h1>User Info</h1>
          <UserDetails />  {/* The UserDetails component will get values from context */}
        </div>
      </UserProvider>

      <Header />
      <ErrorBoundary>
        <Menu menuItems={menuItems} />
      </ErrorBoundary>
      <main className="content-area">
        <ErrorBoundary>
          <Outlet />
        </ErrorBoundary>
      </main>
      <Footer />
    </div>
  );
};

export default Home;
