package com.mumu.demo.controller;

import com.mumu.demo.common.ResultDto;
import com.mumu.demo.common.ServiceException;
import com.mumu.demo.dto.UserDto;
import com.mumu.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springBootDemo
 * @description:
 * @author: mumu
 * @create: 2021-03-20 20:58
 **/
@Api(tags = "用户管理模块")
@RestController
@RequestMapping("user")
@Slf4j
public class UserContorller {

    @Autowired
    private UserService userService;

    @Value("${hello.key1}")
    private String helloKey1;

    /**
     * 用户登录
     * @param userDto
     * @return
     */
//    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultDto<UserDto> login(@RequestBody UserDto userDto){

        String result = userService.login(userDto);

        if(userDto.getName().contains("error2")){
            throw new NullPointerException();
        }
        if(userDto.getName().contains("error")){
            ServiceException.throwEx("用户名中含有error");
        }
        return ResultDto.success("成功 " + result + " helloKey1= "+ helloKey1,userDto);
    }

    /**
     * 动态url：http://localhost:8080/user/byId/12/1
     * @param userId
     * @return
     */
    @RequestMapping(value = "byId/{userId}/{id}",method = RequestMethod.GET)
    public String getById(@PathVariable("userId") Long userId, @PathVariable("id") Long id){

        System.out.println("userId:" + userId);
        System.out.println("id:" + id);
        return "登录成功" + userId + " ID:" + id;
    }

    /**
     * 非动态url：http://localhost:8080/user/byId/?userId=1&id=23
     * @param userId
     * @param id
     * @return
     */
    @GetMapping("byId")
    public String getById2(@RequestParam(value = "userId",required = false) Long userId, @RequestParam("id") Long id){

        System.out.println("userId:" + userId);
        System.out.println("id:" + id);
        return "登录成功2 " + userId + " ID:" + id;
    }

}
