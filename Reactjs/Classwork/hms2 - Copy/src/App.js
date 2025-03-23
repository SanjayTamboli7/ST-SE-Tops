import React, { useState, useEffect } from 'react';
import './App.css';
import Header from './assets/components/Header';
import Navigation from './assets/components/Navigation';
import ContentArea from './assets/components/ContentArea';
import Footer from './assets/components/Footer';
import axios from 'axios';
import HorizontalMenu from './assets/components/HorizontalMenu';

function App() {
  const [menuData, setMenuData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [activeContent, setActiveContent] = useState('dashboard');

  useEffect(() => {
    // Fetch menu data from Spring Boot API
    const fetchMenuData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/menus');          
        setMenuData(response.data);
        setLoading(false);
        console.log("Flat 1");
        console.log(menuData);
        console.log("Flat 2");
      } catch (err) {
        setError('Failed to load menu data');
        setLoading(false);
        console.error('Error fetching menu data:', err);
      }
    };

    fetchMenuData();
  }, [menuData]);

  // Fallback menu data for development or when API is not available
  // useEffect(() => {
  //   if (error) {
  //     console.log("Using fallback menu data");
  //     setMenuData(generateFallbackMenuData());
  //     setLoading(false);
  //   }
  // }, [error]);

  const handleMenuClick = (contentId) => {
    setActiveContent(contentId);
  };

  return (
    <div className="app-container">
      <Header />
      {/* {!loading && (
        <Navigation menuData={menuData} onMenuItemClick={handleMenuClick} />
      )} */}
      <HorizontalMenu />
      <ContentArea activeContent={activeContent} />
      <Footer />
    </div>
  );
}

// Generate fallback menu data for development. Following code will be useless once system is ready finally.
function generateFallbackMenuData() {
  const menuData = [];
  
  for (let i = 1; i <= 5; i++) {
    const mainMenu = {
      id: `main-${i}`,
      name: `Main Menu ${i}`,
      submenus: []
    };
    
    for (let j = 1; j <= 5; j++) {
      const level1 = {
        id: `level1-${i}-${j}`,
        name: `Level 1 Submenu ${j}`,
        submenus: []
      };
      
      for (let k = 1; k <= 5; k++) {
        const level2 = {
          id: `level2-${i}-${j}-${k}`,
          name: `Level 2 Submenu ${k}`,
          submenus: []
        };
        
        for (let l = 1; l <= 5; l++) {
          const level3 = {
            id: `level3-${i}-${j}-${k}-${l}`,
            name: `Level 3 Submenu ${l}`,
            submenus: []
          };
          
          for (let m = 1; m <= 5; m++) {
            const level4 = {
              id: `level4-${i}-${j}-${k}-${l}-${m}`,
              name: `Level 4 Submenu ${m}`,
              submenus: []
            };
            
            for (let n = 1; n <= 5; n++) {
              level4.submenus.push({
                id: `level5-${i}-${j}-${k}-${l}-${m}-${n}`,
                name: `Level 5 Option ${n}`,
                contentId: `content-${i}-${j}-${k}-${l}-${m}-${n}`
              });
            }
            
            level3.submenus.push(level4);
          }
          
          level2.submenus.push(level3);
        }
        
        level1.submenus.push(level2);
      }
      
      mainMenu.submenus.push(level1);
    }
    
    menuData.push(mainMenu);
  }
  
  return menuData;
}

export default App;


