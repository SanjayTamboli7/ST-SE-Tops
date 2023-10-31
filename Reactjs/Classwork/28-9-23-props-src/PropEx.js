import React from 'react'
import PropTypes from "prop-types";



function PropEx(props) {
  return (
    <div>
      <h1>React Props..!</h1>
      {props.name + " " + props.age}
      {props.age}
      {props.course}
    </div>
  )
}
PropEx.propTypes = {
    name:PropTypes.array,
    age:PropTypes.number,
    course:PropTypes.string

}

PropEx.defaultProps ={
    name:[1,2,3,true,"Yash"],
    age:12,
    course:"WD"
}

export default PropEx
