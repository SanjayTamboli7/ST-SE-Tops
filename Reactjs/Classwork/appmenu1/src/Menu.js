import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./styles.css";

const menuData = [
  {
    title: "Menu 1",
    submenu: [
      {
        title: "Submenu 1.1",
        submenu: [
          {
            title: "Submenu 1.1.1",
            submenu: [
              {
                title: "Submenu 1.1.1.1",
                submenu: [
                  { title: "Page A", path: "/page-a" },
                  { title: "Page B", path: "/page-b" }
                ],
              },
            ],
          },
        ],
      },
    ],
  },
  {
    title: "Menu 2",
    submenu: [
      {
        title: "Submenu 2.1",
        submenu: [
          {
            title: "Submenu 2.1.1",
            submenu: [
              {
                title: "Submenu 2.1.1.1",
                submenu: [
                  { title: "Page C", path: "/page-c" },
                  { title: "Page D", path: "/page-d" },
                  { title: "Page E", path: "/page-e" }
                ],
              },
            ],
          },
        ],
      },
    ],
  },
];

const RecursiveMenu = ({ items }) => {
  const [openIndex, setOpenIndex] = useState(null);

  const handleClick = (index) => {
    setOpenIndex(openIndex === index ? null : index);
  };

  return (
    <ul className="menu">
      {items.map((item, index) => (
        <li key={index}>
          {item.path ? (
            <Link to={item.path} className="menu-item">{item.title}</Link>
          ) : (
            <button onClick={() => handleClick(index)} className="menu-button">
              {item.title} ▼
            </button>
          )}
          {item.submenu && openIndex === index && (
            <div className="submenu">
              <RecursiveMenu items={item.submenu} />
            </div>
          )}
        </li>
      ))}
    </ul>
  );
};

function Menu() {
  return <RecursiveMenu items={menuData} />;
}

export default Menu;

