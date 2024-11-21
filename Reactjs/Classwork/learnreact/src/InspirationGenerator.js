import * as React from 'react';
import Inspirations from './Inspirations';
import FancyText from './FancyText';
import Color from './Color';

export default function InspirationGenerator({children}) {
  const [index, setIndex] = React.useState(0);
  const Inspiration = Inspirations[index];
  const next = () => setIndex((index + 1) % Inspirations.length);

  return (
    <>
      <p>Your inspirational {Inspiration.type} is:</p>
      {Inspiration.type === 'quote'
      ? <FancyText text={Inspiration.value} />
      : <Color value={Inspiration.value} />}

      <button onClick={next}>Next Quote</button>
      {children}
    </>
  );
}
