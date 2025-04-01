import React, { useEffect } from 'react';
import { Outlet, useLocation } from 'react-router-dom';
import ErrorBoundary from './ErrorBoundary';
import { useParams, useNavigate } from 'react-router-dom'
import Header from './Header';
import Menu from './Menu';
import Footer from './Footer';
import { menuItems } from './menuData';
import { UserProvider } from '../../UserContext';  
import UserDetails from '../../UserDetails';
import { useUserContext } from "../../UserContext";
import { fetchUserDetails } from './fetchUserDetails';  
import DepartmentList from './DepartmentList';

const Home = () => {

  const { email } = useParams();
  const location = useLocation();
  const { updateUserDetails } = useUserContext();
  const navigate = useNavigate();
    
  console.log("Home 18-"+email);
  // alert("Home 18:");
  useEffect(() => {
    // Log when Home renders and the current path
    console.log("Home component rendered, current path:", location.pathname);
    console.log("Available menu items:", menuItems);
  }, [location]);

    // New code begins here    
    useEffect(() => {
      const fetchData = async () => {
        const userDetails = await fetchUserDetails(email);
        if (userDetails) {
          console.log('✅ User details fetched:', userDetails);
          updateUserDetails(userDetails.email, userDetails.auserid, userDetails.auserstatus);
        } else {
          console.error('❌ No user details found. Redirecting to login...');
          navigate('/');
        }
      };
    
      if (email) {
        fetchData();
      }
    }, [email, navigate, updateUserDetails]);
  // New code ends here

  useEffect(() => {
    const fetchData = async () => {
      const userDetails = await fetchUserDetails(); // Fetch user details from API
      if (userDetails) {
        console.log("✅ Setting UserContext in Home.js:", userDetails);
        updateUserDetails(userDetails.email, userDetails.auserid, userDetails.auserstatus);
      }
    };
    fetchData();
  }, []); // ✅ Run only once when Home.js loads

  return (
    <div className="home-container">
      <UserProvider>
        <div>
          <h1>User Info</h1>
          <UserDetails />  {/* The UserDetails component will get values from context */}
        </div>
        <Header />
      <ErrorBoundary>
        <Menu menuItems={menuItems} />
      </ErrorBoundary>
      {/* <main className="content-area">
        <ErrorBoundary>
          <Outlet />
        </ErrorBoundary>        
      </main> */}
        <main className="content-area">
          <DepartmentList /> {/* DepartmentList should be wrapped inside UserProvider */}
        </main>      
      <Footer />        
      </UserProvider>

    </div>
  );
};

export default Home;
