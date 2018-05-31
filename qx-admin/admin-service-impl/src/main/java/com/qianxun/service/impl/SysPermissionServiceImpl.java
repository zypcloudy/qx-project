package com.qianxun.service.impl;

import com.qianxun.entity.SysPermission;
import com.qianxun.mapper.SysPermissionMapper;
import com.qianxun.service.ISysPermissionService;
import com.qianxun.utils.spring.SpringContextHolderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements ISysPermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;

    @Override
    public List<SysPermission> getPermissionsByUserId(Integer id) {
        return permissionMapper.findPermissionsByUserId(id);
    }
}