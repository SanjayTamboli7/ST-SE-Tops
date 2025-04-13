import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';
import LeaveAppList from './LeaveAppList';

export default function ManageLeave() {
    return (
        <>
          <LeaveAppList />
          <ToastContainer />
        </>
      );
  }
