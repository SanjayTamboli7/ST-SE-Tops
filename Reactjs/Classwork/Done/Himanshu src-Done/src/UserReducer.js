import { createSlice } from "@reduxjs/toolkit";
import { userList } from "./Data";


const userSlice = createSlice({
    name:"user",
    initialState:userList,
    reducers:{
         addusers:(state,action)=>{
            console.log(action)
            console.log(action.payload)
            console.log(state)
            state.push(action.payload)

         },

         updateUsers:(state,action)=>{
            // console.log(action)
            // console.log(action.payload)

            const {id,name,email} = action.payload
            //   console.log(name)
            // console.log(state);

           const useid =  state.find(u=>u.id==id)           

                if(useid)
                {
                    useid.name=name;
                    useid.email =email;
                     console.log(useid.name + " " + useid.email);
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