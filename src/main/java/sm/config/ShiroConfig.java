package sm.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sm.util.shiro_authority;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 3.ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 关联DefaultWebSecurityManager,同样需要传参引入,此处的bean使用了别名
        bean.setSecurityManager(manager);
        //通过工具类的方法获取权限
        Map<String, String> map = shiro_authority.getAuthority();

        /*
        * anon:无需认证都可访问        authc:必须认证才能访问
        * user:必须拥有记住我功能才能有   perms:拥有对某个资源的权限才能访问  role:拥有某个角色权限才能访问
        * */

        bean.setFilterChainDefinitionMap(map);
        //未授权页面
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    //2.DefaultWebSecurityManager
    @Bean(name = "manager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm
            ,@Qualifier("remeber") RememberMeManager remeber)	{
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 关联Realm 因为MyRealm已经被Spring接管,所以需要传参引入,传参的时候需要用到Qualifier指定bean的名字
        manager.setRealm(myRealm);
        //设置记住我功能
//        manager.setRememberMeManager(rememberMeManager());
        manager.setRememberMeManager(remeber);

        return manager;
    }

    //1.创建Realm
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    // shiro整合thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    //配置记住我管理器对象，此对象可以通过cookie对象存储账户信息，并将此信息
    //写到客户端，下次客户端可以访问服务端时，可以携带cookie中的信息进行自动认证。
    @Bean(name = "remeber")
    public RememberMeManager rememberMeManager() {
        CookieRememberMeManager cManager=new CookieRememberMeManager();
        SimpleCookie cookie=new SimpleCookie("rememberMe");
        cookie.setMaxAge(7*24*60*60);
        cManager.setCookie(cookie);
        //设置加密解密密钥(假如服务器重启以后，还是需要重新登陆，将下面的语句注释掉)
        //注意:
        //1)密钥的选择16位的一个字符串
        //2)密钥的复杂度越高，加密以后的内容就越安全。
        cManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
        //cManager.setCipherKey("abcd12345678qwer".getBytes());
        return cManager;
    }
}
