import Inspiration from './Inspiration';
import ButtonEvent from './ButtonEvent';
import EventHandlerAsProp from './EventHandlerAsProp';
import NameEventHandlerProps from './NameEventHandlerProps';
import MoreInteractions from './MoreInteractions'
import EventPropagation from './EventPropagation';
import StopPropagation from './StopPropagation';
import LightSwitch from './LightSwitch';
import HookUseState from './HookUseState';
import StateAsSnapshot from './StateAsSnapshot';
import MovingDot from './MovingDot';
import CopyObject from './CopyObject';
import CopyNestObject from './CopyNestObject';
import ArraySpread from './ArraySpread';

const Page1 = () => {
  return (
    <div>
      <table className="ClsTable">
        <tbody>
          <tr>
            <td className="ClsCell"><Inspiration /></td>
            <td className="ClsCell"><ButtonEvent /></td>
            <td className="ClsCell"><EventHandlerAsProp /></td>
            <td className="ClsCell"><NameEventHandlerProps /></td>
            <td className="ClsCell"><MoreInteractions /></td>
            <td className="ClsCell"><EventPropagation /></td>
            <td className="ClsCell"><StopPropagation /></td>
          </tr>
          <tr>
            <td className="ClsCell">15 Render Tree</td>
            <td className="ClsCell">16 Button Event</td>
            <td className="ClsCell">17 Event Handler As Prop</td>
            <td className="ClsCell">18 Name Event Handler Props</td>
            <td className="ClsCell">19 More Interactions</td>
            <td className="ClsCell">20 Event Propagation</td>
            <td className="ClsCell">21 Stop Propagation</td>
          </tr>
          <tr>
            <td className="ClsCell"><LightSwitch /></td>
            <td className="ClsCell"><HookUseState /></td>
            <td className="ClsCell"><StateAsSnapshot /></td>
            <td className="ClsCell"><MovingDot /></td>
            <td className="ClsCell"><CopyObject /></td>
            <td className="ClsCell"><CopyNestObject /></td>
            <td className="ClsCell"><ArraySpread /></td>
          </tr>
          <tr>
            <td className="ClsCell">22 Toggle Background</td>
            <td className="ClsCell">23 Hook-UseState</td>
            <td className="ClsCell">24 State As Snapshot</td>
            <td className="ClsCell">25 State Mutation</td>
            <td className="ClsCell">26 Copy Object</td>
            <td className="ClsCell">27 Copy Nested Object</td>
            <td className="ClsCell">28 Array Spread(Copy)</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default Page1;
