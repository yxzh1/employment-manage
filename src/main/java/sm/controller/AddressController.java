package sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.Address;
import sm.service.AddressService;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/address/list")
    public String list(Model model){
        List<Address> addressList = addressService.getAddressList();
        model.addAttribute("addressList",addressList);
        return "address/list";
    }
    @RequestMapping("/address/toAdd")
    public String toAdd(){
        return "address/add";
    } // 跳转到增加页面
    @RequestMapping("/address/add")
    public String add(Address address){
        addressService.add(address);    // 增加操作
        return "redirect:/address/list";
    }
    @RequestMapping("/address/toUpdate/{id}")   // 跳转到修改页面 需要携带该部门的信息
    public String toUpdate(@PathVariable("id") int id, Model model){
        Address addressByID = addressService.getAddressByID(id);
        model.addAttribute("address",addressByID);
        return "address/update";
    }
    @RequestMapping("/address/update")
    public String update(Address address,String old){
        addressService.update(address);    // 修改部门名称
        return "redirect:/address/list";
    }
    @RequestMapping("/address/delete/{id}")
    public String delete(@PathVariable("id") int id){
        addressService.delete(id);
        return "redirect:/address/list";
    }
}
