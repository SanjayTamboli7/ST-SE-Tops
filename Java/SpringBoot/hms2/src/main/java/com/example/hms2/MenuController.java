package com.example.hms2;

//package com.example.menuapp.controller;

//import com.example.menuapp.model.Menu;
//import com.example.menuapp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // Get dynamic menu structure
    @GetMapping
    public List<Menu> getMenuHierarchy() {
        return menuService.getMenuHierarchy();
    }
}

