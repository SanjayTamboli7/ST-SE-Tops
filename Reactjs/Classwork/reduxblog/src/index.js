import React from 'react';
import ReactDOM from 'react-dom/client'; // ✅ THIS LINE IS KEY
import './index.css';
import App from './App';
import { store } from './app/store';
import { Provider } from 'react-redux';
import { fetchPosts } from './features/posts/postsSlice';
import { fetchUsers } from './features/users/usersSlice';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import reportWebVitals from './reportWebVitals';

store.dispatch(fetchPosts());
store.dispatch(fetchUsers());

const container = document.getElementById('root');
const root = ReactDOM.createRoot(container); // ✅ Modern API

root.render(
  <React.StrictMode>
    <Provider store={store}>
      <Router>
        <Routes>
          <Route path="/*" element={<App />} />
        </Routes>
      </Router>
    </Provider>
  </React.StrictMode>
);

reportWebVitals();
