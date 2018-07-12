package cn.wolfcode.edu.mapper;

import cn.wolfcode.edu.domain.Grade;
import cn.wolfcode.edu.query.GradeQueryObject;
import cn.wolfcode.edu.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Grade record);

    Grade selectByPrimaryKey(Long id);

    List<Grade> selectAll();

    int updateByPrimaryKey(Grade record);

    int queryForCount(QueryObject qo);

    List<Grade> queryForList(GradeQueryObject qo);

    void changeState(Long id);

    /**
     * 维护班级与课程表关系
     * @param gradeId
     * @param courseId
     */
    void insertCourseRelation(@Param("gradeId") Long gradeId,@Param("courseId")Long courseId);


    /**
     * 删除班级与课程表关系
     * @param gradeId
     */
    void deleteCourseRelation(Long gradeId);
}