package cn.wolfcode.edu.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {

    //分页总条数
    private int total;
    //分页数据
    private List<?> rows = new ArrayList<>();
}
