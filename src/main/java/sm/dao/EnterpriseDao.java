package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sm.pojo.Address;
import sm.pojo.Enterprise;
import sm.pojo.Industry;
import sm.pojo.Students;

import java.util.List;

@Mapper
@Repository
public interface EnterpriseDao extends BaseMapper<Enterprise> { // 继承BaseMapper 获取基本的CRUD操作
    //插入用户信息
    int save(Enterprise employee);
    // 查询所有企业信息
    List<Enterprise> getEmpList();   // 扩展自己的CRUD方法
    // 根据姓名查询员工
    Enterprise getEnterpriseByName(@Param("name") String name);
    // 根据id查询员工
    Enterprise getEmployeeByID(@Param("id") int id);
    // 用户名或部门或角色查询
    List<Enterprise> get(@Param("name") String name,@Param("enterprise_usersid1") int enterprise_usersid1,@Param("enterprise_usersid2") int enterprise_usersid2);
    // 根据姓名查询员工  之后设计员工登录的时候只显示自己的信息
    List<Enterprise> getEmployee11(@Param("name") String name);
    // 根据部门查询员工  之后设计各个部门经理登录会会显示各自部门的员工
    List<Enterprise> getEmployeeByDepartId(@Param("enterprise_usersid") int enterprise_usersid);

    List<Address> getAddressList();
    List<Industry> getIndustryList();
}
