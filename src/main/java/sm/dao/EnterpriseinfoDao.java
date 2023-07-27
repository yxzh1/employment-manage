package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sm.pojo.Enterpriseinfo;

import java.util.Map;

@Mapper
@Repository
public interface EnterpriseinfoDao extends BaseMapper<Enterpriseinfo> {
    Map<String,String> getTransferFName(@Param("enterprise_addressid") int enterprise_addressid
            ,@Param("enterprise_industryid") int enterprise_industryid);
    int getinfoID(String enterprise_name);
    Enterpriseinfo getEmployeeinfoByID(int id);
}
