package sm.service;

import sm.pojo.Depart;

import java.util.List;

public interface DepartService {
    // 通过id获取部门信息
    Depart getDepartByID(int id);
    // 获取所有的部门信息
    List<Depart> getDepartList();
    // 通过id删除部门
    int delete(int id);
    // 通过id更新部门
    int update(Depart depart);
    // 增加部门
    int add(Depart depart);
}