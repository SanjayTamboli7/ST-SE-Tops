import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PatientList = () => {
  const [patients, setPatients] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/patients')
      .then(response => setPatients(response.data))
      .catch(error => console.error('There was an error fetching the patient data!', error));
  }, []);

  return (
    <div>
      <h2>Patients</h2>
      <ul>
        {patients.map(patient => (
          <li key={patient.id}>{patient.name} - {patient.age} years old</li>
        ))}
      </ul>
    </div>
  );
};

export default PatientList;
