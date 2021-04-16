package com.mumu.demo.service;

import com.mumu.demo.dto.UserDto;

/**
 * @program: springBootDemo
 * @description:
 * @author: mumu
 * @create: 2021-03-21 21:06
 **/
public interface UserService {
    public String login(UserDto userDto);
}
