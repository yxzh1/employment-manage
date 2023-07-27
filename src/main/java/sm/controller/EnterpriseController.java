package sm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.*;
import sm.service.EnterpriseService;
import sm.service.RoleService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class EnterpriseController {
    @Autowired
    EnterpriseService enterpriseService;

    @RequestMapping("/etp/list")
    public String list(Model model,HttpSession session){
        Students employee = (Students) session.getAttribute("employee");
        System.out.println("----etp/list/-------"+employee);
        String s = employee.getRoles().getName();
        System.out.println("Role,name : "+s);
        String name="";
        Enterprise employeeByID = new Enterprise();
        if(s.equals("管理员")){
            name = s;
        }else if(s.equals("辅导员")){
            name = s;
        }else if(s.equals("学生")){
            name = s;
        }
        else if (s.equals("企业")){
            employeeByID = enterpriseService.getEmployeeByID(employee.getId()); // 根据id重新查一遍,以防信息不准确
            name = employeeByID.getRoles().getName();  // 得到当前角色名字
        }

        List<Enterprise> enterpriseList = null;
        if(name.equals("管理员")){
            enterpriseList = enterpriseService.getEmployeeList(); // 当前登录的是管理员,查询全部的企业
        }else if (name.equals("学生")){
            enterpriseList = enterpriseService.getEmployeeList();
        }else if (name.equals("企业")){
            System.out.println("进入企业----------------------");
            enterpriseList = enterpriseService.getEnterprise(employeeByID.getName());
            System.out.println("enterpriseList-----------------: "+enterpriseList);
        }
        else if (name.equals("辅导员")){
            enterpriseList = enterpriseService.getEmployeeList();
        }

        model.addAttribute("enterpriseList",enterpriseList);  // 统一将查询的企业信息返回前端

        List<Industry> enterprise1 = enterpriseService.getIndustryList();
        model.addAttribute("enterpriseList1",enterprise1);  // 将所有的信息返回前端
        List<Address> enterprise2 = enterpriseService.getAddressList();
        model.addAttribute("enterpriseList2",enterprise2);    // 将所有的信息返回前端
        return "etp/list";
    }
    @RequestMapping("/etp/toAdd")
    public String toAdd(Model model){
        List<Industry> enterprise1 = enterpriseService.getIndustryList();
        model.addAttribute("enterpriseList1",enterprise1);  // 将所有的信息返回前端
        List<Address> enterprise2 = enterpriseService.getAddressList();
        model.addAttribute("enterpriseList2",enterprise2);    // 将所有的信息返回前端
        return "etp/add";
    }
    @RequestMapping("/etp/add")
    public String add(Enterprise employee){
        employee.setRole(4);//由于默认是企业角色，所以这里直接设
        enterpriseService.addEnt(employee);
        String enterprise_name = employee.getEnterprise_name();
        int enterpriseinfo_id = enterpriseService.getinfoID(enterprise_name);
        employee.setEnterprise_usersid(enterpriseinfo_id);
        enterpriseService.add(employee); // 添加企业人员操作
        return "redirect:/etp/list";
    }
    @RequestMapping("/etp/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Enterprise employeeByID = enterpriseService.getEmployeeByID(id); // 更新员工先查到该员工,将信息返回更新页面
        System.out.println("etp/toUpdate------------ : "+employeeByID);
        model.addAttribute("enterprise",employeeByID);
        List<Industry> enterprise1 = enterpriseService.getIndustryList();
        model.addAttribute("enterpriseList1",enterprise1);  // 将所有的信息返回前端
        List<Address> enterprise2 = enterpriseService.getAddressList();
        model.addAttribute("enterpriseList2",enterprise2);    // 将所有的信息返回前端
        return "etp/update";
    }
    @RequestMapping("/etp/update")
    public String update(Enterprise enterprise){
        System.out.println("进入etp/update------------------");
        System.out.println("进入update------enterprise-------"+enterprise);
        enterpriseService.update(enterprise); // 更新员工操作
        return "redirect:/etp/list";
    }
    @RequestMapping("/etp/delete/{id}")
    public String delete(@PathVariable("id") int id){
        enterpriseService.delete(id);      // 删除员工操作
        return "redirect:/etp/list";
    }

    @RequestMapping("/etp/get")
    public String get( String name,String enterprise_usersid1
            , String enterprise_usersid2, Model model){

        System.out.println("--------------------enterprise_usersid1"+enterprise_usersid1);
        System.out.println("--------------------enterprise_usersid2"+enterprise_usersid2);
        List<Enterprise> employeeList = enterpriseService.get(name, Integer.parseInt(enterprise_usersid1),Integer.parseInt(enterprise_usersid2));
        model.addAttribute("enterpriseList",employeeList);

        List<Industry> enterprise1 = enterpriseService.getIndustryList();
        model.addAttribute("enterpriseList1",enterprise1);  // 将所有的信息返回前端
        List<Address> enterprise2 = enterpriseService.getAddressList();
        model.addAttribute("enterpriseList2",enterprise2);    // 将所有的信息返回前端
        return "etp/list";
    }
}
