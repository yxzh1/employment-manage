package sm.service;

import sm.pojo.Enterprise;
import sm.pojo.Students;
import sm.pojo.Teachers;

import java.util.List;

public interface TeachersService {
    // 查询所有学生
    List<Teachers> getSchList();
    // 根据id查询企业
    Teachers getteachersByID(int id);
    // 根据id更新学生
    int update(Teachers teachers);
    // 根据id删除学生
    int delete(int id);
    // 名字或部门进行查询
    List<Teachers> get(String name,String major,int roleid);
    // 增加企业
    int addSch(Teachers teachers);

    // 根据姓名查询学生
    Teachers getEmployeeByName(String name);
}
