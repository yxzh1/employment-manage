package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sm.pojo.Roles;

@Repository
@Mapper
public interface RoleDao extends BaseMapper<Roles> {
}
