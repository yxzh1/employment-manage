package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sm.dao.EnterpriseDao;
import sm.dao.EnterpriseinfoDao;
import sm.dao.RecruitmentDao;
import sm.pojo.*;
import sm.service.EnterpriseService;

import java.util.List;
import java.util.Map;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    EnterpriseDao enterpriseDao; // 调用dao层
    @Autowired
    EnterpriseinfoDao enterpriseinfoDao; // 调用dao层
    @Autowired
    RecruitmentDao recruitmentDao;
    @Override
    public int add(Enterprise employee) {
        return enterpriseDao.insert(employee);
    }

    @Override
    public int addEnt(Enterprise employee) {
        String enterprise_name = employee.getEnterprise_name();
        Integer role = employee.getRole();
        Integer enterprise_addressid = employee.getEnterprise_addressid();
        Integer enterprise_industryid = employee.getEnterprise_industryid();
        Map<String, String> transferFName = enterpriseinfoDao.getTransferFName(enterprise_addressid, enterprise_industryid);
        String business_address = transferFName.get("business_address");
        String enterprise_industry = transferFName.get("enterprise_industry");

        Enterpriseinfo enterpriseinfo = new Enterpriseinfo();

        enterpriseinfo.setEnterprise_name(enterprise_name);
        enterpriseinfo.setRole(role);
        enterpriseinfo.setEnterprise_addressid(enterprise_addressid);
        enterpriseinfo.setEnterprise_industryid(enterprise_industryid);
        enterpriseinfo.setBusiness_address(business_address);
        enterpriseinfo.setEnterprise_industry(enterprise_industry);

        return enterpriseinfoDao.insert(enterpriseinfo);
    }

    @Override
    public int getinfoID(String enterprise_name) {
        return enterpriseinfoDao.getinfoID(enterprise_name);
    }

    @Override
    public List<Enterprise> getEmployeeList() {
        return enterpriseDao.getEmpList();
    }

    @Override
    public Enterprise getEmployeeByID(int id) {
        return enterpriseDao.getEmployeeByID(id);
    }

    @Override
    public Enterprise getEmployeeByName(String name) {
        return enterpriseDao.getEnterpriseByName(name);
    }

    @Override
    public int delete(int id) {
        return enterpriseDao.deleteById(id);
    }

    @Override
    public int update(Enterprise enterprise) {
        Enterprise employeeByID = enterpriseDao.getEmployeeByID(enterprise.getId());
        Enterpriseinfo employeeinfoByID = enterpriseinfoDao.getEmployeeinfoByID(enterprise.getId());

        recruitmentDao.updateRecruit(enterprise.getName(),enterprise.getEnterprise_name());

        employeeByID.setName(enterprise.getName());
        employeeByID.setPassword(enterprise.getPassword());
        employeeByID.setAge(enterprise.getAge());
        employeeByID.setSex(enterprise.getSex());
        employeeByID.setPhone(enterprise.getPhone());
        employeeByID.setEnterprise_addressid(enterprise.getEnterprise_addressid());
        employeeByID.setEnterprise_industryid(enterprise.getEnterprise_industryid());
        employeeByID.setEnterprise_name(enterprise.getEnterprise_name());

        employeeinfoByID.setEnterprise_name(enterprise.getEnterprise_name());

        Map<String, String> transferFName = null;
        if(enterprise.getEnterprise_addressid()!=null && enterprise.getEnterprise_industryid()!=null){
            transferFName = enterpriseinfoDao.getTransferFName(enterprise.getEnterprise_addressid(), enterprise.getEnterprise_industryid());
            String business_address = transferFName.get("business_address");
            String enterprise_industry = transferFName.get("enterprise_industry");
            employeeinfoByID.setBusiness_address(business_address);
            employeeinfoByID.setEnterprise_industry(enterprise_industry);
        }
        employeeinfoByID.setEnterprise_addressid(enterprise.getEnterprise_addressid());
        employeeinfoByID.setEnterprise_industryid(enterprise.getEnterprise_industryid());
        /**
         * 注意此处的employee属性的部门对象在数据库中并没有存储,所以不需要进行更新,
         * 只更新其另加的部门id字段即可,但是mybatis-plus默认的更新策略时更新所有不为空的字段,
         * 在更新的时候sql语句中会有部门对象的字段,此时就需要修改employee实体类的该字段的
         * 更新策略,改为never,这样sql语句中就不会再出现该字段
         * */
        int i = enterpriseDao.updateById(employeeByID);
        int i1 = enterpriseinfoDao.updateById(employeeinfoByID);
        if(i == 1 && i1 == 1){
            return 1;
        }else{ return 0;}
    }

    @Override
    public List<Enterprise> get(String name, int enterprise_usersid1, int enterprise_usersid2) {
        if (StringUtils.isEmpty(name)){  // 此处前端可能会传来null或者"",此处统一变为null,方便sql语句判断
            name=null;
        }
        return enterpriseDao.get(name,enterprise_usersid1,enterprise_usersid2);
    }

    @Override
    public List<Enterprise> getEnterprise(String name) {
        return enterpriseDao.getEmployee11(name);
    }

    @Override
    public List<Enterprise> getEmployeeByDepart(int enterprise_usersid) {
        return null;
    }

    @Override
    public List<Address> getAddressList() {
        return enterpriseDao.getAddressList();
    }

    @Override
    public List<Industry> getIndustryList() {
        return enterpriseDao.getIndustryList();
    }
}
