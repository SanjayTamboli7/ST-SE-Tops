import React from 'react'

function ShowHotels() {
  return (
    <div className="ClsShowHotels">
        <div className="ClsColShowHotels">Hotel Image</div>
            <div className="ClsColShowHotels">
                <div className="ClsColDtlShowHotels">Name, rating, title</div>
                <div className="ClsColDtlShowHotels">Review, stay, cost, taxfee</div>
            </div>
        {/* <div className="ClsColShowHotels ClsColDtlShowHotels">Name, rating, title</div>
        <div className="ClsColShowHotels ClsColDtlShowHotels">Review, stay, cost, taxfee</div> */}
    </div>
  )
}

export default ShowHotels
