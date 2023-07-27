package sm.service;

import sm.pojo.Address;

import java.util.List;

public interface AddressService {
    //查询所有地址
    List<Address> getAddressList();
    // 增加地址
    int add(Address address);
    // 删除地址
    int delete(int id);
    // 通过id获取地址信息
    Address getAddressByID(int id);
    // 通过id更新地址
    int update(Address address);
}
