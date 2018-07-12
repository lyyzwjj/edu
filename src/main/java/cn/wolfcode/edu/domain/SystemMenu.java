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

}