import React from 'react'
import { useState, useEffect } from 'react';
import Clock from './Clock.js';

function useTime() {
  const [time, setTime] = useState(() => new Date());
  useEffect(() => {
    const id = setInterval(() => {
      setTime(new Date());
    }, 1000);
    return () => clearInterval(id);
  }, []);
  return time;
}

function ShowCurrentTime() {
    const time = useTime();
    return (
        <div>
            <Clock time={time} />
        </div>
    );
  }

export default ShowCurrentTime
