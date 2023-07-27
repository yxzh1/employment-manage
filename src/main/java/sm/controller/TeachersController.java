package sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sm.pojo.*;
import sm.service.EnterpriseService;
import sm.service.RoleService;
import sm.service.StudentsService;
import sm.service.TeachersService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private StudentsService studentsService;

    @RequestMapping("/sch/list")
    public String list(Model model, HttpSession session){
        Students employee = (Students) session.getAttribute("employee");
        String s = employee.getRoles().getName();
        System.out.println("Role,name : "+s);
        String name="";
        Teachers teacherByID = new Teachers();
        if(s.equals("管理员")){
            name = s;
        }else if(s.equals("辅导员")){
            teacherByID = teachersService.getteachersByID(employee.getId()); // 根据id重新查一遍,以防信息不准确
            name = teacherByID.getRoles().getName();  // 得到当前角色名字

        }else if(s.equals("学生")){
            name = s;
        }
        else if (s.equals("企业")){
            name = s;
        }

        List<Teachers> teachersList = null;
        if(name.equals("管理员")){
            teachersList = teachersService.getSchList(); // 当前登录的是管理员,查询全部的企业
        }else if (name.equals("学生")){
            return "unauthorized";
        }else if (name.equals("企业")){
            return "unauthorized";
        }
        else if (name.equals("辅导员")){
            System.out.println("进入辅导员----------------------");
            teachersList = teachersService.getSchList();
        }

        model.addAttribute("teachersList",teachersList);  // 统一将查询的企业信息返回前端

        return "sch/list";
    }
    @RequestMapping("/sch/toAdd")
    public String toAdd(Model model){
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);   // 将所有的角色信息返回前端
        return "sch/add";
    }
    @RequestMapping("/sch/add")
    public String add(Teachers teachers){
        teachersService.addSch(teachers);
        return "redirect:/sch/list";
    }
    @RequestMapping("/sch/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Teachers teachersByID = teachersService.getteachersByID(id); // 更新员工先查到该员工,将信息返回更新页面
        model.addAttribute("teachers",teachersByID);
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);   // 将所有的角色信息返回前端
        return "sch/update";
    }
    @RequestMapping("/sch/update")
    public String update(Teachers teachers){
        teachersService.update(teachers); // 更新员工操作
        return "redirect:/sch/list";
    }
    @RequestMapping("/sch/delete/{id}")
    public String delete(@PathVariable("id") int id){
        teachersService.delete(id);      // 删除员工操作
        return "redirect:/sch/list";
    }

    @RequestMapping("/sch/get")
    public String get( String name,String major
            , String roleid, Model model){

        List<Teachers> teachersList = teachersService.get(name,major,Integer.parseInt(roleid));
        model.addAttribute("teachersList",teachersList);

        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);   // 将所有的角色信息返回前端
        return "sch/list";
    }
}
