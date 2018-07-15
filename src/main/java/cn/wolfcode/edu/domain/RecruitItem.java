package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitItem {
    //编码
    private Long id;
    //招聘职位
    private String job;
    //招聘方式
    private DataDictionaryItem recruitType;
    //聘用形式
    private DataDictionaryItem engage;
    //聘用人数
    private Integer recruitNumber;
    //学历
    private DataDictionaryItem education;
    //技能要求
    private String recruitRequired;
    //薪资要求
    private DataDictionaryItem recruitSalary;
    //备注
    private String remark;
    //对应招聘id
    private Long recruitId;


}
