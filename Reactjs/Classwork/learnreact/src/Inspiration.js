import FancyText from './FancyText';
import InspirationGenerator from './InspirationGenerator';
import Copyright from './Copyright';

export default function App() {
  return (
    <>
      <FancyText title text="Quote App" />
      <InspirationGenerator>
        <Copyright year={2024} />
      </InspirationGenerator>
    </>
  );
}
