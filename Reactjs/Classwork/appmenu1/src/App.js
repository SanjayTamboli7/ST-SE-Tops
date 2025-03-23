import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Menu from "./Menu";
import PageA from "./pages/PageA";
import PageB from "./pages/PageB";
import PageC from "./pages/PageC";
import PageD from "./pages/PageD";
import PageE from "./pages/PageE";
import './App.css';

function App() {
  return (
    <Router>
      <div>
        <h1>Nested Menu</h1>
        <Menu />
        <Routes>
          <Route path="/page-a" element={<PageA />} />
          <Route path="/page-b" element={<PageB />} />
          <Route path="/page-c" element={<PageC />} />
          <Route path="/page-d" element={<PageD />} />
          <Route path="/page-e" element={<PageE />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

