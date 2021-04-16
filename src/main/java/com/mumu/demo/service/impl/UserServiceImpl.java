package com.mumu.demo.service.impl;

import com.mumu.demo.dto.UserDto;
import com.mumu.demo.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: springBootDemo
 * @description:
 * @author: mumu
 * @create: 2021-03-21 21:07
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(UserDto userDto) {
        System.out.println("userDto.getName():" + userDto.getName());
        System.out.println("userDto.getPwd():" + userDto.getPwd());
        return "登录成功 " + userDto.getName() + "+" +userDto.getPwd();
    }
}
