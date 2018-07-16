package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class  Role {
    private Long id;

    private String sn;

    private String name;

    //维护与权限多对多关系
    private List<Permission> permissions= new ArrayList<>();
}