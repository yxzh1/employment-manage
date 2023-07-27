package sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.*;
import sm.service.EnterpriseService;
import sm.service.RecruitmentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @Autowired
    EnterpriseService enterpriseService;

    @RequestMapping("/zpx/list")
    public String list(Model model, HttpSession session){
        Students employee = (Students) session.getAttribute("employee");
        System.out.println("进入zpx/list----------");
        List<Recruitment> zpxList = null;
        String s = employee.getRoles().getName();
        if(s.equals("企业")){
            String person_in_charge = employee.getName();
            String Enterprise_name = employee.getEnterprise_name();
            zpxList = recruitmentService.getRecruitmentByName(person_in_charge,Enterprise_name);//企业登录只能看到自己发布的招聘信息
        }else zpxList = recruitmentService.getZpxList();

        model.addAttribute("zpxList",zpxList);
        return "zpx/list";
    }
    @RequestMapping("/zpx/toAdd")
    public String toAdd(Model model){
        List<Enterprise> enterpriseList = enterpriseService.getEmployeeList();
        model.addAttribute("enterpriseList",enterpriseList);
        return "zpx/add";
    }
    @RequestMapping("/zpx/add")
    public String add(Recruitment recruitment,HttpSession session){
        System.out.println("进入zpx/add--------");
        System.out.println("-----------"+recruitment);
        Students employee = (Students) session.getAttribute("employee");
        System.out.println("-----------employee--"+employee);
        String name = employee.getName();
        recruitmentService.add(recruitment,name);
        return "redirect:/zpx/list";
    }
    @RequestMapping("/zpx/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Recruitment recruitmenByID = recruitmentService.getRecruitmentByID(id); // 更新员工先查到该员工,将信息返回更新页面
        System.out.println("zpx/toUpdate------------ : "+recruitmenByID);
        model.addAttribute("zpx",recruitmenByID);
        List<Enterprise> enterpriseList = enterpriseService.getEmployeeList();
        model.addAttribute("enterpriseList",enterpriseList);
        return "zpx/update";
    }
    @RequestMapping("/zpx/update")
    public String update(Recruitment recruitment){
        System.out.println("进入zpx/update------------------");
        System.out.println("进入update------recruitment-------"+recruitment);
        recruitmentService.update(recruitment); // 更新员工操作
        return "redirect:/zpx/list";
    }
    @RequestMapping("/zpx/delete/{id}")
    public String delete(@PathVariable("id") int id){
        recruitmentService.delete(id);      // 删除员工操作
        return "redirect:/zpx/list";
    }
}
