// import logo from './logo.svg';
// import './App.css';

import UseStateNo from './UseStateNo';
import UsestateEx2 from './UsestateEx2';
import Componentlifecycle from './Componentlifecycle';
import ClsIncrementNo from './ClsIncrementNo';
import ClsChangeString from './ClsChangeString';
import ClsChangeArray from './ClsChangeArray';
import ClsChangeObject from './ClsChangeObject';
import DisplayInput from './DisplayInput';
import FunctionChangeNo from './FunctionChangeNo';
import FunctionChangeString from './FunctionChangeString';
import FunctionChangeObject from './FunctionChangeObject';
import UpdateNum from './UpdateNum';
import UpdateStr from './UpdateStr';
import UpdateFormText from './UpdateFormText';
import UpdateFormChkbox from './UpdateFormChkbox';
import UpdateObj from './UpdateObj';
import UpdateNestedObj from './UpdateNestedObj';
import UsestateEx1 from './UsestateEx1';
import UpdateNestedObj1 from './UpdateNestedObj1';
import UseStateInputObject from './UseStateInputObject';
import UseReference from './UseReference';
import ListView from './ListView';
import SetPlusMinus from './SetPlusMinus';
import Search from './Search';

// import FetchAPIData from './FetchAPIData'

function App() {
  return (
    <div>
      {/* <FetchAPIData/> */}
        <table className="ClsTable">
          <tbody>
            <tr>
              <td className="ClsCell"><UseStateNo/></td>
              <td className="ClsCell"><UsestateEx2/></td>
              <td className="ClsCell"><Componentlifecycle/></td>
              <td className="ClsCell"><ClsIncrementNo/></td>
              <td className="ClsCell"><ClsChangeString/></td>
              <td className="ClsCell"><ClsChangeObject/></td>
              <td className="ClsCell"><ClsChangeArray/></td>
            </tr>
            <tr>
              <td className="ClsCell">Number with useState</td>
              <td className="ClsCell">String with useState</td>
              <td className="ClsCell">Component Life Cycle</td>
              <td className="ClsCell">Increment Number - Class</td>
              <td className="ClsCell">Change String - Class</td>
              <td className="ClsCell">Change Object - Class</td>
              <td className="ClsCell">Change Array - Class</td>
            </tr>
          </tbody>
          <tbody>
            <tr>
              <td className="ClsCell"><DisplayInput/></td>
              <td className="ClsCell"><FunctionChangeNo/></td>
              <td className="ClsCell"><FunctionChangeString/></td>
              <td className="ClsCell"><FunctionChangeObject/></td>
              <td className="ClsCell"><UpdateNum/></td>
              <td className="ClsCell"><UpdateStr/></td>
              <td className="ClsCell"><UpdateFormText/></td>
            </tr>
            <tr>
              <td className="ClsCell">Display / Change Input</td>
              <td className="ClsCell">Change Number Function</td>
              <td className="ClsCell">Change String Function</td>
              <td className="ClsCell">Change Object Function</td>
              <td className="ClsCell">Update Number Function 1</td>
              <td className="ClsCell">Update String Function 1</td>
              <td className="ClsCell">Update Input Function 1</td>
            </tr>
          </tbody>
          <tbody>
            <tr>
              <td className="ClsCell"><UpdateFormChkbox/></td>
              <td className="ClsCell"><UpdateObj/></td>
              <td className="ClsCell"><UpdateNestedObj/></td>  
              <td className="ClsCell"><UsestateEx1/></td>  
              <td className="ClsCell"><UpdateNestedObj1/></td>  
              <td className="ClsCell"><UseStateInputObject/></td>  
              <td className="ClsCell"><UseReference/></td>  
            </tr>
            <tr>
              <td className="ClsCell"><u>Update Checkbox Function 1</u></td>
              <td className="ClsCell">Update Simple Object</td>
              <td className="ClsCell">Update Nested Object</td>
              <td className="ClsCell">Change Number - UseState</td>
              <td className="ClsCell">Update Nested Object 1</td>
              <td className="ClsCell">Use State Input Object</td>
              <td className="ClsCell">Use Reference</td>
            </tr>
            <tr>
              <td className="ClsCell"><ListView/></td>
              <td className="ClsCell"><SetPlusMinus/></td>
              <td className="ClsCell"><Search/></td>
              
            </tr>
            <tr>
              <td className="ClsCell">List View</td>
              <td className="ClsCell">Set Plus Minus</td>
              <td className="ClsCell">Add and Search</td>
            </tr>
          </tbody>
        </table>        
    </div>
  )
}

export default App;
