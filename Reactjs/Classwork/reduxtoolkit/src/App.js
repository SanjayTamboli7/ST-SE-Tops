import './App.css';
import Counter1 from './app/Counter1';
import Counter from './features/counter/Counter';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Counter />
        <Counter1 />
      </header>
    </div>
  );
}

export default App;

// npm install @reduxjs/toolkit react-redux