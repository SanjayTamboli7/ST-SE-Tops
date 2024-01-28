import React from 'react'

function ShowHotels() {
  return (
    <div className="ClsShowHotels">
      <div className="ClsColShowHotels">Hotel Image</div>
      <div className="ClsColShowHotels">
        <div className="ClsColHotelData">
          <div className="ClsCol1HotelData">
            <div><h4>Name</h4></div>
            <div><h5>Rating</h5></div>
            <div><h6>Title</h6></div>
          </div>
        </div>
        <div className="ClsColHotelData">
          <div className="ClsCol2HotelData">Review</div>
          <div className="ClsCol2HotelData">Stay</div>
          <div className="ClsCol2HotelData">Cost</div>
          <div className="ClsCol2HotelData">Tax fee</div>
        </div>
      </div>
    </div>
  )
}

export default ShowHotels
