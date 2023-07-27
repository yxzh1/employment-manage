package sm.service;

import sm.pojo.Recruitment;

import java.util.List;

public interface RecruitmentService {
    // 查询所有
    List<Recruitment> getZpxList();

    List<Recruitment> getRecruitmentByName(String name,String Enterprise_name);

    int add(Recruitment recruitment,String name);

    Recruitment getRecruitmentByID(int id);

    int update(Recruitment recruitment);

    int delete(int id);
}
