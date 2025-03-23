package Old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class MenuControllerOld {

    private final MenuServiceOld menuService;

    // @Autowired
    public MenuControllerOld(MenuServiceOld menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDTOOld>> getAllMenus() {
        List<MenuDTOOld> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }
    
    // Additional endpoints for CRUD operations could be added here
}
