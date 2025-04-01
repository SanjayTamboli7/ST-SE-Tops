import React, { useState, useEffect, useRef } from 'react';
import { Link, useLocation } from 'react-router-dom';
import './Menu.css';

// Environment check for development-only features
const isDev = process.env.NODE_ENV === 'development';

const MenuItem = ({ item, depth = 0, parentExpanded = true }) => {
  const [dropdown, setDropdown] = useState(false);
  const location = useLocation();
  const menuRef = useRef(null);

  // Check if this item or any of its children is active
  const checkActive = (menuItem) => {
    if (location.pathname === menuItem.path) {
      return true;
    }
    if (menuItem.submenus && menuItem.submenus.length > 0) {
      return menuItem.submenus.some(submenu => checkActive(submenu));
    }
    return false;
  };
  
  const isActive = checkActive(item);
  
  // Auto-expand parent menus if a child is active
  useEffect(() => {
    if (isActive && depth > 0) {
      setDropdown(true);
    }
  }, [location.pathname, isActive, depth]);

  // Only log in development mode
  useEffect(() => {
    if (isDev) {
      console.log(`MenuItem rendered: ${item.label}, path: ${item.path}, isActive: ${isActive}`);
    }
  }, [item, isActive]);

  const toggleDropdown = (e) => {
    // Prevent event from bubbling up
    e.stopPropagation();
    e.preventDefault();
    
    if (isDev) {
      console.log(`Toggling dropdown for: ${item.label}`);
    }
    setDropdown(!dropdown);
  };

  // Handle clicks outside to close dropdown
  useEffect(() => {
    const handleClickOutside = (event) => {
      if (menuRef.current && !menuRef.current.contains(event.target)) {
        setDropdown(false);
      }
    };
    
    if (dropdown) {
      document.addEventListener('mousedown', handleClickOutside);
    }
    
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, [dropdown]);

  // Get the appropriate path
  const path = item.path || (item.label ? `/${item.label.toLowerCase().replace(/\s+/g, '-')}` : '/');

  // Handle clicks on regular menu items
  const handleClick = () => {
    if (isDev) {
      console.log(`Menu item clicked: ${item.label}, navigating to: ${path}`);
    }
    
    // Close dropdown when a regular item is clicked (optional)
    if (!item.submenus) {
      setDropdown(false);
    }
  };

  const hasSubmenus = item.submenus && item.submenus.length > 0;

  // Only render if parent is expanded or this is a top-level item
  const shouldRender = depth === 0 || parentExpanded;
  
  if (!shouldRender) return null;

  return (
    <li 
      ref={menuRef}
      className={`menu-item depth-${depth} ${dropdown ? 'expanded' : ''} ${isActive ? 'current' : ''}`}
    >
      {hasSubmenus ? (
        <>
          <div className="menu-item-container">
            {/* If it has a path, make it a link + toggle button */}
            {item.path ? (
              <>
                <Link 
                  to={path}
                  onClick={handleClick}
                  className={`menu-link ${isActive ? 'active' : ''}`}
                >
                  {item.label || 'Menu Item'}
                </Link>
                <button 
                  type="button" 
                  aria-haspopup="menu"
                  aria-expanded={dropdown ? "true" : "false"}
                  onClick={toggleDropdown}
                  className="dropdown-toggle"
                >
                  <span className={`arrow ${dropdown ? 'up' : 'down'}`} aria-hidden="true"></span>
                </button>
              </>
            ) : (
              /* If no path, make the whole thing a toggle button */
              <button 
                type="button" 
                aria-haspopup="menu"
                aria-expanded={dropdown ? "true" : "false"}
                onClick={toggleDropdown}
                className={`menu-button ${isActive ? 'active' : ''}`}
              >
                {item.label || 'Menu'}
                <span className={`arrow ${dropdown ? 'up' : 'down'}`} aria-hidden="true"></span>
              </button>
            )}
          </div>
          <ul 
            className={`dropdown-menu depth-${depth} ${dropdown ? 'show' : ''}`}
            role="menu"
          >
            {item.submenus.map((subItem, index) => (
              <MenuItem 
                key={`${item.label}-submenu-${index}`} 
                item={subItem} 
                depth={depth + 1}
                parentExpanded={dropdown}
              />
            ))}
          </ul>
        </>
      ) : (
        <Link 
          to={path}
          onClick={handleClick}
          className={`menu-link ${isActive ? 'active' : ''}`}
        >
          {item.label || 'Menu Item'}
        </Link>
      )}
    </li>
  );
};

const Menu = ({ menuItems }) => {
  const location = useLocation();
  
  useEffect(() => {
    if (isDev) {
      console.log("Menu component rendered, current path:", location.pathname);
    }
  }, [location]);

  return (
    <nav className="main-menu" aria-label="Main Navigation">
      <ul className="menu-list" role="menubar">
        {menuItems.map((menu, index) => (
          <MenuItem 
            key={`main-menu-${index}`} 
            item={menu} 
          />
        ))}
      </ul>
    </nav>
  );
};

export default Menu;
