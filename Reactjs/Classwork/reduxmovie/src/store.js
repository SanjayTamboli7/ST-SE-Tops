// src/app/store.js
import { configureStore } from '@reduxjs/toolkit';
import usersReducer from './userSlice'; // adjust the path if needed

export const store = configureStore({
  reducer: {
    users: usersReducer,
  },
});
