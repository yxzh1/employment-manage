package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sm.pojo.Students;
import sm.pojo.Teachers;

import java.util.List;
@Mapper
@Repository
public interface TeachersDao extends BaseMapper<Teachers> {
    // 查询所有学生
    List<Teachers> getSchList();   // 扩展自己的CRUD方法

    Teachers getteachersByID(int id);

    // 用户名或部门或角色查询
    List<Teachers> get(@Param("name") String name, @Param("major") String major, @Param("roleid") int roleid);

    Teachers getEmployeeByName(String name);
}
