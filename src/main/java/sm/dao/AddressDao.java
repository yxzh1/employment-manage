package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sm.pojo.Address;

import java.util.List;
@Mapper
@Repository
public interface AddressDao extends BaseMapper<Address> {
    //查询所有地址
//    @Select("select * from address")
//    List<Address> getAddressList();

}
