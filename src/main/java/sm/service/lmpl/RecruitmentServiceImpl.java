package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.EnterpriseDao;
import sm.dao.RecruitmentDao;
import sm.pojo.Enterprise;
import sm.pojo.Recruitment;
import sm.service.RecruitmentService;

import java.util.List;
@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentDao recruitmentDao;
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Override
    public List<Recruitment> getZpxList() {
        return recruitmentDao.getZpxList();
    }

    @Override
    public List<Recruitment> getRecruitmentByName(String name,String Enterprise_name) {
        return recruitmentDao.getRecruitmentByName(name,Enterprise_name);
    }

    @Override
    public int add(Recruitment recruitment,String name) {
//        String person_in_charge = recruitment.getPerson_in_charge();
        //由于负责人是从enterprise_users表拿的，所以需要更新
//        Integer id = recruitment.getId();
//        Enterprise enterprise = enterpriseDao.selectById(id);
//        enterprise.setName(person_in_charge);
//        enterpriseDao.updateById(enterprise);
//因为 person_in_charge=1,所以需要做操作
        String person_in_charge = recruitment.getPerson_in_charge();
        Enterprise enterpriseByName = enterpriseDao.getEnterpriseByName(person_in_charge);
        Integer id = enterpriseByName.getId();
        recruitment.setReid(id);
        return recruitmentDao.insert(recruitment);
    }

    @Override
    public Recruitment getRecruitmentByID(int id) {
        return recruitmentDao.getRecruitmentByID(id);
    }

    @Override
    public int update(Recruitment recruitment) {
        Recruitment recruitmentByID = recruitmentDao.getRecruitmentByID(recruitment.getId());
        recruitmentByID.setEnterprise_name(recruitment.getEnterprise_name());
        recruitmentByID.setPerson_in_charge(recruitment.getPerson_in_charge());
        recruitmentByID.setRecruitment_occupation(recruitment.getRecruitment_occupation());
        recruitmentByID.setCompensation_and_benefits(recruitment.getCompensation_and_benefits());
        recruitmentByID.setEducational_requirements(recruitment.getEducational_requirements());
        recruitmentByID.setProfessional_requirements(recruitment.getProfessional_requirements());
        return recruitmentDao.updateById(recruitmentByID);
    }

    @Override
    public int delete(int id) {
        return recruitmentDao.deleteById(id);
    }

}
