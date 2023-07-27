package sm.service;

import sm.pojo.Industry;

import java.util.List;

public interface IndustryService {
    //查询所有地址
    List<Industry> getIndustryList();
    // 增加地址
    int add(Industry industry);
    // 删除地址
    int delete(int id);
    // 通过id获取地址信息
    Industry getIndustryByID(int id);
    // 通过id更新地址
    int update(Industry industry);
}
