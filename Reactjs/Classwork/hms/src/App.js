// import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './assets/components/Header'
import Sidebar from './assets/components/Sidebar';
import DashboardPage from './assets/pages/DashboardPage';
import PatientPage from './assets/pages/PatientPage';
import AppointmentPage from './assets/pages/AppointmentPage';
import SignUpPage from './assets/pages/SignUpPage' ;

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <header className="App-header">
          <div>
            <Header />
            <div style={{ display: 'flex' }}>
              <Sidebar />
              <main style={{ marginLeft: '200px', padding: '20px' }}>
                <Routes>
                  <Route path='/' element={<DashboardPage />}></Route>
                  <Route path='/patients' element={<PatientPage />}></Route>
                  <Route path='/appointments' element={<AppointmentPage />}></Route>
                  <Route path='/adminsignup' element={<SignUpPage />}></Route>
                  {/* Check header.js */}
                </Routes>
              </main>
            </div>
          </div>
        </header>
      </BrowserRouter>
    </div>
  );
}

export default App;
