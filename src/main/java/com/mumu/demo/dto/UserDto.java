package com.mumu.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: springBootDemo
 * @description:
 * @author: mumu
 * @create: 2021-03-20 22:30
 **/
@ApiModel(value = "用户登录类", description = "请求类")
@Data
public class UserDto {
    @ApiModelProperty(value="用户名", example="hogwarts",required=true)
    private String name;
    @ApiModelProperty(value="用户密码", example="hogwarts",required=true)
    private String pwd;





}
