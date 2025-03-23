import React, { useState } from "react";

const RecursiveMenu = ({ items }) => {
  const [activeMenu, setActiveMenu] = useState(null);

  const handleHover = (index) => {
    setActiveMenu(index);
  };

  return (
    <ul className="recursive-menu">
      {items.map((item, index) => (
        <li key={index} 
            className="menu-item"
            onMouseEnter={() => handleHover(index)}
            onMouseLeave={() => handleHover(null)}
        >
          {item.path ? <a href={item.path}>{item.title}</a> : item.title}

          {item.submenu && activeMenu === index && (
            <ul className="submenu">
              <RecursiveMenu items={item.submenu} />
            </ul>
          )}
        </li>
      ))}
    </ul>
  );
};

export default RecursiveMenu;
