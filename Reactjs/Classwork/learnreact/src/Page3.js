import Messenger from "./Messenger";
import ResetStateWithKey from "./ResetStateWithKey";
import TaskApp from "./TaskApp";

const Page3 = () => {
    return (
        <div>
            <table className="ClsTable">
                <tbody>
                    <tr>
                        <td ClassName="ClsCell"><ResetStateWithKey /></td>
                        <td ClassName="ClsCell"><Messenger /></td>
                        <td ClassName="ClsCell"><TaskApp /></td>
                    </tr>
                    <tr>
                        <td className="ClsCell">42 Reset States With Key</td>
                        <td className="ClsCell">43 Reset Form With Key</td>
                        <td className="ClsCell">44 Reducer Hook</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default Page3;

// https://react.dev/learn/passing-data-deeply-with-context
// Context: an alternative to passing props
