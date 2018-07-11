package cn.wolfcode.edu.query;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartmentQueryObject extends QueryObject {
    private String keyword;

    public String getKeyword(){return StringUtils.isEmpty(keyword)? null :keyword; }
}
