import { Routes, Route, Navigate } from "react-router-dom";
import Login from "./Login";
import Home from "./Home";
import ManageAdminUsers from "./ManageAdminUsers";

const componentMap = {
  ManageAdminUsers: ManageAdminUsers, // Maps string to component
};

const ContentArea = ({ isAuthenticated, setIsAuthenticated }) => {
  return (
    <div>
      <Routes>
        <Route
          path="/"
          element={isAuthenticated ? <Navigate to="/home" /> : <Login setIsAuthenticated={setIsAuthenticated} />}
        />
        <Route path="/home" element={isAuthenticated ? <Home /> : <Navigate to="/" />} />

        {/* Dynamic Routing Based on Menu JSON */}
        {Object.entries(componentMap).map(([key, Component]) => (
          <Route key={key} path={`/${key.toLowerCase()}`} element={isAuthenticated ? <Component /> : <Navigate to="/" />} />
        ))}

        <Route path="*" element={<Navigate to="/" />} />
      </Routes>
    </div>
  );
};

export default ContentArea;
