import axios from 'axios';
// import { useUserContext } from './UserContext';  // Import the custom hook

// Common function to fetch user details and update context
export const fetchUserDetails = async (email, updateUserDetails) => {
  try {
    // const response = await axios.get(`http://localhost:8080/api/adminuserdetails/fetchUserDetails?email=${email}`);
    const response = await axios.get(`http://localhost:8080/api/adminuserdetails/fetchUserDetails?email=`+email);
    const { auserid, auserstatus } = response.data;

    console.log("fetchUserDetails 11 : " + email);
    console.log("fetchUserDetails 12 : " + auserid);
    console.log("fetchUserDetails 13 : " + auserstatus);

    // Update the global context with fetched data
    updateUserDetails(email, auserid, auserstatus);

    return { auserid, auserstatus };  // Return the values (optional)
  } catch (error) {
    console.error("Error fetching user details:", error);
    return { auserid: null, auserstatus: "Error" };  // Return default error values
  }
};
