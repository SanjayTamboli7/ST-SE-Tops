import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./styles.css"; // Ensure styles are properly applied

const menuItems = [
  {
    title: "Dashboard",
    submenu: [
      {
        title: "Submenu 1",
        submenu: [
          {
            title: "Submenu 1.1",
            submenu: [{ title: "Submenu 1.1.1" }, { title: "Submenu 1.1.2" }],
          },
        ],
      },
    ],
  },
  { title: "Patients" },
  { title: "Appointments" },
  { title: "Billing" },
  { title: "Reports" },
  {
    title: "Masters",
    submenu: [
      {
        title: "Admin Users",
        path: "/manageadminusers", // Define path dynamically
        component: "ManageAdminUsers",
      },
    ],
  },
];

const Menu = () => {
  const [activeMenu, setActiveMenu] = useState(null);

  const handleMouseEnter = (index) => {
    setActiveMenu(index);
  };

  const handleMouseLeave = () => {
    setActiveMenu(null);
  };

  return (
    <div>
      <nav className="menu">
        <ul>
          {menuItems.map((menu, index) => (
            <li
              key={index}
              onMouseEnter={() => handleMouseEnter(index)}
              onMouseLeave={handleMouseLeave}
              className="menu-item"
            >
              <Link to={menu.path || "#"}>{menu.title}</Link>

              {menu.submenu && activeMenu === index && (
                <ul className="submenu">
                  {menu.submenu.map((subItem, subIndex) => (
                    <li key={subIndex} className="submenu-item">
                      <Link to={subItem.path || "#"}>{subItem.title}</Link>

                      {subItem.submenu && (
                        <ul className="submenu">
                          {subItem.submenu.map((subSubItem, subSubIndex) => (
                            <li key={subSubIndex} className="submenu-item">
                              <Link to={subSubItem.path || "#"}>{subSubItem.title}</Link>
                            </li>
                          ))}
                        </ul>
                      )}
                    </li>
                  ))}
                </ul>
              )}
            </li>
          ))}
        </ul>
      </nav>
    </div>
  );
};

export default Menu;
