package sm.service.lmpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.RoleDao;
import sm.pojo.Roles;
import sm.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao; // 调用dao层

    @Override
    public List<Roles> getRolesList() {
        return roleDao.selectList(null);
    }

    @Override
    public int add(Roles roles) {
        return roleDao.insert(roles);
    }

    @Override
    public int delete(int id) {
        return roleDao.deleteById(id);
    }

    @Override
    public int update(Roles roles) {
        return roleDao.updateById(roles);
    }

    @Override
    public Roles getRoleByID(int id) {
        return roleDao.selectById(id);
    }

    @Override
    public int deleteByName(String name) {
        QueryWrapper<Roles> rolesQueryWrapper = new QueryWrapper<>();
        rolesQueryWrapper.eq("name",name); // 使用条件构造器
        return roleDao.delete(rolesQueryWrapper);
    }

    @Override
    public Roles getRoleByName(String name) {
        QueryWrapper<Roles> rolesQueryWrapper = new QueryWrapper<>();
        rolesQueryWrapper.eq("name",name);
        return roleDao.selectOne(rolesQueryWrapper);
    }
}
