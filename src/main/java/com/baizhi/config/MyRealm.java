package com.baizhi.config;


import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {

    @Resource
    AdminMapper adminMapper;

    @Override    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    @Override   //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String)authenticationToken.getPrincipal();
        Admin admin1 = new Admin();
        admin1.setName(principal);
        Admin admin = adminMapper.selectOne(admin1);

        if (admin!=null){
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(admin.getName(),admin.getPassword(),ByteSource.Util.bytes("ABCD"),this.getName());
            return  authenticationInfo;
        }
        return null;
    }
}
