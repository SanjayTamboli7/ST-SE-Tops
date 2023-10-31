// import logo from './logo.svg';
import './App.css';
import UpdateNum from './UpdateNum';
import UpdateStr from './UpdateStr';
import UpdateFormText from './UpdateFormText';
import UpdateFormChkbox from './UpdateFormChkbox';
import UpdateObj from './UpdateObj';
import UpdateNetsedObj from './UpdateNetsedObj';

function App() {

  return (
    <div className="App">
     <UpdateNum/>
     <UpdateStr/>
     <UpdateFormText/>
     <UpdateFormChkbox/>
     <UpdateObj/>
     <UpdateNetsedObj/>
    </div>
  );
}

export default App;
