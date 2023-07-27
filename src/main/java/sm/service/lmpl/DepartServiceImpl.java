package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.DepartDao;
import sm.pojo.Depart;
import sm.service.DepartService;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    DepartDao departDao;  // 调用dao层

    /**
     * selectById()、selectList()、deleteById()、updateById()、insert()
     * 这些都是继承BaseMapper之后 就直接可以使用的
     * */
    @Override
    public Depart getDepartByID(int id) {
        return departDao.selectById(id);
    }

    @Override
    public List<Depart> getDepartList() {
        return departDao.selectList(null);
    }

    @Override
    public int delete(int id) {
        return departDao.deleteById(id);
    }

    @Override
    public int update(Depart depart) { // 需要用到乐观锁,需要先获取depart对象,再对其进行修改
        Depart departByID = this.getDepartByID(depart.getId());
        departByID.setName(depart.getName());
        return departDao.updateById(departByID);
    }

    @Override
    public int add(Depart depart) {
        return departDao.insert(depart);
    }
}
