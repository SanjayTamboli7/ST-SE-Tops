// import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import UserCreate from './UserCreate';
import UserEdit from './UserEdit';
import UserList from './UserList';
import UserView from './UserView';
import UserLogin from './UserLogin';

function App() {
  return (
    <div className="App">
      <BrowserRouter>      
        <Routes>
          <Route path='/' element={<UserList/>}></Route>
          <Route path='/user/add' element={<UserCreate/>}></Route>
          <Route path='/user/login' element={<UserLogin/>}></Route>
          <Route path='/user/view/:userId' element={<UserView/>}></Route>
          <Route path='/user/edit/:userId' element={<UserEdit/>}></Route>
        </Routes>
      </BrowserRouter>      
    </div>
  );
}

export default App;

// npm install react-router-dom@6  bootstrap
// npm i -g json-server
// Json-server --watch user.json --port 8000
// Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
