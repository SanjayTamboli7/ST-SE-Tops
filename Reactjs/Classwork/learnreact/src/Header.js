import { Link } from "react-router-dom";

const Header = () => {
  return (
    <nav>
      <ul className="nav-items">
        <li>
          <Link to="/">HOME</Link>
        </li>
        <li>
          <Link to="page1">PAGE1</Link>
        </li>
        <li>
          <Link to="page2">PAGE2</Link>
        </li>
        <li>
          <Link to="page3">PAGE3</Link>
        </li>
        <li>
          <Link to="page4">PAGE4</Link>
        </li>
        {/* <li>
          <link to="ecommhomepage">Shop</link>
        </li> */}
      </ul>
    </nav>
  );
};

export default Header;
