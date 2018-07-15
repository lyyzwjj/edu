package cn.wolfcode.edu.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDictionaryItem {

    private Long id;

    private DataDictionary parent;

    private String name;

    private String intro;
}