package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ExamineeBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamineeMapper {

    @Select("SELECT * FROM pp_examinee WHERE kid = #{examid}")
    ExamineeBean examineeWithExamid(@Param("examid") int examid);

    @Insert({"insert into pp_examinee(user_id, name, sex, age, phone, idcard, create_date) values(#{user_id}, #{name}, #{sex}, #{age}, #{phone}, #{idcard}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertAuditor(ExamineeBean bean);

//    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
//    void updateUser(UserBean person);
}
