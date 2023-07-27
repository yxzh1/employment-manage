package sm.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*登录拦截*/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object employee = session.getAttribute("employee");
        if(employee == null){ // 未登录,跳转到登录页,提示以下信息
            request.setAttribute("msg","无法访问,请先登录...");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false; // 进行拦截
        }else {
            return true;  // 放行
        }
    }
}

