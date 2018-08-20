package com.stone.learn.shirolearn.chapter01;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class LoginLogoutWithCustomerRealmTest {

    public static void main(String[] args) {
        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:ini/shiro-realm.ini");
        SecurityManager sm = securityManagerFactory.getInstance();

        SecurityUtils.setSecurityManager(sm);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhqqang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println("user logined ?" + subject.isAuthenticated());

        subject.logout();

        System.out.println("user logined ?" + subject.isAuthenticated());
    }
}
