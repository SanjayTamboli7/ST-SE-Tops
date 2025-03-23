import React, { useState } from 'react';
import axios from 'axios';
// import 'bootstrap/dist/css/bootstrap.min.css';

const SignUpPage = () => {
  const [userName, setUserName] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userContactNo, setUserContactNo] = useState('');
  const [userPassword, setUserPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [loading, setLoading] = useState(false);

  // Validate inputs before submission
  const validateInputs = () => {
    if (!userName || !userEmail || !userContactNo || !userPassword) {
      setErrorMessage('All fields are required');
      return false;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(userEmail)) {
      setErrorMessage('Please enter a valid email address');
      return false;
    }

    const phoneRegex = /^[0-9]{10}$/; // Assuming 10-digit phone number
    if (!phoneRegex.test(userContactNo)) {
      setErrorMessage('Please enter a valid contact number (10 digits)');
      return false;
    }

    if (userPassword.length < 6) {
      setErrorMessage('Password should be at least 6 characters long');
      return false;
    }

    setErrorMessage('');
    return true;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Validate inputs
    if (!validateInputs()) return;

    const userData = {
      auser_name: userName,
      auser_email_id: userEmail,
      auser_contact_no: userContactNo,
      auser_password: userPassword,
      last_edit_date_time: new Date().toISOString(),
    };

    try {
      setLoading(true);
      // Send data to the backend (replace the URL with your actual API endpoint)
      const response = await axios.post('http://localhost:8080/api/signup', userData);

      if (response.status === 200) {
        alert('User created successfully');
        // Reset form or redirect to login page
        setUserName('');
        setUserEmail('');
        setUserContactNo('');
        setUserPassword('');
      }
    } catch (error) {
      setErrorMessage('Error creating user. Please try again later.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Sign Up</h2>
      <form onSubmit={handleSubmit} className="col-md-6 offset-md-3">
        {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}
        <div className="form-group">
          <label htmlFor="userName">Name</label>
          <input
            type="text"
            id="userName"
            className="form-control"
            value={userName}
            onChange={(e) => setUserName(e.target.value)}
            placeholder="Enter your name"
          />
        </div>

        <div className="form-group">
          <label htmlFor="userEmail">Email Address</label>
          <input
            type="email"
            id="userEmail"
            className="form-control"
            value={userEmail}
            onChange={(e) => setUserEmail(e.target.value)}
            placeholder="Enter your email"
          />
        </div>

        <div className="form-group">
          <label htmlFor="userContactNo">Contact Number</label>
          <input
            type="text"
            id="userContactNo"
            className="form-control"
            value={userContactNo}
            onChange={(e) => setUserContactNo(e.target.value)}
            placeholder="Enter your contact number"
          />
        </div>

        <div className="form-group">
          <label htmlFor="userPassword">Password</label>
          <input
            type="password"
            id="userPassword"
            className="form-control"
            value={userPassword}
            onChange={(e) => setUserPassword(e.target.value)}
            placeholder="Enter your password"
          />
        </div>

        <button
          type="submit"
          className="btn btn-primary btn-block mt-4"
          disabled={loading}
        >
          {loading ? 'Submitting...' : 'Sign Up'}
        </button>
      </form>
    </div>
  );
};

export default SignUpPage;
