package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRoom {
    public static final int STATE_NORMAL = 1; //可用
    public static final int STATE_AUDITED = 0; //停用

    private Long id;

    private String name;

    //班级地址
    private String address;

    //班级座位
    private int seat;

    private int state;

}