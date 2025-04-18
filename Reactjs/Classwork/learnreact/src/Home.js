import './App.css';
import Game from './Game';
import List from './List';
import MyButton from './MyButton';
import MyUseState from './MyUseState';
import PackingList from './PackingList';
import PassProps2Comp from './PassProps2Comp';
import PropUseState from './PropUseState';
import Scientists from './Scientists';
import ShoppingList from './ShoppingList';
import ShowCurrentTime from './ShowCurrentTime';
import StringConcatenate from './StringConcatenate';
import TeaSet from './TeaSet';
import ToDoList1 from './ToDoList1';
import TodoList from './TodoList';

const Home = () => {
  return (
    <div>
      <table className="ClsTable">
        <tbody>
          <tr>
            <td className="ClsCell"><MyButton /></td>
            <td className="ClsCell"><StringConcatenate /></td>
            <td className="ClsCell"><ShoppingList /></td>
            <td className="ClsCell"><MyUseState /></td>
            <td className="ClsCell"><PropUseState /></td>
            <td className="ClsCell"><Game /></td>
            <td className="ClsCell"><Scientists /></td>
          </tr>
          <tr>
            <td className="ClsCell">1 HTML-Javascript-JSX</td>
            <td className="ClsCell">2 String Concatenate</td>
            <td className="ClsCell">3 Map Fun</td>
            <td className="ClsCell">4 UseState Fun</td>
            <td className="ClsCell">5 UseState Props+Liftup</td>
            <td className="ClsCell">6 Game-Tic-Toc-Toe</td>
            <td className="ClsCell">7 Simple Components</td>
          </tr>
          <tr>
            <td className="ClsCell"><ToDoList1 /></td>
            <td className="ClsCell"><PassProps2Comp /></td>
            <td className="ClsCell"><PackingList /></td>
            <td className="ClsCell"><List /></td>
            <td className="ClsCell"><TeaSet /></td>
            <td className="ClsCell"><ShowCurrentTime /></td>
            <td className="ClsCell"><TodoList /></td>
          </tr>
          <tr>
            <td className="ClsCell">8 HTML JS JSX in curly braces</td>
            <td className="ClsCell">9 Pass Props To Component</td>
            <td className="ClsCell">10 Conditional Rendering</td>
            <td className="ClsCell">11 List Using Map Func</td>
            <td className="ClsCell">12 Pure Function</td>
            <td className="ClsCell">13 Current Time</td>
            <td className="ClsCell">14 JS in JSX with Curly Braces</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default Home;

// start with https://react.dev/learn/tutorial-tic-tac-toe 
          //  https://react.dev/learn/describing-the-ui (start with Keeping components pure)
          //  https://react.dev/learn/keeping-components-pure
          //  https://codesandbox.io/p/sandbox/suspicious-architecture-kz29wd?file=%2Findex.js%3A6%2C1
