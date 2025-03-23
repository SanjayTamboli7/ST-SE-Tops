import './App.css';
import HorizontalMenu from './HorizontalMenu';
import Menu from './Menu';

function App() {
  return (
    <div className="App">
      <header>
        <HorizontalMenu />
      </header>
      <div><Menu />Learn React</div>
      <header className="App-header">
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >

        </a>
      </header>
    </div>
  );
}

export default App;
