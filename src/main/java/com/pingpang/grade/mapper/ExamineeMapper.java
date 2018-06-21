package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ExamineeBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamineeMapper {

//    @Select("SELECT * FROM pp_auditor WHERE venue_id = #{venueid}")
//    List<AuditorBean> auditorWithVenue(@Param("venueid") String venueid);

    @Insert({"insert into pp_examinee(user_id, name, sex, age, phone, idcard, create_date) values(#{user_id}, #{name}, #{sex}, #{age}, #{phone}, #{idcard}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertAuditor(ExamineeBean bean);

//    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
//    void updateUser(UserBean person);
}
