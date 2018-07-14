package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SystemMenu {
    private Long id;

    private String text;

    private String url;

    private SystemMenu parent;

    private Permission permission;

    private String parentText;

    private Long _parentId;

    public String getParentText(){
        if (parent == null){
            return "";
        }
        return parent.getText();
    }
    public Object get_parentId(){
        if (parent == null){
            return "";
        }
        return parent.getId();
    }

}