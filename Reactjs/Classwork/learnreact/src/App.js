// import logo from './logo.svg';
import './App.css';
import Game              from './Game';
import List from './List';
import MyButton          from './MyButton';
import MyUseState        from './MyUseState';
import PackingList       from './PackingList';
import PassProps2Comp    from './PassProps2Comp';
import PropUseState      from './PropUseState';
import Scientists        from './Scientists';
import ShoppingList      from './ShoppingList';
import StringConcatenate from './StringConcatenate';
import ToDoList1         from './ToDoList1';

function App() {

  return (
    <div>
        <table className="ClsTable">
          <tbody>
              <tr>                
                <td className="ClsCell"><MyButton/></td>
                <td className="ClsCell"><StringConcatenate/></td>
                <td className="ClsCell"><ShoppingList/></td>
                <td className="ClsCell"><MyUseState/></td>
                <td className="ClsCell"><PropUseState/></td>
                <td className="ClsCell"><Game/></td>
                <td className="ClsCell"><Scientists/></td>
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
                <td className="ClsCell"><ToDoList1/></td>
                <td className="ClsCell"><PassProps2Comp/></td>
                <td className="ClsCell"><PackingList/></td>
                <td className="ClsCell"><List/></td>
              </tr>
              <tr>
                <td className="ClsCell">8 HTML JS JSX in curly braces</td>
                <td className="ClsCell">9 Pass Props To Component</td>
                <td className="ClsCell">10 Conditional Rendering</td>
                <td className="ClsCell">11 List Using Map Func</td>
              </tr>
          </tbody>
      </table>
    </div>
  );
}

export default App;

// start with https://react.dev/learn/tutorial-tic-tac-toe 
          //  https://react.dev/learn/describing-the-ui (start with Keeping components pure)
