package sm.service;

import sm.pojo.Students;

import java.util.List;

public interface StudentsService {
    // 增加学生
    int add(Students employee);
    //插入学生信息
    int save(Students employee);
    // 查询所有学生
    List<Students> getEmployeeList();
    // 根据id查询学生
    Students getEmployeeByID(int id);
    // 根据姓名查询学生
    Students getEmployeeByName(String name);
    // 根据id删除学生
    int delete(int id);
    // 根据id更新学生
    int update(Students employee);
    // 姓名和密码进行登录
    Students login(String username,String password);
    // 名字或部门进行查询
    List<Students> get(String name,String major,int studentid,int roleid);
    // 名字或部门进行查询
    List<Students> getBymajor(String name,String major,int studentid,int roleid);
    // 根据姓名查询学生
    List<Students> getEmployee(String name);
    // 根据部门id查询学生
    List<Students> getEmployeeByDepart(int departid);

    List<Students> getEmployeeByMajor(String major,int role);
}
