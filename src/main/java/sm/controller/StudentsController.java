package sm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sm.pojo.Depart;
import sm.pojo.Roles;
import sm.pojo.Students;
import sm.service.DepartService;
import sm.service.RoleService;
import sm.service.StudentsService;
import sm.util.ValidateUtils;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @Autowired
    DepartService departService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username, String password,boolean rememberMe,String validateCode,Model model){
        //检验验证码
        int tryvalidate = ValidateUtils.tryvalidate(model, validateCode);
        if(tryvalidate == 0){
            return "index";
        }
        Subject subject = SecurityUtils.getSubject();  // 使用shiro 实现安全管理, 获取当前的对象
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //判断是否选中了记住我
//            System.out.println("rememberMe----------:"+rememberMe);
//            if (rememberMe) {
//                token.setRememberMe(rememberMe);
//            }
            subject.login(token);  // 登录
            return "redirect:/main.html"; // 重定向到首页
        }catch (UnknownAccountException e){
            model.addAttribute("msg","没有该用户");
            return "index";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "index";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        Object employee = session.getAttribute("employee");
        if(employee==null){ // 未登录 直接跳转登录页
            return "index";
        }else {
            session.removeAttribute("employee");  // 已登录 清除session 跳转登录页
            return "index";
        }
    }
//    @RequestMapping("/toregister")
//    public String totregister() {
//        return "register";
//    }
//    @RequestMapping("/studentInforegister")
//    private String studentInforegister(Students studentInfo) {
//        studentsService.save(studentInfo);
//        return "index";
//    }
    @RequestMapping("/emp/list")
    public String list(Model model,HttpSession session){
        Students employee = (Students)session.getAttribute("employee");
        String name1 = employee.getRoles().getName();
        Students employeeByID = new Students();
        String name ="";
        if(!name1.equals("辅导员") && !name1.equals("管理员")){
            employeeByID = studentsService.getEmployeeByID(employee.getId()); // 根据id重新查一遍,以防信息不准确
            name = employeeByID.getRoles().getName();  // 得到当前角色名字
        }else{
            name = name1;
        }

        List<Students> employeeList = null;
        if(name.equals("管理员")){
            employeeList = studentsService.getEmployeeList(); // 当前登录的是管理员,查询全部的学生
        }else if (name.equals("学生")){
            employeeList = studentsService.getEmployee(employeeByID.getName()); // 当前登录的是学生,只能查询自己的信息
        }else if(name.equals("辅导员")){
            employeeList = studentsService.getEmployeeByMajor(employee.getMajor(),3);
        }

        model.addAttribute("employeeList",employeeList);  // 统一将查询的学生信息返回前端
        List<Depart> departList = departService.getDepartList();
        model.addAttribute("departList",departList);  // 将所有的部门信息返回前端
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);    // 将所有的角色信息返回前端
        return "emp/list";
    }

    @RequestMapping("/emp/toAdd")
    public String toAdd(Model model){
        List<Depart> departList = departService.getDepartList();
        model.addAttribute("departList",departList); // 将所有的部门信息返回前端
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);   // 将所有的角色信息返回前端
        return "emp/add";
    }
    @RequestMapping("/emp/add")
    public String add(Students employee){
        System.out.println("-------------进入emp/add ： "+employee);
        studentsService.add(employee); // 添加员工操作
        return "redirect:/emp/list";
    }
    @RequestMapping("/emp/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id,Model model){
        Students employeeByID = studentsService.getEmployeeByID(id); // 更新员工先查到该员工,将信息返回更新页面
        System.out.println("emp/toUpdate------------ : "+employeeByID);
        model.addAttribute("employee",employeeByID);
        List<Depart> departList = departService.getDepartList();
        model.addAttribute("departList",departList);
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);
        return "emp/update";
    }
    @RequestMapping("/emp/update")
    public String update(Students employee){
        System.out.println("进入emp/update------------------");
        System.out.println("进入update------employee-------"+employee);
        studentsService.update(employee); // 更新员工操作
        return "redirect:/emp/list";
    }
    @RequestMapping("/emp/delete/{id}")
    public String delete(@PathVariable("id") int id){
        studentsService.delete(id);      // 删除员工操作
        return "redirect:/emp/list";
    }

    @RequestMapping("/emp/get")
    public String get( String name,String major,String studentid
            , String roleid, Model model,HttpSession session){
        Students employee = (Students)session.getAttribute("employee");
        String name1 = employee.getRoles().getName();
        System.out.println("--------emp/get-----name1-"+name1);
        System.out.println("---------emp/get----major--"+major);
        System.out.println("---------employee---major--"+employee.getMajor());
        List<Students> employeeList = null;
        if(name1.equals("辅导员")){
            if(major!=null){
                major = employee.getMajor();
            }
            if (studentid != null && roleid != null) {
                employeeList = studentsService.getBymajor(name, major, Integer.parseInt(studentid), Integer.parseInt(roleid));
            }else employeeList = studentsService.getBymajor(name, major, 0, 0);
        }else {
            if (studentid != null && roleid != null) {
                employeeList = studentsService.get(name, major, Integer.parseInt(studentid), Integer.parseInt(roleid));
            } else employeeList = studentsService.get(name, major, 0, 0);
        }
        model.addAttribute("employeeList",employeeList);

        List<Depart> departList = departService.getDepartList();
        model.addAttribute("departList",departList); // 需要注意的是   此处仍需要传部门列表和角色列表
        List<Roles> rolesList = roleService.getRolesList();
        model.addAttribute("rolesList",rolesList);
        return "emp/list";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }  // 此处需要设置一个未授权页面,之后当有没有权限的用户不合法访问页面时会跳转到该页面
    @RequestMapping("/echarts/list")
    public String echarts(){
        return "echarts/list";
    }


}
