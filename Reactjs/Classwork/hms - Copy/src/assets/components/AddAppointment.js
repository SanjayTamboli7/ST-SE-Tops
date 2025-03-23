import React, { useState } from 'react';
import axios from 'axios';

const AddAppointment = () => {
  const [patientName, setPatientName] = useState('');
  const [date, setDate] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const newAppointment = { patientName, date };

    axios.post('http://localhost:8080/api/appointments', newAppointment)
      .then(response => {
        console.log('Appointment added successfully');
      })
      .catch(error => console.error('Error adding appointment', error));
  };

  return (
    <div>
      <h2 className='classh2'>Add Appointment</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" value={patientName} onChange={(e) => setPatientName(e.target.value)} placeholder="Patient Name" />
        <input type="date" value={date} onChange={(e) => setDate(e.target.value)} />
        <button type="submit">Add Appointment</button>
      </form>
    </div>
  );
};

export default AddAppointment;
