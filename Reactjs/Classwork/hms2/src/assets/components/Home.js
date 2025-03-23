import React, { useState } from 'react';
// import Header from './Header';
// import Menu from './Menu';
import ContentArea from './ContentArea';
import Footer from "./Footer" ;
import ContentBoxes from './ContentBoxes';

export default function Home() {

  const [isAuthenticated, setIsAuthenticated] = useState(true);

  return (
    <div className="app-container">
      {/* <Header />
      <Menu /> */}
        <div >
        </div>     
      <ContentBoxes />
      <ContentArea isAuthenticated={isAuthenticated} setIsAuthenticated={setIsAuthenticated} />
      <Footer />
    </div>
  )
}
