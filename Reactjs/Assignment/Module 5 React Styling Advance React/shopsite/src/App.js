// import logo from './logo.svg';

import React from 'react';
import Header from './components/Header';
import './App.css';
import Banner from './components/Banner/Index';
import Features from './components/Features';
import Products from './components/Products';
import Categories from './components/Categories';
import Reviews from './components/Reviews';
import Blogs from './components/Blogs';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      All components here
      <Header/>
      <Banner/>
      <Features/>
      <Products/>
      <Categories/>
      <Reviews/>
      {/* <Blogs/> */}
      <Footer/>

      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
    </div>
  );
}

export default App;

// npm install babel-plugin-macros
// npm install @fortawesome/fontawesome-free
// npm i --save @fortawesome/free-solid-svg-icons
// npm install swiper
// npm install eslint eslint-plugin-react eslint-plugin-react-hooks --save-dev

