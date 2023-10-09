package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author Xianhuii
 * @date 2023/10/9 22:13
 */
public class Shiro {
    public static void main(String[] args) {
        //1.读取配置
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3.设置SecurityManager
        SecurityUtils.setSecurityManager(securityManager);

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();

        // 添加会话信息
        Session session = currentUser.getSession();
        session.setAttribute( "someKey", "aValue" );

        // 已认证
        if (currentUser.isAuthenticated()) {
            // 业务处理
            // 获取用户标识
            Object principal = currentUser.getPrincipal();
            // 判断用户是否有某角色
            boolean hasRole = currentUser.hasRole("admin");
            // 判断用户是否有权限
            boolean permitted = currentUser.isPermitted("winnebago:drive:eagle5");
        }
        // 未认证
        else {
            // 业务处理：登录
            // principals和credentials
            UsernamePasswordToken token = new UsernamePasswordToken("userName", "password");
            token.setRememberMe(true);
            // 认证
            try {
                currentUser.login(token);
            } catch (Exception e) {

            }
        }

        // 退出
        currentUser.logout();
    }
}
