package sm.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import sm.pojo.Enterprise;
import sm.pojo.Students;
import sm.pojo.Teachers;
import sm.service.EnterpriseService;
import sm.service.StudentsService;
import sm.service.TeachersService;
import sm.util.Subent;

import java.util.Arrays;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    StudentsService studentsService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    TeachersService teachersService;

    @Override // 授权
    // 通过验证后,会对登录的用户进行授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Students students = (Students)subject.getPrincipal(); // 获取当前登录的用户
        String perms = students.getRoles().getPerms();        // 将数据库中权限字段以,进行拆分
        String[] split = perms.split(",");              // 构成权限数组
        List<String> list = Arrays.asList(split);
        info.addStringPermissions(list);    // 授予权限
        return info;
    }
    @Override // 认证
    // 会从登录请求到此
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();// 拿到当前的登录的用户名
        Students studentsByName = studentsService.getEmployeeByName(username);
        Enterprise enterpriseByName = enterpriseService.getEmployeeByName(username);
        Teachers teachersByName = teachersService.getEmployeeByName(username);
        if(studentsByName!=null){
            System.out.println("------------进入students---");
            System.out.println("-----------------"+studentsByName);
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("employee", studentsByName); // 将当前的登录用户存入session
            return new SimpleAuthenticationInfo(studentsByName, studentsByName.getPassword(), ""); // shiro会自己判断密码是否正确,不正确同样会出现异常,提示前端密码不正确
        }else if(enterpriseByName!=null){
            System.out.println("-----------进入enterprise---");

            Students getinfoent = Subent.getinfoent(enterpriseByName);
            System.out.println("-----------------"+getinfoent);

            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("employee", getinfoent); // 将当前的登录用户存入session
            return new SimpleAuthenticationInfo(getinfoent, getinfoent.getPassword(), ""); // shiro会自己判断密码是否正确,不正确同样会出现异常,提示前端密码不正确
        }else if(teachersByName!=null){
            System.out.println("------------进入teachers---");

            Students getinfosch = Subent.getinfosch(teachersByName);
            System.out.println("-----------------"+getinfosch);

            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            session.setAttribute("employee", getinfosch); // 将当前的登录用户存入session
            return new SimpleAuthenticationInfo(getinfosch, getinfosch.getPassword(), ""); // shiro会自己判断密码是否正确,不正确同样会出现异常,提示前端密码不正确

        } else return null;// 用户不存在,返回为空,此时登录请求会出现异常UnknownAccountException,提示前端用户名不存在

    }
}
