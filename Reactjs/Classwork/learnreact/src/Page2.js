import ArrayFilter from './ArrayFilter'
import ArrayMap from './ArrayMap';
import ArrayMapReplace from './ArrayMapReplace';
import ArrayObjectCopy from './ArrayObjectCopy';
import ArrayReverse from './ArrayReverse';
import ArraySlice from './ArraySlice';
import CompDiffPosition from './CompDiffPosition';
import InputWithState from './InputWithState';
import MyComponent from './MyComponent';
import PreserveState from './PreserveState';
import StateLiftUp from './StateLiftUp';
import StatePosition from './StatePosition';
import StateReset from './StateReset';
import StructureOfState from './StructureOfState';

const Page2 = () => {
    return (
      <div>
      <table className="ClsTable">
        <tbody>
          <tr>
            <td className="ClsCell"><ArrayFilter /></td>
            <td className="ClsCell"><ArrayMap /></td>
            <td className="ClsCell"><ArrayMapReplace /></td>
            <td className="ClsCell"><ArraySlice /></td>
            <td className="ClsCell"><ArrayReverse /></td>
            <td className="ClsCell"><ArrayObjectCopy /></td>
            <td className="ClsCell"><InputWithState /></td>
          </tr>
          <tr>
            <td className="ClsCell">29 Array Filter (Delete)</td>
            <td className="ClsCell">30 Array Map (Transform)</td>
            <td className="ClsCell">31 Array Map (Replace)</td>
            <td className="ClsCell">32 Array Slice (Insert)</td>
            <td className="ClsCell">33 Array Reverse</td>
            <td className="ClsCell">34 Array Object Copy</td>
            <td className="ClsCell">35 Manage Input With State</td>
          </tr>
          <tr>
            <td className="ClsCell"><StructureOfState /></td>
            <td className="ClsCell"><StateLiftUp /></td>
            <td className="ClsCell"><StatePosition /></td>
            <td className="ClsCell"><PreserveState /></td>
            <td className="ClsCell"><StateReset/></td>
            <td className='ClsCell'><MyComponent /></td>
            <td className='ClsCell'><CompDiffPosition /></td>
          </tr>
          <tr>
            <td className="ClsCell">36 State Structure</td>
            <td className="ClsCell">37 State Lift Up</td>
            <td className="ClsCell">38 State Tide To Position</td>
            <td className="ClsCell">39 State Preserve</td>
            <td className="ClsCell">39 State Reset</td>
            <td className="ClsCell">40 Component Nesting</td>
            <td className="ClsCell">41 Two States one Place</td>
          </tr>
        </tbody>
      </table>
      </div>
    );
  };
  
  export default Page2;
  