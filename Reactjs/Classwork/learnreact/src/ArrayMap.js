
import { useState } from 'react';

let initialShapes = [
  { id: 0, type: 'circle', x: 250, y: 150 },
  { id: 1, type: 'square', x: 300, y: 150 },
  { id: 2, type: 'circle', x: 350, y: 150 },
];

export default function ArrayMap() {
  const [shapes, setShapes] = useState(initialShapes);

  function handleClick() {
    const nextShapes = shapes.map(shape => {
      if (shape.type === 'square') {
        // No change
        return shape;
      } else {
        // Return a new circle 50px below
        return {
          ...shape,
          y: shape.y + 10,
        };
      }
    });
    // Re-render with the new array
    setShapes(nextShapes);        
  }

  return (
    <>
      <button onClick={handleClick}>
        Move circles down!
      </button>
      {shapes.map(shape => (
        <div
          key={shape.id}
          style={{
          background: 'purple',
          position: 'absolute',
          left: shape.x,
          top: shape.y,
          borderRadius:
            shape.type === 'circle'
              ? '50%' : '',
          width: 20,
          height: 20,
        }} />
      ))}
    </>
  );
}
