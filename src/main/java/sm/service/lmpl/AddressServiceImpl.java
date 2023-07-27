package sm.service.lmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sm.dao.AddressDao;
import sm.pojo.Address;
import sm.service.AddressService;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;
    @Override
    public List<Address> getAddressList() {
        return addressDao.selectList(null);
    }
    @Override
    public int delete(int id) {
        return addressDao.deleteById(id);
    }

    @Override
    public Address getAddressByID(int id) {
        return addressDao.selectById(id);
    }

    @Override
    public int update(Address address) { // 需要用到乐观锁,需要先获取depart对象,再对其进行修改
        Address addressByID = this.getAddressByID(address.getId());
        addressByID.setName(address.getName());
        return addressDao.updateById(addressByID);
    }

    @Override
    public int add(Address address) {
        return addressDao.insert(address);
    }
}
