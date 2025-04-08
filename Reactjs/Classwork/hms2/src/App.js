import React from 'react';
import Login from "./assets/components/Login";
import Home from "./assets/components/Home"; // This will include Header, Menu, ContentArea, and Footer
import { Routes, Route } from 'react-router-dom';
import Dashboard from './assets/components/Dashboard';
import ManageAdminUsers from './assets/components/ManageAdminUsers';
// import DepartmentList from './assets/components/DepartmentList'; 
import Roles from './assets/components/Roles';
import MorningShift from './assets/components/MorningShift';
import EveningShift from './assets/components/EveningShift';
import NightShift from './assets/components/NightShift';
import Master3 from './assets/components/Master3';
import ErrorBoundary from './assets/components/ErrorBoundary';
import DepartmentManagement from './assets/components/DepartmentManagement';
import DesignationPage from './assets/components/DesignationPage';

const RouteInfo = ({ componentName }) => (
  <div style={{ padding: '20px', backgroundColor: '#e3f2fd', marginBottom: '20px' }}>
    <h2>Route Debug Info</h2>
    <p>Currently rendering: <strong>{componentName}</strong></p>
    <p>Current URL: <strong>{window.location.pathname}</strong></p>
  </div>
);

// Wrap each component with debugging info and error boundary
const withErrorBoundary = (Component, name) => (
  <ErrorBoundary>
    <RouteInfo componentName={name} />
    <Component />
  </ErrorBoundary>
);

function App() {
  return (
      <ErrorBoundary>      
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/home" element={<Home />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/admin-users" element={<ManageAdminUsers />} />
          <Route path="/admin-departments" element={<DepartmentManagement />} />
          <Route path="/admin-designations" element={<DesignationPage />} />
          <Route path="/roles" element={<Roles />} />
          <Route path="/master3" element={<Master3 />} />
          <Route path="/morning-shift" element={<MorningShift />} />
          <Route path="/evening-shift" element={<EveningShift />} />
          <Route path="/night-shift" element={<NightShift />} />
          
          {/* Catch-all route for debugging */}
          <Route path="*" element={
            <div style={{ padding: '20px', backgroundColor: '#ffebee' }}>
              <h2>Route Not Found</h2>
              <p>The current URL <strong>{window.location.pathname}</strong> doesn't match any route.</p>
            </div>
          } />
        </Routes>
      </ErrorBoundary>
  );
}

export default App;

// npm install xlsx file-saver jspdf jspdf-autotable