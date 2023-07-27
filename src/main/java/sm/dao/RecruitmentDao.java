package sm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sm.pojo.Recruitment;

import java.util.List;

@Mapper
@Repository
public interface RecruitmentDao extends BaseMapper<Recruitment> {
    // 查询所有学生
    List<Recruitment> getZpxList();
    List<Recruitment> getRecruitmentByName(@Param("name") String name,@Param("Enterprise_name") String Enterprise_name);

    Recruitment getRecruitmentByID(int id);

    int updateRecruit(@Param("name") String name,@Param("Enterprise_name") String Enterprise_name);
}
