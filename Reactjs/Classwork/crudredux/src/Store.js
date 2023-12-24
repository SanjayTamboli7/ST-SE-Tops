
import { configureStore } from '@reduxjs/toolkit';
import userSlice from "./UserReducer";

 export const store123 = configureStore({
    reducer:{
       users:userSlice
    }
  })