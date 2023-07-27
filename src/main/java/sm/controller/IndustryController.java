package sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.Address;
import sm.pojo.Industry;
import sm.service.AddressService;
import sm.service.IndustryService;

import java.util.List;

@Controller
public class IndustryController {
    @Autowired
    IndustryService industryService;

    @RequestMapping("/industry/list")
    public String list(Model model){
        List<Industry> industryList = industryService.getIndustryList();
        model.addAttribute("industryList",industryList);
        return "industry/list";
    }
    @RequestMapping("/industry/toAdd")
    public String toAdd(){
        return "industry/add";
    } // 跳转到增加页面
    @RequestMapping("/industry/add")
    public String add(Industry industry){
        industryService.add(industry);    // 增加操作
        return "redirect:/industry/list";
    }
    @RequestMapping("/industry/toUpdate/{id}")   // 跳转到修改页面 需要携带该部门的信息
    public String toUpdate(@PathVariable("id") int id, Model model){
        Industry industryByID = industryService.getIndustryByID(id);
        model.addAttribute("industry",industryByID);
        return "industry/update";
    }
    @RequestMapping("/industry/update")
    public String update(Industry industry, String old){
        industryService.update(industry);    // 修改行业名称
        return "redirect:/industry/list";
    }
    @RequestMapping("/industry/delete/{id}")
    public String delete(@PathVariable("id") int id){
        industryService.delete(id);
        return "redirect:/industry/list";
    }
}
