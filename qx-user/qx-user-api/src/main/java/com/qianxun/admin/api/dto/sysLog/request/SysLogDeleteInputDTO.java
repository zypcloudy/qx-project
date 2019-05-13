package com.qianxun.admin.api.dto.sysLog.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Cloudy
 * Date 2019-05-13 17:03:04
 */
@Data
public class SysLogDeleteInputDTO implements Serializable {
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
