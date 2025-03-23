package com.example.RestApi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getMenuByParentId(Long parentId) {
        return menuRepository.findByParentId(parentId);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findByParentId(null);  // Top-level menus
    }
}

//@Service
//public class MenuService {
//
//	@Autowired
//    private final MenuRepository menuRepository;
//
//    public MenuService(MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }
//
//    public List<MenuDTO> getAllMenus() {
//        List<Menu> rootMenus = menuRepository.findByParentIsNullOrderByOrderIndex();
//        return rootMenus.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }
//
//    private MenuDTO convertToDTO(Menu menu) {
//        MenuDTO dto = new MenuDTO();
//        dto.setId(menu.getId());
//        dto.setName(menu.getName());
//        dto.setLevel(menu.getLevel());
//        dto.setOrderIndex(menu.getOrderIndex());
//        dto.setContentId(menu.getContentId());
//        
//        // Recursively convert children
//        if (menu.getSubmenus() != null && !menu.getSubmenus().isEmpty()) {
//            List<MenuDTO> submenuDTOs = menu.getSubmenus().stream()
//                    .sorted((m1, m2) -> m1.getOrderIndex().compareTo(m2.getOrderIndex()))
//                    .map(this::convertToDTO)
//                    .collect(Collectors.toList());
//            dto.setSubmenus(submenuDTOs);
//        }
//        
//        return dto;
//    }
//    
//    // Additional methods for CRUD operations could be added here
//}
