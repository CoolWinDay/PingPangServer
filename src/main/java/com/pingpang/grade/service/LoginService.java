package com.pingpang.grade.service;

import com.alibaba.fastjson.JSONObject;
import com.pingpang.grade.mapper.UserMapper;
import com.pingpang.grade.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    public JSONObject loginUserFromServer(String username, String password) {
        String requestUrl = "http://www.pingpangwang.com/mobcent/app/web/index.php?r=user/login&password={password}&username={username}";

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        RestTemplate restTemplate = new RestTemplate();
        String responseEntity = restTemplate.getForObject(requestUrl, String.class, params);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity);

        return jsonObject;
    }

    public UserBean loginUser(String username, String password) {
        JSONObject jsonObject = loginUserFromServer(username, password);

        String errCode = Optional.ofNullable(jsonObject)
                .map(json -> json.getJSONObject("head"))
                .map(head -> head.getString("errCode"))
                .orElse("");

        if (errCode.equals("00000000")) {
            // 登录成功
            String token = jsonObject.getString("token");
            String uid = jsonObject.getString("uid");
            String uname = jsonObject.getString("userName");
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = formater.format(new Date());

            UserBean user = new UserBean();
            user.setUser_id(uid);
            user.setUser_name(uname);
            user.setLogin_token(token);
            user.setLogin_time(dateStr);

            return user;
        }

        return null;
    }

    public void updateUser(UserBean user) {
        UserBean bean = userMapper.selectUser(user.getUser_id());
        if (bean == null) {
            userMapper.insertUser(user);
        }
        else {
            userMapper.updateUser(user);
        }
    }
}
