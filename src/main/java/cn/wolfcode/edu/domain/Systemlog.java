package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Systemlog {
    private Long id;

    private Employee opuser;

    private Date optime;

    private String oplp;

    private String function;

    private String params;


}