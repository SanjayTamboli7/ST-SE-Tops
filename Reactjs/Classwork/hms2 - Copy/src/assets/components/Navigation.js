// components/Navigation.js
import React, { useState } from 'react';

function Navigation({ menuData, onMenuItemClick }) {
  const [activeMenus, setActiveMenus] = useState({});

  const toggleMenu = (menuId) => {
    setActiveMenus(prevState => ({
      ...prevState,
      [menuId]: !prevState[menuId]
    }));
  };

  // Function to close all menus
  const closeAllMenus = () => {
    setActiveMenus({});
  };

  const handleMenuItemClick = (contentId, event) => {
    event.stopPropagation();
    
    // Close all menus when selecting a final option
    closeAllMenus();
    
    // Notify parent about the content to load
    onMenuItemClick(contentId);
  };

  const renderSubmenus = (submenus, level = 1) => {
    if (!submenus || submenus.length === 0) return null;

    return (
      <ul className={`submenu level-${level}`}>
        {submenus.map(submenu => (
          <li 
            key={submenu.id} 
            className={`menu-item ${activeMenus[submenu.id] ? 'active' : ''}`}
          >
            <div 
              className="menu-item-content"
              onClick={(e) => {
                if (submenu.submenus && submenu.submenus.length > 0) {
                  e.stopPropagation();
                  toggleMenu(submenu.id);
                } else if (submenu.contentId) {
                  // This is a final menu option that loads content
                  handleMenuItemClick(submenu.contentId, e);
                }
              }}
            >
              <span>{submenu.name}</span>
              {submenu.submenus && submenu.submenus.length > 0 && (
                <span className="dropdown-icon">▼</span>
              )}
            </div>
            {activeMenus[submenu.id] && renderSubmenus(submenu.submenus, level + 1)}
          </li>
        ))}
      </ul>
    );
  };

  return (
    <nav className="main-navigation">
      <ul className="main-menu">
        {menuData.map(menu => (
          <li 
            key={menu.id} 
            className={`menu-item ${activeMenus[menu.id] ? 'active' : ''}`}
          >
            <div 
              className="menu-item-content"
              onClick={() => toggleMenu(menu.id)}
            >
              {menu.name}
              <span className="dropdown-icon">▼</span>
            </div>
            {activeMenus[menu.id] && renderSubmenus(menu.submenus)}
          </li>
        ))}
      </ul>
    </nav>
  );
}

export default Navigation;