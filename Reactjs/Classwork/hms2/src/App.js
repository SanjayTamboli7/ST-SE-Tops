import React from 'react';
// import Login from "./assets/components/Login";
import { ToastContainer } from 'react-toastify';
import Home from "./assets/components/Home"; // This will include Header, Menu, ContentArea, and Footer
import { Routes, Route } from 'react-router-dom';
import Dashboard from './assets/components/Dashboard';
import ManageAdminUsers from './assets/components/ManageAdminUsers';
import Roles from './assets/components/Roles';
import MorningShift from './assets/components/MorningShift';
import EveningShift from './assets/components/EveningShift';
import NightShift from './assets/components/NightShift';
import Master3 from './assets/components/Master3';
import ErrorBoundary from './assets/components/ErrorBoundary';
import DepartmentManagement from './assets/components/DepartmentManagement';
import DesignationPage from './assets/components/DesignationPage';
import ManageOtherUsers from './assets/components/ManageOtherUsers';
import ManageHolidays from './assets/components/ManageHolidays';
import ManageLeave from './assets/components/ManageLeave';
import OULogin from './assets/components/OULogin';
import OUForgotPassword from './assets/components/OUForgotPassword';
import ScheduleList from './assets/components/ScheduleList';
import CategoryCrud from './assets/inventory/CategoryCrud';
import UOMCrud from './assets/inventory/UOMCrud';
import ItemList from './assets/inventory/ItemList';
import SupplierCrud from './assets/inventory/SupplierCrud';
import SupplierItemCrud from './assets/inventory/SupplierItemCrud';
import PurchaseRequestCrud from './assets/inventory/PurchaseRequestCrud';
import PurchaseOrderPage from './assets/inventory/PurchaseOrderPage';
import GrnList from './assets/inventory/GrnList';
import GrnPrintView from './assets/inventory/GrnPrintView';
import ItemIssueCrud from './assets/inventory/ItemIssueCrud';
import StockAdjustment from './assets/inventory/StockAdjustment';

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
          {/* <Route path="/" element={<Login />} /> */}
          <Route path="/" element={<OULogin />} />
          <Route path="/forgot-password" element={<OUForgotPassword />} />
          <Route path="/home" element={<Home />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/admin-users" element={<ManageAdminUsers />} />
          <Route path="/other-users" element={<ManageOtherUsers />} />
          <Route path="/admin-departments" element={<DepartmentManagement />} />
          <Route path="/admin-designations" element={<DesignationPage />} />
          <Route path="/admin-holidays" element={<ManageHolidays />} />
          <Route path="/item-category" element={<CategoryCrud />} />
          <Route path="/item-unit" element={<UOMCrud />} />
          <Route path="/item" element={<ItemList />} />
          <Route path="/supplier" element={<SupplierCrud />} />
          <Route path="/supplier-item" element={<SupplierItemCrud />} />
          <Route path="/roles" element={<Roles />} />
          <Route path="/master3" element={<Master3 />} />
          <Route path="/leave" element={<ManageLeave />} />
          <Route path="/schedule" element={<ScheduleList />} />
          <Route path="/purchase-request" element={<PurchaseRequestCrud />} />
          <Route path="/purchase-order" element={<PurchaseOrderPage />} />
          <Route path="/grn/print/:grnid" element={<GrnPrintView />} />
          <Route path="/goodsreceivednote" element={<GrnList />} />
          <Route path="/itemissuetransaction" element={<ItemIssueCrud />} />
          <Route path="/stockadjustment" element={<StockAdjustment />} />
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
        <ToastContainer />
        </ErrorBoundary>
  );
}

export default App;

// npm install xlsx file-saver jspdf jspdf-autotable
// npm install reactstrap bootstrap
// npm install react-datepicker
// npm install axios react-bootstrap moment