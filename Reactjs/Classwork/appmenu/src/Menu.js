import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Menu = () => {
  const [menuData, setMenuData] = useState([]);
  
  useEffect(() => {
    // Fetch top-level menu items from the API
    axios.get('http://localhost:8080/api/menu')
      .then(response => {
        setMenuData(response.data);
      })
      .catch(error => console.error('Error fetching menu data:', error));
  }, []);

  return (
    <div>
      {renderMenu(menuData)} {/* Use the renderMenu function here */}
    </div>
  );
};

const SubMenu = ({ parentId }) => {
  const [subMenuData, setSubMenuData] = useState([]);
  
  useEffect(() => {
    // Fetch sub-menu items for the given parentId
    axios.get(`http://localhost:8080/api/menu/${parentId}`)
      .then(response => {
        setSubMenuData(response.data);
      })
      .catch(error => console.error('Error fetching sub-menu data:', error));
  }, [parentId]);

  return subMenuData.length > 0 ? renderMenu(subMenuData) : null; // Use the renderMenu function here
};

// Helper function to render the menu (can be used both in Menu and SubMenu)
const renderMenu = (menuItems) => {
  return (
    <ul>
      {menuItems.map(item => (
        <li key={item.id}>
          <a href={item.menu_url}>{item.menu_name}</a>
          {/* Fetch and render submenus if they exist */}
          <SubMenu parentId={item.id} />
        </li>
      ))}
    </ul>
  );
};

export default Menu;
