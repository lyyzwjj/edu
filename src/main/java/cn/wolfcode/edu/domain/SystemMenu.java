package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SystemMenu {
    private Long id;

    private String text;

    private String url;

    private SystemMenu parent;

    private Permission permission;

    private String parentText;

    private Long parentId;

    public String getParentText() {
        if (parent == null) {
            return "";
        }
        return parent.getText();
    }

    public Long getParentId() {
        if (parent == null) {
            return null;
        }
        return parent.getId();
    }

    private List<SystemMenu> children;

}