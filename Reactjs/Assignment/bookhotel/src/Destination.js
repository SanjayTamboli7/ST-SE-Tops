import React from 'react'
import { Link } from 'react-router-dom'

// './images/684765.jpg' -> New Delhi
// './images/140018331.jpg' Mumbai
// './images/684534.jpg' Banglore
// './images/684730.jpg' Chennai
// './images/684653.jpg' Hyderabad
// import img1dest from './images/684765.jpg'
import img1dest from './images/NewDelhi.png'
// import img2dest from './images/140018331.jpg'
import img2dest from './images/Mumbai.png'
// import img3dest from './images/684534.jpg'
import img3dest from './images/bangalore.png'
// import img4dest from './images/684730.jpg'
import img4dest from './images/chennai.png'
// import img5dest from './images/684653.jpg'
import img5dest from './images/Hyderabad.png'

function Destination() {
  return (
    <div className='hotels-main'>
      <div className="hotels-sec-1">
        <div><Link to={'ShowHotels'}> <img src={img1dest} alt="" /></Link></div>
        <div><Link to={'ShowHotels'}> <img src={img2dest} alt="" /></Link></div>
      </div>
      <div className="hotels-sec-2">
        <div><Link to={'ShowHotels'}> <img src={img3dest} alt="" /></Link></div>
        <div><Link to={'ShowHotels'}> <img src={img4dest} alt="" /></Link></div>
        <div className='hotel-sec-img3'><Link to={'ShowHotels'}> <img src={img5dest} alt="" /></Link></div>
      </div>
    </div>
  )
}

export default Destination
