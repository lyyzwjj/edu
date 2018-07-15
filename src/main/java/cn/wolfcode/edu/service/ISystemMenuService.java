package cn.wolfcode.edu.service;

import cn.wolfcode.edu.domain.Permission;
import cn.wolfcode.edu.domain.SystemMenu;
import cn.wolfcode.edu.query.PageResult;
import cn.wolfcode.edu.query.QueryObject;

import java.util.List;

/**
 * Created by WangZhe on 2018/7/11.
 */
public interface ISystemMenuService {
    /**
     * 删除系统菜单
     * @param id 待删除系统菜单的id
     */
    void delete(Long id);

    /**
     * 添加系统菜单
     * @param entity
     */
    void save(SystemMenu entity);

    /**
     * 查询单个系统菜单
     * @param id  待查询系统菜单的id
     * @return
     */
    SystemMenu get(Long id);

    /**
     * 查询所有的系统菜单
     * @return
     */
    List<SystemMenu> list();

    /**
     * 更新系统菜单
     * @param entity
     */
    void update(SystemMenu entity);

    /**
     * 查询到分页结果集
     * @param qo 查询参数对象
     * @return
     */
    PageResult query(QueryObject qo);

    /**
     * 查询所有有子菜单的父级菜单 通过判断url是否有值
     * @return
     */
    List<SystemMenu> queryAllParentSystemMenu();

    /**
     * 找出主页菜单左侧的菜单树
     * @return 菜单树
     */
    List<SystemMenu> queryRootMenu();

    List<Permission> queryIndexPermission();
}
