package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sm.pojo.Address;
import sm.pojo.Industry;

@Mapper
@Repository
public interface IndustryDao extends BaseMapper<Industry> {
}
