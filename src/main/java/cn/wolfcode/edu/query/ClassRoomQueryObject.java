package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRoomQueryObject extends QueryObject{
    private String keyword;//根据教室名称或地址查询

    public String getKeyword(){

        return StringUtils.isEmpty(keyword) ? null :keyword;
    }
}
