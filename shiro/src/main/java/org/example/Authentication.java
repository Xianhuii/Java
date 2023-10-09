package org.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class Authentication {
    public static void main(String[] args) {
        // principals和credentials
        UsernamePasswordToken token = new UsernamePasswordToken("userName", "password");
        token.setRememberMe(true);

        // 认证
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        // 退出
        subject.logout();
    }
}