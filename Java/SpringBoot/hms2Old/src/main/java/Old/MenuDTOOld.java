package Old;

import java.util.ArrayList;
import java.util.List;

public class MenuDTOOld {
    private Long id;
    private String name;
    private Integer level;
    private Integer orderIndex;
    private String contentId;
    private List<MenuDTOOld> submenus = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public List<MenuDTOOld> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<MenuDTOOld> submenus) {
        this.submenus = submenus;
    }
}

