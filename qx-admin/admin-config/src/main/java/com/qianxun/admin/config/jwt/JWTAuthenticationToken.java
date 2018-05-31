package com.qianxun.admin.config.jwt;

import com.qianxun.entity.SysPermission;
import com.qianxun.entity.SysUser;
import com.qianxun.service.ISysPermissionService;
import com.qianxun.service.impl.SysPermissionServiceImpl;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JWTAuthenticationToken extends AbstractAuthenticationToken {

    private Collection<GrantedAuthority> authorities;

    private final Object credentials;

    private final Object principal;

    public JWTAuthenticationToken(String token) {
        super(null);
        this.credentials = token;
        this.principal = null;
        setAuthenticated(false);
    }

    public JWTAuthenticationToken(SysUser user) {
        super(null);
        this.credentials = user.getCurrentToken();
        this.principal = user;
        ISysPermissionService permissionService = ISysPermissionService.me();
        List<SysPermission> permissions = permissionService.getPermissionsByUserId(user.getId());
        authorities = new ArrayList<GrantedAuthority>();
        Iterator<SysPermission> it = permissions.iterator();
        while (it.hasNext()) {
            authorities.add(new SimpleGrantedAuthority(it.next().getKey()));
        }
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }
}