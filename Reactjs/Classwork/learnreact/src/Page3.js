import Messenger from "./Messenger";
import ResetStateWithKey from "./ResetStateWithKey";
import TaskApp from "./TaskApp";
import Component1 from "./Component1"
import TaskApp1 from "./TaskApp1";
import UseReferenceDemo from "./UseReferenceDemo";
import ChatRoom from "./ChatRoom";
import ChatRoom1 from "./ChatRoom1";
// import SynchronizeEffect from "./SynchronizeEffect";

const Page3 = () => {
    return (
        <div>
            <table className="ClsTable">
                <tbody>
                    <tr>
                        <td ClassName="ClsCell"><ResetStateWithKey /></td>
                        <td ClassName="ClsCell"><Messenger /></td>
                        <td ClassName="ClsCell"><TaskApp /></td>
                        <td ClassName="ClsCell"><Component1 /></td>                        
                    </tr>
                    <tr>
                        <td className="ClsCell">42 Reset States With Key</td>
                        <td className="ClsCell">43 Reset Form With Key</td>
                        <td className="ClsCell">44 Reducer Hook</td>
                        <td className="ClsCell">45 Context Hook</td>
                    </tr>
                    <tr>
                        <td ClassName="ClsCell"><TaskApp1 /></td>
                        <td ClassName="ClsCell"><UseReferenceDemo /></td>
                        {/* <td ClassName="ClsCell"><SynchronizeEffect /></td> */}
                        <td className="ClsCell">Activate the code</td>
                        <td className="ClsCell"><ChatRoom /></td>
                    </tr>
                    <tr>
                        <td className="ClsCell">46 Reducer & Context Hook</td>
                        <td className="ClsCell">47 Reference Hook</td>
                        <td className="ClsCell">48 Synchronize Effect</td>
                        <td className="ClsCell">49 Cleanup Effect</td>
                    </tr>
                    <tr>
                        <td className="ClsCell"><ChatRoom1 /></td>
                    </tr>
                    <tr>
                        <td className="ClsCell">50 Reactive Effect Lifecycle</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default Page3;

// https://react.dev/learn/referencing-values-with-refs
// Start from top line
