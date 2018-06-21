package com.pingpang.grade.service;

import com.pingpang.grade.mapper.UserMapper;
import com.pingpang.grade.model.UserBean;
import com.pingpang.grade.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

//    public Person selectUser(int id) {
//        return userMapper.selectUser(id);
//    }

    public UserBean userWithToken(String token) {
        if (StringUtils.isNotEmpty(token)) {
            return userMapper.selectUserWithToken(token);
        }
        return null;
    }


}
