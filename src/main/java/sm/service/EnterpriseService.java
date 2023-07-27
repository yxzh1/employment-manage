package sm.service;

import sm.pojo.Address;
import sm.pojo.Enterprise;
import sm.pojo.Enterpriseinfo;
import sm.pojo.Industry;

import java.util.List;

public interface EnterpriseService {
    // 增加企业人员
    int add(Enterprise employee);
    // 增加企业
    int addEnt(Enterprise employee);
    // 根据企业名称查询企业id
    int getinfoID(String enterprise_name);
    // 查询所有企业
    List<Enterprise> getEmployeeList();
    // 根据id查询企业
    Enterprise getEmployeeByID(int id);
    // 根据姓名查询企业
    Enterprise getEmployeeByName(String name);
    // 根据id删除企业
    int delete(int id);
    // 根据id更新企业
    int update(Enterprise enterprise);
    // 名字或部门进行查询
    List<Enterprise> get(String name,int enterprise_usersid1,int enterprise_usersid2);
    // 根据姓名查询企业
    List<Enterprise> getEnterprise(String name);
    // 根据企业id查询企业
    List<Enterprise> getEmployeeByDepart(int enterprise_usersid);
    //查询所有地址
    List<Address> getAddressList();
    //查询所有行业
    List<Industry> getIndustryList();
}
