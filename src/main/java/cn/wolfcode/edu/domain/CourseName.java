package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseName {
    public static final int STATE_NORMAL = 1; //不是
    public static final int STATE_AUDITED = 0; //是

    private Long id;

    private String name;

    //课程编号
    private String sn;

    //课程系列
    private String series;

    //是否会员课程
    private int state;
}