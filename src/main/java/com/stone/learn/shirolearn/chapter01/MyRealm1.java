package com.stone.learn.shirolearn.chapter01;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm {

    @Override
    public String getName() {
        return "MyRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        String password = String.valueOf((char[])token.getCredentials());

        if (!"zhang".equals(principal)) {
            throw new UnknownAccountException();
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(principal, password, getName());
    }
}
