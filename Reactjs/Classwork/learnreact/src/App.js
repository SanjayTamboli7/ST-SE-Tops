// import logo from './logo.svg';
import './App.css';
import Game              from './Game';
import MyButton          from './MyButton';
import MyUseState        from './MyUseState';
import PropUseState      from './PropUseState';
import ShoppingList      from './ShoppingList';
import StringConcatenate from './StringConcatenate';

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
              </tr>
              <tr>
                <td className="ClsCell">01 HTML-Javascript-JSX</td>
                <td className="ClsCell">02 String Concatenate</td>
                <td className="ClsCell">03 Map Fun</td>
                <td className="ClsCell">04 UseState Fun</td>
                <td className="ClsCell">05 UseState Props+Liftup</td>
                <td className="ClsCell">06 Game-Tic-Toc-Toe</td>
              </tr>
          </tbody>
      </table>
    </div>
  );
}

// start with https://react.dev/learn/tutorial-tic-tac-toe 

export default App;
