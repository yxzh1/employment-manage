package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.StudentsDao;
import sm.pojo.Students;
import sm.service.StudentsService;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentsServicelmpl implements StudentsService {
    @Autowired
    StudentsDao studentsDao; // 调用dao层

    @Override
    public int add(Students employee) {
        return studentsDao.insert(employee);
    }

    @Override
    public int save(Students employee) {
        return studentsDao.save(employee);
    }

    @Override
    public List<Students> getEmployeeList() {
        return studentsDao.getEmpList(); // 调用自己的方法
    }

    @Override
    public Students getEmployeeByID(int id) {
        return studentsDao.getEmployeeByID(id);// 调用自己的方法
    }

    @Override
    public Students getEmployeeByName(String name) {
        return studentsDao.getEmployeeByName(name);
    } // 调用自己的方法

    @Override
    public int delete(int id) {
        return studentsDao.deleteById(id);
    }

    @Override
    public int update(Students employee) {
        Students employeeByID = studentsDao.getEmployeeByID(employee.getId());
        employeeByID.setName(employee.getName());
        employeeByID.setPassword(employee.getPassword());
        employeeByID.setAge(employee.getAge());
        employeeByID.setSex(employee.getSex());
        employeeByID.setPhone(employee.getPhone());
        employeeByID.setBirth(employee.getBirth());
        employeeByID.setRole(employee.getRole());
        employeeByID.setStudentid(employee.getStudentid());
        /**
         * 注意此处的employee属性的部门对象在数据库中并没有存储,所以不需要进行更新,
         * 只更新其另加的部门id字段即可,但是mybatis-plus默认的更新策略时更新所有不为空的字段,
         * 在更新的时候sql语句中会有部门对象的字段,此时就需要修改employee实体类的该字段的
         * 更新策略,改为never,这样sql语句中就不会再出现该字段
         * */
        return studentsDao.updateById(employeeByID);
    }

    @Override
    public Students login(String username, String password) {
        return studentsDao.login(username,password);
    }

    @Override
    public List<Students> get(String name,String major, int studentid,int roleid) {
        if (StringUtils.isEmpty(name)){  // 此处前端可能会传来null或者"",此处统一变为null,方便sql语句判断
            name=null;
        }
        return studentsDao.get(name,major,studentid,roleid);
    }

    @Override
    public List<Students> getBymajor(String name, String major, int studentid, int roleid) {
        if (StringUtils.isEmpty(name)){  // 此处前端可能会传来null或者"",此处统一变为null,方便sql语句判断
            name=null;
        }
        return studentsDao.getBymajor(name,major,studentid,roleid);
    }

    @Override
    public List<Students> getEmployee(String name) {
        return studentsDao.getEmployee(name);
    }

    @Override
    public List<Students> getEmployeeByDepart(int departid) {
        return studentsDao.getEmployeeByDepartId(departid);
    }

    @Override
    public List<Students> getEmployeeByMajor(String major,int role) {
        return studentsDao.getEmployeeByMajor(major,role);
    }
}
