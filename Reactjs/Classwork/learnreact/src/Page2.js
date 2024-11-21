import ArrayFilter from './ArrayFilter'
import ArrayMap from './ArrayMap';
import ArrayMapReplace from './ArrayMapReplace';
import ArrayObjectCopy from './ArrayObjectCopy';
import ArrayReverse from './ArrayReverse';
import ArraySlice from './ArraySlice';

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
          </tr>
          <tr>
            <td className="ClsCell">29 Array Filter (Delete)</td>
            <td className="ClsCell">30 Array Map (Transform)</td>
            <td className="ClsCell">31 Array Map (Replace)</td>
            <td className="ClsCell">32 Array Slice (Insert)</td>
            <td className="ClsCell">33 Array Reverse</td>
            <td className="ClsCell">34 Array Object Copy</td>
            {/* https://react.dev/learn/updating-arrays-in-state */}
          </tr>
        </tbody>
      </table>
      </div>
    );
  };
  
  export default Page2;
  