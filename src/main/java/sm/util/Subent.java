package sm.util;

import sm.pojo.*;

import java.util.Date;

public class Subent {
    public static Students getinfoent(Enterprise enterprise){
        Integer id = enterprise.getId();
        String name = enterprise.getName();
        String password = enterprise.getPassword();
        Integer age = enterprise.getAge();
        Integer sex = enterprise.getSex();
        String phone = enterprise.getPhone();
        Date birth = enterprise.getBirth();
        Integer role = enterprise.getRole();
        Roles roles = enterprise.getRoles();
        Date createtime = enterprise.getCreatetime();
        Date updatetime = enterprise.getUpdatetime();
        Integer version = enterprise.getVersion();
        Integer deleted = enterprise.getDeleted();
        Integer enterprise_usersid = enterprise.getEnterprise_usersid();
        Integer enterprise_addressid = enterprise.getEnterprise_addressid();
        Integer enterprise_industryid = enterprise.getEnterprise_industryid();
        String enterprise_name = enterprise.getEnterprise_name();
        Enterpriseinfo enterpriseinfo = enterprise.getEnterpriseinfo();

        Students students = new Students();
        students.setId(id);
        students.setName(name);
        students.setPassword(password);
        students.setAge(age);
        students.setSex(sex);
        students.setPhone(phone);
        students.setBirth(birth);
        students.setRole(role);
        students.setRoles(roles);
        students.setCreatetime(createtime);
        students.setUpdatetime(updatetime);
        students.setVersion(version);
        students.setDeleted(deleted);
        students.setEnterprise_usersid(enterprise_usersid);
        students.setEnterprise_addressid(enterprise_addressid);
        students.setEnterprise_industryid(enterprise_industryid);
        students.setEnterprise_name(enterprise_name);
        students.setEnterpriseinfo(enterpriseinfo);

        return students;
    }
    public static Students getinfosch(Teachers teachers){
        Integer id = teachers.getId();
        String name = teachers.getName();
        String password = teachers.getPassword();
        Integer age = teachers.getAge();
        Integer sex = teachers.getSex();
        String phone = teachers.getPhone();
        String major = teachers.getMajor();
        Date birth = teachers.getBirth();
        Integer role = teachers.getRole();
        Roles roles = teachers.getRoles();
        Date createtime = teachers.getCreatetime();
        Date updatetime = teachers.getUpdatetime();
        Integer version = teachers.getVersion();
        Integer deleted = teachers.getDeleted();
        //还没用到
        Integer teacherid = teachers.getTeacherid();

        Students students = new Students();
        students.setId(id);
        students.setName(name);
        students.setPassword(password);
        students.setAge(age);
        students.setSex(sex);
        students.setPhone(phone);
        students.setMajor(major);
        students.setBirth(birth);
        students.setRole(role);
        students.setRoles(roles);
        students.setCreatetime(createtime);
        students.setUpdatetime(updatetime);
        students.setVersion(version);
        students.setDeleted(deleted);

        return students;
    }
}
