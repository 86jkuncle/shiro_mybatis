package com.example.realm;

import com.example.entity.User;
import com.example.services.IUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author Administrator
 * @date 2019/9/16 9:59
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IUser userServices;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();
        String pass = new String((char[])token.getCredentials()) ;

        User user = userServices.queryByName(name);
        if(user == null){
            throw new UnknownAccountException("帐号或密码错误");
        }

        if(!pass.equals(user.getPassword())){
            throw new IncorrectCredentialsException("帐号或密码错误");
        }

        if(0 == user.getStatus()){
            throw new LockedAccountException("帐号被锁定,请联系管理员");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,pass,getName());


        return authenticationInfo;
    }
}
