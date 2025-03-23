package Old;

import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceOld {

    private final MenuRepositoryOld menuRepository;

    // @Autowired
    public MenuServiceOld(MenuRepositoryOld menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuDTOOld> getAllMenus() {
        List<MenuOld> rootMenus = menuRepository.findByParentIsNullOrderByOrderIndex();
        return rootMenus.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MenuDTOOld convertToDTO(MenuOld menu) {
        MenuDTOOld dto = new MenuDTOOld();
        dto.setId(menu.getId());
        dto.setName(menu.getName());
        dto.setLevel(menu.getLevel());
        dto.setOrderIndex(menu.getOrderIndex());
        dto.setContentId(menu.getContentId());
        
        // Recursively convert children
        if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
            List<MenuDTOOld> submenuDTOs = menu.getSubmenus().stream()
                    .sorted((m1, m2) -> m1.getOrderIndex().compareTo(m2.getOrderIndex()))
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            dto.setSubmenus(submenuDTOs);
        }
        
        return dto;
    }
    
    // Additional methods for CRUD operations could be added here
}



