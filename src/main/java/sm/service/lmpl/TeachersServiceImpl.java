package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.TeachersDao;
import sm.pojo.Students;
import sm.pojo.Teachers;
import sm.service.TeachersService;

import java.util.List;
@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeachersDao teachersDao;
    @Override
    public List<Teachers> getSchList() {
        return teachersDao.getSchList();
    }

    @Override
    public Teachers getteachersByID(int id) {
        return teachersDao.getteachersByID(id);
    }

    @Override
    public int update(Teachers teachers) {
        Teachers employeeByID = teachersDao.getteachersByID(teachers.getId());
        employeeByID.setName(teachers.getName());
        employeeByID.setPassword(teachers.getPassword());
        employeeByID.setAge(teachers.getAge());
        employeeByID.setSex(teachers.getSex());
        employeeByID.setPhone(teachers.getPhone());
        employeeByID.setMajor(teachers.getMajor());
        employeeByID.setRole(teachers.getRole());
        /**
         * 注意此处的employee属性的部门对象在数据库中并没有存储,所以不需要进行更新,
         * 只更新其另加的部门id字段即可,但是mybatis-plus默认的更新策略时更新所有不为空的字段,
         * 在更新的时候sql语句中会有部门对象的字段,此时就需要修改employee实体类的该字段的
         * 更新策略,改为never,这样sql语句中就不会再出现该字段
         * */
        return teachersDao.updateById(employeeByID);
    }

    @Override
    public int delete(int id) {
        return teachersDao.deleteById(id);
    }

    @Override
    public List<Teachers> get(String name, String major, int roleid) {
        return teachersDao.get(name,major,roleid);
    }


    @Override
    public int addSch(Teachers teachers) {
        return teachersDao.insert(teachers);
    }

    @Override
    public Teachers getEmployeeByName(String name) {
        return teachersDao.getEmployeeByName(name);
    }
}
