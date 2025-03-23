import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AppointmentList = () => {
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/appointments')
      .then(response => setAppointments(response.data))
      .catch(error => console.error('There was an error fetching the appointment data!', error));
  }, []);

  return (
    <div>
      <h2>Appointments</h2>
      <ul>
        {appointments.map((appointment) => (
          <li key={appointment.id}>
            {appointment.patientName} - {appointment.date}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AppointmentList;
