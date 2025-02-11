import { useState, useEffect } from 'react';

const serverUrl = 'https://localhost:1234';

function createConnection1(serverUrl, roomId) {
    // A real implementation would actually connect to the server
    return {
      connect() {
        console.log('✅ Connecting to "' + roomId + '" room at ' + serverUrl + '...');
      },
      disconnect() {
        console.log('❌ Disconnected from "' + roomId + '" room at ' + serverUrl);
      }
    };
  }
  
function ChatRoom12({ roomId }) {
  useEffect(() => {
    const connection = createConnection1(serverUrl, roomId);
    connection.connect();
    return () => connection.disconnect();
  }, [roomId]);

  return <h1>Welcome to the {roomId} room server {serverUrl}!</h1>;
}

export default function ChatRoom1() {
  const [roomId, setRoomId] = useState('general');
  return (
    <>
      <label>
        Choose the chat room:{' '}
        <select
          value={roomId}
          onChange={e => setRoomId(e.target.value)}
        >
          <option value="general">general</option>
          <option value="travel">travel</option>
          <option value="music">music</option>
        </select>
      </label>
      <hr />
      <ChatRoom12 roomId={roomId} />
    </>
  );
}
