import './App.css';
//import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ProductList from './ProductList';
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import ProductCreate from './ProductCreate';
import ProductView from './ProductView';
import ProductEdit from './ProductEdit';

function App() {
 
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<ProductList />}></Route>
          <Route path='/emp/add' element={<ProductCreate />}></Route>
          <Route path='/prod/view/:Id' element={<ProductView />}></Route>
          <Route path='/prod/edit/:Id' element={<ProductEdit />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

// To run this app
// npm i bootstrap react-router-dom@6
// npm i -g json-server
