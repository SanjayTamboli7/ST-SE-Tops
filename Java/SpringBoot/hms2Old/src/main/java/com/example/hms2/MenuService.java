package com.example.hms2;

//package com.example.menuapp.service;
//
//import com.example.menuapp.model.Menu;
//import com.example.menuapp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // Get full menu hierarchy
    public List<Menu> getMenuHierarchy() {
        List<Menu> topLevelMenus = menuRepository.findByParentId(null);
        return topLevelMenus.stream()
                .map(this::buildMenuHierarchy)
                .collect(Collectors.toList());
    }

    // Recursive method to build hierarchy
    private Menu buildMenuHierarchy(Menu menu) {
        List<Menu> submenus = menuRepository.findByParentId(menu.getId());
        if (!submenus.isEmpty()) {
            submenus = submenus.stream()
                    .map(this::buildMenuHierarchy)
                    .collect(Collectors.toList());
            menu.setSubmenus(submenus);
        }
        return menu;
    }
}

