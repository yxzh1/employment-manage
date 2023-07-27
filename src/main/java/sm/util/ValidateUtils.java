package sm.util;

import com.google.code.kaptcha.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.ui.Model;


public class ValidateUtils {
    public static int tryvalidate(Model model, String validateCode){
        //1、检验验证码
        if(validateCode == null || validateCode.equals("")){
            model.addAttribute("msg","请输入验证码");
            return 0;
        }
        Session session1 = SecurityUtils.getSubject().getSession();
        //转化成小写字母
        validateCode = validateCode.toLowerCase();
        String v = (String) session1.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
        //session.removeAttribute("_come");
        if(!validateCode.equals(v)){
            model.addAttribute("msg","验证码错误，请重输");
            return 0;
        }
        return 1;
    }
}
