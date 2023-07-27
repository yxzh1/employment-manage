package sm.service;

import sm.pojo.Roles;

import java.util.List;

public interface RoleService {
    // 查询所有的角色
    List<Roles> getRolesList();
    // 增加角色
    int add(Roles roles);
    // 删除角色
    int delete(int id);
    // 更新角色
    int update(Roles roles);
    // 根据id查询角色
    Roles getRoleByID(int id);
    // 根据名字删除角色
    int deleteByName(String name);
    // 根据名字查询角色
    Roles getRoleByName(String name);
}
