import React from 'react';
import HolidayList from './HolidayList';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer } from 'react-toastify';

export default function ManageHolidays() {
    return (
        <div>
          <HolidayList />
          <ToastContainer />
        </div>
      );
    }
