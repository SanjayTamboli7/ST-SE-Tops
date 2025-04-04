import React, { useEffect } from 'react';
import { Outlet, useLocation } from 'react-router-dom';
import ErrorBoundary from './ErrorBoundary';
import Header from './Header';
import Menu from './Menu';
import Footer from './Footer';
import { menuItems } from './menuData';

const Home = () => {

  const location = useLocation();

  useEffect(() => {
    // Log when Home renders and the current path
    console.log("Home component rendered, current path:", location.pathname);
    console.log("Available menu items:", menuItems);
  }, [location]);

  return (
    <div className="home-container">
      <Header />
      <ErrorBoundary>
        <Menu menuItems={menuItems} />
      </ErrorBoundary>
      <main className="content-area">
        <ErrorBoundary>
          <Outlet />
        </ErrorBoundary>
      </main>
      <Footer />
    </div>
  );
};

export default Home;
