package com.qianxun.user.consumer.grpc.client;

import com.qianxun.admin.api.dto.sysRole.response.SysRoleResponseDTO;
import com.qianxun.admin.api.dto.extend.SysRoleDTO;
import com.qianxun.common.utils.mapper.ProtoBufUtils;
import com.qianxun.grpc.lib.sysRole.SysRoleOuterClass;
import com.qianxun.grpc.lib.sysRole.SysRoleServiceGrpc;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author Cloudy
 * Date 2019-05-13 19:35:18
 */
@Service
public class GrpcSysRoleClient {
    @GrpcClient("qx-user-provider")
    private Channel serverChannel;

    public SysRoleDTO getSysRoleById(SysRoleOuterClass.ByIdReq getByIdReq) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.SysRole res = stub.getById(getByIdReq);
        return ProtoBufUtils.fromProtoBuffer(res, SysRoleDTO.class);
    }

    public SysRoleResponseDTO getSysRoleList(SysRoleOuterClass.GetListReq getListReq) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.PageList pageList = stub.getList(getListReq);
        return ProtoBufUtils.fromProtoBuffer(pageList, SysRoleResponseDTO.class);
    }

    public Boolean addSysRole(SysRoleOuterClass.BaseSysRole baseSysRole) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.insert(baseSysRole);
        return res.getSuccess();
    }

    public Boolean updateSysRole(SysRoleOuterClass.SysRole role) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.update(role);
        return res.getSuccess();
    }

    public Boolean deleteSysRole(SysRoleOuterClass.ByIdReq req) {
        SysRoleServiceGrpc.SysRoleServiceBlockingStub stub = SysRoleServiceGrpc.newBlockingStub(serverChannel);
        SysRoleOuterClass.Result res = stub.delete(req);
        return res.getSuccess();
    }
}
