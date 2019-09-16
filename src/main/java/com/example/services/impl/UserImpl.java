package com.example.services.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.services.IUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2019/9/16 10:16
 */
@Service("userServices")
public class UserImpl implements IUser {
    @Resource
    private UserMapper userMapper;
    @Override
    public User queryByName(String name) {
        return userMapper.findByName(name);
    }
}
