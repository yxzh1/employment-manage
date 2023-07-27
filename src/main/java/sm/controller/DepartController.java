package sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.Depart;
import sm.pojo.Roles;
import sm.service.DepartService;
import sm.service.RoleService;

import java.util.List;

@Controller
public class DepartController {

    @Autowired
    DepartService departService;

    @RequestMapping("/dep/list")
    public String list(Model model){
        List<Depart> departList = departService.getDepartList();
        model.addAttribute("departList",departList);
        return "dep/list";
    }
    @RequestMapping("/dep/toAdd")
    public String toAdd(){
        return "dep/add";
    } // 跳转到增加页面
    @RequestMapping("/dep/add")
    public String add(Depart depart){
        departService.add(depart);    // 增加操作
        return "redirect:/dep/list";
    }
    @RequestMapping("/dep/toUpdate/{id}")   // 跳转到修改页面 需要携带该部门的信息
    public String toUpdate(@PathVariable("id") int id,Model model){
        Depart departByID = departService.getDepartByID(id);
        model.addAttribute("depart",departByID);
        return "dep/update";
    }
    @RequestMapping("/dep/update")
    public String update(Depart depart,String old){
        departService.update(depart);    // 修改部门名称
        return "redirect:/dep/list";
    }
    @RequestMapping("/dep/delete/{id}")
    public String delete(@PathVariable("id") int id){
        departService.delete(id);
        return "redirect:/dep/list";
    }
}