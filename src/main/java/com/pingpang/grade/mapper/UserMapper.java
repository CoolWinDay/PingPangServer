package com.pingpang.grade.mapper;

import com.pingpang.grade.model.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    @Select("SELECT * FROM pp_user WHERE user_id = #{id}")
    UserBean selectUser(String id);

    @Select("SELECT * FROM pp_user WHERE login_token = #{token}")
    UserBean selectUserWithToken(String token);

    @Insert({"insert into pp_user(user_id, user_name, login_token, login_time) values(#{user_id}, #{user_name}, #{login_token}, #{login_time})"})
    int insertUser(UserBean person);

    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
    void updateUser(UserBean person);
}
