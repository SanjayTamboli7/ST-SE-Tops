import React, { useState, useEffect, useRef } from 'react';
import axios from 'axios';
import { FaAngleDown, FaAngleRight } from 'react-icons/fa';
import './HorizontalMenu.css'; // We'll define this CSS file below

const HorizontalMenu = () => {
  const [menuData, setMenuData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [openMenus, setOpenMenus] = useState({});
  const menuRefs = useRef({});

  // Fetch menu data from Spring Boot API
  useEffect(() => {
    const fetchMenuData = async () => {
      try {
        setLoading(true);
        const response = await axios.get('http://localhost:8080/api/menus1');
        setMenuData(response.data);
        setError(null);
      } catch (err) {
        setError('Failed to load menu data. Please try again later.');
        console.error('Error fetching menu data:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchMenuData();
  }, []);

  // Close menus when clicking outside
  useEffect(() => {
    const handleClickOutside = (event) => {
      let clickedInsideMenu = false;
      
      // Check if click was inside any menu
      Object.keys(menuRefs.current).forEach(key => {
        if (menuRefs.current[key] && menuRefs.current[key].contains(event.target)) {
          clickedInsideMenu = true;
        }
      });
      
      if (!clickedInsideMenu) {
        setOpenMenus({});
      }
    };

    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  // Toggle submenu open/close state
  const toggleSubMenu = (menuId, event) => {
    event.preventDefault();
    event.stopPropagation();
    
    setOpenMenus(prev => {
      const newState = { ...prev };
      
      // If this menu is already open, close it
      if (newState[menuId]) {
        delete newState[menuId];
      } else {
        // Open this menu, close siblings at the same level
        const parentId = menuId.split('-').slice(0, -1).join('-');
        
        // Find and close sibling menus (menus with the same parent)
        Object.keys(newState).forEach(key => {
          const keyParentId = key.split('-').slice(0, -1).join('-');
          if (keyParentId === parentId) {
            delete newState[key];
          }
        });
        
        // Open the clicked menu
        newState[menuId] = true;
      }
      
      return newState;
    });
  };

  // Render menu items recursively
  const renderMenuItems = (items, level = 0, parentId = '') => {
    if (!items || items.length === 0) return null;

    return (
      <ul className={`menu-level-${level}`}>
        {items.map((item, index) => {
          const menuId = parentId ? `${parentId}-${index}` : `${index}`;
          const hasChildren = item.children && item.children.length > 0;
          const isOpen = openMenus[menuId];
          
          return (
            <li 
              key={menuId} 
              className={`menu-item ${hasChildren ? 'has-children' : ''} ${isOpen ? 'open' : ''}`}
              ref={el => menuRefs.current[menuId] = el}
            >
              <a 
                href={item.url || '#'} 
                onClick={(e) => hasChildren ? toggleSubMenu(menuId, e) : null}
                className={`menu-link ${level === 0 ? 'top-level' : ''}`}
              >
                {item.icon && <span className="menu-icon">{item.icon}</span>}
                <span className="menu-text">{item.label}</span>
                {hasChildren && (
                  <span className="menu-arrow">
                    {level === 0 ? <FaAngleDown /> : <FaAngleRight />}
                  </span>
                )}
              </a>
              
              {hasChildren && isOpen && (
                <div className={`submenu-container level-${level + 1}`}>
                  {renderMenuItems(item.children, level + 1, menuId)}
                </div>
              )}
            </li>
          );
        })}
      </ul>
    );
  };

  if (loading) return <div className="menu-loading">Loading menu...</div>;
  if (error) return <div className="menu-error">{error}</div>;

  return (
    <nav className="horizontal-menu-container">
      {renderMenuItems(menuData, 0)}
    </nav>
  );
};

export default HorizontalMenu;
