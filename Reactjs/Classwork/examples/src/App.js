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
import ClassPropEx from './ClassProps';
import StateEx from './StateEx';
import Home from './Home';
import ClassCompo from './ClassCompo';
import UseStateMove from './UseStateMove';
import UseEffecthook from './UseEffecthook';
import UseEffecthook1 from './UseEffecthook1';
import UseRef from './UseRef';
import UseContextHook from './UseContextHook';
import UsestateEX from './UsestateEX';
import UserefEx from './UserefEx';
import UseContextEx from './UseContextEx';
import ChatRoom from './ChatRoom';
import TriggerElementOnScroll, { Box } from './TriggerElementOnScroll';
import TestModal from './ModalDialog';
import ShoppingList from './ShoppingList';

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
              <td className="ClsCell">1 Number useState</td>
              <td className="ClsCell">2 String useState</td>
              <td className="ClsCell">3 Component Life Cycle</td>
              <td className="ClsCell">4 Increment Number - Class</td>
              <td className="ClsCell">5 Change String Class</td>
              <td className="ClsCell">6 Change Object Class</td>
              <td className="ClsCell">7 Change Array Class</td>
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
              <td className="ClsCell">8 Display Edit Input</td>
              <td className="ClsCell">9 Edit No. Function</td>
              <td className="ClsCell">10 Edit text Function</td>
              <td className="ClsCell">11 Edit Object Function</td>
              <td className="ClsCell">12 Edit No. Function</td>
              <td className="ClsCell">13 Edit text Function</td>
              <td className="ClsCell">14 Edit Input Function</td>
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
              <td className="ClsCell">15 Edit Checkbox Functionnpm</td>
              <td className="ClsCell">16 Edit Simple Object</td>
              <td className="ClsCell">17 Edit Nested Object</td>
              <td className="ClsCell">18 Edit No - UseState</td>
              <td className="ClsCell">19 Edit Nested Object 1</td>
              <td className="ClsCell">20 UseState Input Object</td>
              <td className="ClsCell">21 Use Reference</td>
            </tr>
            <tr>
              <td className="ClsCell"><ListView/></td>
              <td className="ClsCell"><SetPlusMinus/></td>
              <td className="ClsCell"><Search/></td>              
              <td className="ClsCell"><ClassPropEx/></td>
              <td className="ClsCell"><StateEx/></td>
              <td className="ClsCell"><Home/></td>
              <td className="ClsCell"><UseStateMove/></td>
            </tr>
            <tr>
              <td className="ClsCell">22 List View</td>
              <td className="ClsCell">23 Set Plus Minus</td>
              <td className="ClsCell">24 Add and Search</td>
              <td className="ClsCell">25 Class ClassProps</td>
              <td className="ClsCell">26 This State</td>
              <td className="ClsCell">27 Home Section</td>
              <td className="ClsCell">28 UseState Move</td>
            </tr>
            <tr>
              <td className="ClsCell"><UseEffecthook/></td>
              <td className="ClsCell"><UseEffecthook1/></td>
              <td className="ClsCell"><UseRef/></td>
              <td className="ClsCell"><UserefEx/></td>              
              <td className="ClsCell"><UseContextHook/></td>   
              <td className="ClsCell"><UseContextEx/></td>   
              <td className="ClsCell"><UsestateEX/></td>               
            </tr>
            <tr>
              <td className="ClsCell">29 Use Effect</td>
              <td className="ClsCell">30 Use Effect 1</td>
              <td className="ClsCell">31 Use Reference</td>
              <td className="ClsCell">32 Use Reference Ex</td>
              <td className="ClsCell">33 Use Context</td>
              <td className="ClsCell">34 Use Context Ex</td>
              <td className="ClsCell">35 Use State</td>
            </tr>
            <tr>
              <td className="ClsCell"><ChatRoom/></td>
              <td className="ClsCell"><TestModal/></td>          
              <td className="ClsCell"><ShoppingList/></td>
            </tr>
            <tr>
              <td className="ClsCell">36 Chat Room</td>
              <td className="ClsCell">37 Modal Dialog Box</td>
              <td className="ClsCell">38 Shopping List</td>
            </tr>
            <tr>
              {/* <td className="ClsCell"><PropEx/></td> */}
              {/* <td className="ClsCell"><Child/></td> */}
              {/* Above two components are problematic. So do not activate them. */}
            </tr>
            <tr>
              {/* <td className="ClsCell">25 Prop Types</td> */}
              {/* <td className="ClsCell">26 Parent Child</td> */}
              {/* Above two components are problematic. So do not activate them. */}
            </tr>
          </tbody>
        </table>        
        {/* <td className="ClsCell"><ClassCompo/></td> 
        <td className="ClsCell"><TriggerElementOnScroll/></td>  */}
        <ClassCompo/>
        <TriggerElementOnScroll/>
        <Box/>
        <TriggerElementOnScroll/>
    </div>
  )
}

export default App;
