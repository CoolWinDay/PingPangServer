package com.pingpang.grade.service;

import com.pingpang.grade.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

//    public Person selectUser(int id) {
//        return userMapper.selectUser(id);
//    }

}
