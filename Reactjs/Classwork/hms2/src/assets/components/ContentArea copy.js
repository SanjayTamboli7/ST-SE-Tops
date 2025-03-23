import { Routes, Route, Navigate } from "react-router-dom";
import Login from "./Login";
import Home from "./Home";
import ManageAdminUsers from "./ManageAdminUsers";

// import Form1 from "./Form1"; // Example Form
// import Form2 from "./Form2"; // Example Form

const ContentArea = ({ isAuthenticated, setIsAuthenticated }) => {
  return (
    <div>
      <Routes>
        {/* Show Login Page Initially */}
        <Route path="/" element={isAuthenticated ? <Navigate to="/home" /> : <Login setIsAuthenticated={setIsAuthenticated} />} />

        {/* Show Home Page After Login */}
        <Route path="/home" element={isAuthenticated ? <Home /> : <Navigate to="/" />} />

        {/* Dynamic Forms */}
        <Route path="/manageadminusers" element={isAuthenticated ? <ManageAdminUsers /> : <Navigate to="/" />} />
        {/* <Route path="/form1" element={isAuthenticated ? <Form1 /> : <Navigate to="/" />} />
        <Route path="/form2" element={isAuthenticated ? <Form2 /> : <Navigate to="/" />} /> */}

        {/* Default to Login */}
        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </div>
  );
};

export default ContentArea;
