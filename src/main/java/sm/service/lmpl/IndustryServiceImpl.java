package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.AddressDao;
import sm.dao.IndustryDao;
import sm.pojo.Address;
import sm.pojo.Industry;
import sm.service.AddressService;
import sm.service.IndustryService;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    IndustryDao industryDao;
    @Override
    public List<Industry> getIndustryList() {
        return industryDao.selectList(null);
    }

    @Override
    public int add(Industry industry) {
        return industryDao.insert(industry);
    }

    @Override
    public int delete(int id) {
        return industryDao.deleteById(id);
    }

    @Override
    public Industry getIndustryByID(int id) {
        return industryDao.selectById(id);
    }

    @Override
    public int update(Industry industry) {// 需要用到乐观锁,需要先获取depart对象,再对其进行修改
        Industry industryByID = this.getIndustryByID(industry.getId());
        industryByID.setName(industry.getName());
        return industryDao.updateById(industryByID);
    }

}
