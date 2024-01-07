import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import ProductList from './ProductList';
import ProductCreate from './ProductCreate';
import ProductView from './ProductView';
import ProductEdit from './ProductEdit';

function App() {
  return (
    <div className="App">
      <BrowserRouter>      
        <Routes>
          <Route path='/' element={<ProductList/>}></Route>
          <Route path='/product/add' element={<ProductCreate/>}></Route>
          <Route path='/product/view/:productId' element={<ProductView/>}></Route>
          <Route path='/product/edit/:productId' element={<ProductEdit/>}></Route>
        </Routes>
      </BrowserRouter>      
    </div>
  );
}

export default App;

// npm install react-router-dom@6  bootstrap
// npm i -g json-server
// Json-server --watch product.json --port 8000
// Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
