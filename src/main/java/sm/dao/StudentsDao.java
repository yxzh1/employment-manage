package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sm.pojo.Students;

import java.util.List;

@Mapper
@Repository
public interface StudentsDao extends BaseMapper<Students> {
    //插入用户信息
    int save(Students employee);
    // 查询所有学生
    List<Students> getEmpList();   // 扩展自己的CRUD方法
    // 根据姓名查询学生
    Students getEmployeeByName(@Param("name") String name);
    // 根据id查询员工学生
    Students getEmployeeByID(@Param("id") int id);
    // 用户名和密码进行登录
    Students login(@Param("username") String username,@Param("password") String password);
    // 用户名或部门或角色查询
    List<Students> get(@Param("name") String name,@Param("major") String major,@Param("studentid") int studentid,@Param("roleid") int roleid);
    // 用户名或部门或角色查询
    List<Students> getBymajor(@Param("name") String name,@Param("major") String major,@Param("studentid") int studentid,@Param("roleid") int roleid);

    // 根据姓名查询学生  之后设计学生登录的时候只显示自己的信息
    List<Students> getEmployee(@Param("name") String name);

    List<Students> getEmployeeByDepartId(@Param("studentid") int studentid);

    List<Students> getEmployeeByMajor(@Param("major") String major,@Param("roleid") int roleid);

}
