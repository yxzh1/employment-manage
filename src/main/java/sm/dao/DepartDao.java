package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sm.pojo.Depart;

@Mapper
@Repository
public interface DepartDao extends BaseMapper<Depart> { // 继承BaseMapper 获取基本的CRUD操作
}
