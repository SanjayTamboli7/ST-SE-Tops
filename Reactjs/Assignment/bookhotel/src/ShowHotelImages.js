import React, { useContext } from 'react';
// import imgs from './car-04.jpg';
// import '../Hotels/Hotelroom.css'
import { FaMapMarkerAlt } from "react-icons/fa";
import './Showhotel.css'
import { Hoteldata } from './App';

function ShowHotelImages() {

  const {hoteldatas} = useContext(Hoteldata)

  return (
    <div>
      <main className='hotelroom-main'>
               <h4>The Leela Ambience Convention Hotel Delhi</h4>
               <p> <FaMapMarkerAlt/> 1 CBD, Maharaja Surajmal Road,near Yamuna Sports Complex, 110032 New Delhi,india</p>
               <h6>Good Location-show map</h6>
        <div className='hotelroom-parts'>
        <div className='hotelroom-part1'>
            <div className='hotelroom-img'> <img src={hoteldatas.imgsrc} alt="" /></div>
            <div className='hotelroom-img hotelroom-img2'> <img src={hoteldatas.imgsrc1} alt="" /></div>
        </div>
        <div className='hotelroom-part2'>
                <img src={hoteldatas.imgsrc2} alt=""/>
        </div>
        </div>

        <div className='hotelroom-imgs'>
            <div> <img src={hoteldatas.imgsrc3}alt="" /></div>
            <div> <img src={hoteldatas.imgsrc4} alt="" /></div>
            <div> <img src={hoteldatas.imgsrc5}alt="" /></div>
            <div> <img src={hoteldatas.imgsrc6} alt="" /></div>
            <div className='hotelroom-imgs5'> <img src={hoteldatas.imgsrc}alt="" /></div>
        </div>
      </main>
    </div>
  );
}

export default ShowHotelImages;
