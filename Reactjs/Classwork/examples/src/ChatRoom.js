import React, { useEffect, useState } from 'react';
import CreateConnection from './Chat';


function Chat({roomId})
{
   const [serverUrl,setserverUrl] =  useState("http://localhost:1234/");

    useEffect(()=>{
        const connection = CreateConnection(serverUrl,roomId);
        connection.connect();
        return()=>{
            connection.disconnect();
        }
    },[serverUrl,roomId])

    return(
        <><h6>Welcome to {roomId} room</h6></>
    )
}

function ChatRoom() {

   const [roomId,setRoomId] = useState("General");
   const [show,setShow] = useState(false);

  return (
    <div>
        Choose room : 
        <select value={roomId} onChange={(e)=>{setRoomId(e.target.value)}}>
            <option>General</option>
            <option>Travel</option>
            <option>Music</option>
        </select>
        <button onClick={()=>{setShow(!show)}}>
            {(show)? "Close Chat":"Open Chat"}
        </button>
        <Chat roomId={roomId}/>    
    </div>
  )
}

export default ChatRoom
