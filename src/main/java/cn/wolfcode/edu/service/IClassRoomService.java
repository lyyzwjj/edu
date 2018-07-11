package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.ClassRoom;
import cn.wolfcode.edu.query.ClassRoomQueryObject;
import cn.wolfcode.edu.query.PageResult;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/10.
 */
public interface IClassRoomService {

    void save(ClassRoom classroom);

    void update(ClassRoom classroom);

    void delete(Long id);

    ClassRoom get(Long id);

    List<ClassRoom> list();

    /**
     * 高级查询
     * @param qo
     * @return
     */
    PageResult query(ClassRoomQueryObject qo);

    /**
     * 根据教室id更改教室状态
     * @param id
     */
    void changeState(Long id);
}
