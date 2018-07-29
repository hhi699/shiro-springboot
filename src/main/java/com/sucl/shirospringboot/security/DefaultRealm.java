package com.sucl.shirospringboot.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(DefaultRealm.class);

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    //    this.getAuthenticationTokenClass();
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        logger.info("用户{}认证",username);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,"123456",this.getName());
        return authenticationInfo;
    }
}
