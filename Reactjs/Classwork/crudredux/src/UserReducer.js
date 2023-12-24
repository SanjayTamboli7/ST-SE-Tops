import { createSlice } from "@reduxjs/toolkit";
import { userList } from "./Data";


const userSlice = createSlice({
    name:"user",
    initialState:userList,
    reducers:{
         addusers:(state,action)=>{
            state.push(action.payload)
         },

         updateUsers:(state,action)=>{
            const {id,name,email} = action.payload
            const useid =  state.find(u=>u.id==id)           

                if(useid)
                {
                    useid.name=name;
                    useid.email =email;
                }
         },

         deleteUsers:(state,action)=>{

          const {id,name,email} = action.payload         
          const useid =  state.find(u=>u.id==id)           
  
              if(useid)
              {
                return state.filter((vla)=>(vla !== useid))
              }
       }
    }
})

export const {addusers,updateUsers,deleteUsers} = userSlice.actions;
export default userSlice.reducer;
