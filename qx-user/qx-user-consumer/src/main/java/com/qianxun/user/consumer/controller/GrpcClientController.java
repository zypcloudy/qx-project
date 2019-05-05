package com.qianxun.user.consumer.controller;

import com.qianxun.admin.api.entity.SysDept;
import com.qianxun.user.consumer.service.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Cloudy
 * Date: 2019/4/27 20:31
 */
@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "LinShen") String name) {
        return grpcClientService.sendMessage(name);
    }

    @RequestMapping(value = "/{id}")
    public SysDept getDeptId(@PathVariable("id") int id) {
        return grpcClientService.getDeptById(id);
    }

    @RequestMapping(value = "/dept")
    public List<SysDept> getDeptList() {
        return grpcClientService.getDeptList();
    }
}