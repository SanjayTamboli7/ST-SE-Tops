import React, { useEffect, useState } from 'react';
// import axios from 'axios';

const AppointmentList = () => {
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/appointments', { method: "GET" })
      .then(response => setAppointments(response.data))
      .catch(error => console.error('There was an error fetching the appointment data!', error));
  }, []);

//   useEffect(() => {
//     fetch("http://localhost:8080/products", { method: "GET" })
//         .then((res) => { return res.json() })
//         .then((data) => { setProdData(data) })
//         .catch((e) => { console.log(e.message) })
// }, [])

  return (
    <div>
      <h2 className='classh2'>Appointments</h2>
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
