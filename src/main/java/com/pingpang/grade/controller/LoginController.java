package com.pingpang.grade.controller;

import com.alibaba.fastjson.JSONObject;
import com.pingpang.grade.model.ResponseBean;
import com.pingpang.grade.model.UserBean;
import com.pingpang.grade.service.LoginService;
import com.pingpang.grade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JSONObject loginUser(String username, String password) {
        ResponseBean<UserBean> response = new ResponseBean<>();

        JSONObject jsonObject = loginService.loginUserFromServer(username, password);

        String errCode = Optional.ofNullable(jsonObject)
                .map(json -> json.getJSONObject("head"))
                .map(head -> head.getString("errCode"))
                .orElse("00000001");

        if (errCode.equals("00000000")) {
            // 登录成功
            String token = jsonObject.getString("token");
            String uid = jsonObject.getString("uid");
            String uname = jsonObject.getString("userName");
            String groupid = jsonObject.getString("groupid");
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = formater.format(new Date());

            UserBean user = new UserBean();
            user.setUser_id(uid);
            user.setUser_name(uname);
            user.setLogin_token(token);
            user.setLogin_time(dateStr);
            user.setGroupid(groupid);

            // 更新user token
            loginService.updateUser(user);
            UserBean userBean = userService.userWithToken(token);

            jsonObject.put("role", userBean.getRole());
            jsonObject.put("grade", userBean.getGrade());

//            response.setData(user);
        }
//        else {
//            String errInfo = Optional.ofNullable(jsonObject)
//                    .map(json -> json.getJSONObject("head"))
//                    .map(head -> head.getString("errInfo"))
//                    .orElse("登录失败");
//            response.setErrorCode(errCode);
//            response.setErrorInfo(errInfo);
//        }

        return jsonObject;
    }
}
