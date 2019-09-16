package com.example.services;

import com.example.entity.User;

/**
 * @author Administrator
 * @date 2019/9/16 10:15
 */
public interface IUser {
    User queryByName(String name);
}
