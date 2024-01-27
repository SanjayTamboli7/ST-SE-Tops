import React from 'react'

function Destination() {
    return (
        <div>
            <div className="ClsRow1Destination">
                {/* Getting following image is a problem. It should be solved. */}
                <div className="ClsRow1ColDestination"><img src="images/684765.jpg" alt="New Delhi">New Delhi Image</img></div>
                <div className="ClsRow1ColDestination"><img src="images/140018349.jpg" alt="Agra">Agra Image</img></div>
            </div>
            <div className="ClsRow2Destination">
                Destination Images Row 2
                {/* Getting following image is a problem. It should be solved. */}
                <div className="ClsRow2ColDestination"><img src="images/684657.jpg" alt="Jaipur">Jaipur Image</img></div>
                <div className="ClsRow2ColDestination"><img src="images/100235855.jpg" alt="Gurgaon">Gurgaon Image</img></div>
                <div className="ClsRow2ColDestination"><img src="images/140018331.jpg" alt="Mumbai">Mumbai Image</img></div>
            </div>
        </div>
    )
}

export default Destination
