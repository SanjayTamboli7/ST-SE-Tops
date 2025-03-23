import React, { useState } from 'react';
import './App.css';
import Header from './assets/components/Header';
import ContentArea from './assets/components/ContentArea';
import Footer from './assets/components/Footer';
import Menu from './assets/components/Menu';

function App() {

  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <div className="app-container">
      <Header />
      <Menu />
      <ContentArea isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />
      <Footer />
    </div>
  );
}

export default App;
