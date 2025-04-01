import React from 'react';

// Import all your potential components
import Dashboard from './Dashboard';
import Patients from './Patients';
import Appointments from './Appointments';
import Billing from './Billing';
import Reports from './Reports';
import ManageAdminUsers from './ManageAdminUsers';
import DepartmentList from './DepartmentList';
import "./styles.css";

const ContentArea = ({ componentToRender }) => {
  // Component mapping for dynamic rendering
  const componentMap = {
    'Dashboard': Dashboard,
    'Patients': Patients,
    'Appointments': Appointments,
    'Billing': Billing,
    'Reports': Reports,
    'ManageAdminUsers': ManageAdminUsers,
    'DepartmentList': DepartmentList,
    // Add more components as needed
  };

  // Default component to render if the requested one doesn't exist
  const DefaultComponent = () => (
    <div className="default-content">
      <h2>Component Not Found</h2>
      <p>The requested component "{componentToRender}" is not available.</p>
    </div>
  );

  // Dynamically render the component
  const ComponentToRender = componentMap[componentToRender] || DefaultComponent;

  return (
    <main className="content-area">
      <ComponentToRender />
    </main>
  );
};

export default ContentArea;