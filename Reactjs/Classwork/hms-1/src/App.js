// import logo from './logo.svg';
import './App.css';

import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './assets/components/Header'
import Sidebar from './assets/components/Sidebar';
import DashboardPage from './assets/pages/DashboardPage';
import PatientPage from './assets/pages/PatientPage';
import AppointmentPage from './assets/pages/AppointmentPage';

const App = () => {
  return (
    <BrowserRouter>
      <div>
        <Header />
        <div style={{ display: 'flex' }}>
          <Sidebar />
          <main style={{ marginLeft: '200px', padding: '20px' }}>
            <Routes>
              <Route path="/" element={<DashboardPage />} />
              <Route path="/patients" element={<ProductCreate />} />
              <Route path="/appointments" element={<ProductView />} />
            </Routes>
          </main>
        </div>
      </div>
    </BrowserRouter>
  );
};

export default App;

// npm install axios react-router-dom
// set NODE_OPTIONS=--openssl-legacy-provider
