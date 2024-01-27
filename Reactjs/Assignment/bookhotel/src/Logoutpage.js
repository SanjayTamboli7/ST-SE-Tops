import React, { useContext } from 'react'
import { loginuser } from './App'

function Logoutpage() {
  const {login} =  useContext(loginuser)
  return (
    <div>
    {login ? "welcome "  + login : ""}
    </div>
  )
}

export default Logoutpage
