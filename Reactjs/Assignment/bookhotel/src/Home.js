import React from 'react'
// import { Link } from 'react-router-dom'
import Header from './Header'
import Destination from './Destination'
import ShowHotels from './ShowHotels'
import Logoutpage from './Logoutpage'

function Home() {
  return (
    <div>

      <Header />
      <Logoutpage/>
      {/* <section>Slider</section>
        <section>Content</section>
        <footer>Footer</footer> */}

        <Destination/>
 {/* <ShowHotels/> */}
    </div>
  )
}

export default Home
