import React, { useState } from 'react';
import axios from 'axios';

const AddPatient = () => {
  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const [gender, setGender] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    const newPatient = { name, age, gender };

    axios.post('http://localhost:8080/api/patients', newPatient)
      .then(response => {
        console.log('Patient added successfully');
      })
      .catch(error => console.error('Error adding patient', error));
  };

  return (
    <div>
      <h2 className='classh2'>Add Patient</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Patient Name" />
        <input type="number" value={age} onChange={(e) => setAge(e.target.value)} placeholder="Age" />
        <select value={gender} onChange={(e) => setGender(e.target.value)}>
          <option value="">Select Gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>
        <button type="submit">Add Patient</button>
      </form>
    </div>
  );
};

export default AddPatient;
