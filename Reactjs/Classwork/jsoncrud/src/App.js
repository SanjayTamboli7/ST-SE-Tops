// import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import EmpList from './EmpList';
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import EmpCreate from './EmpCreate';
import EmpView from './EmpView';
import EmpEdit from './EmpEdit';

function App() {
  return (
    <div className="App">
     
     <BrowserRouter>
     <Routes>
      <Route path='/' element={<EmpList/>}></Route>
      <Route path='/emp/add' element={<EmpCreate/>}></Route>
      <Route path='/emp/view/:empId' element={<EmpView/>}></Route>
      <Route path='/emp/edit/:empId' element={<EmpEdit/>}></Route>
     </Routes>
     </BrowserRouter>
    </div>
  );
}

export default App;

// json-server --watch __filename.json --port 8000
