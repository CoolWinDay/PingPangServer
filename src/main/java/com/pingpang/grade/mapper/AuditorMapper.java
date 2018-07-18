package com.pingpang.grade.mapper;

import com.pingpang.grade.model.AuditorBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditorMapper {

    @Select("SELECT * FROM pp_auditor WHERE venue_id = #{venueid}")
    List<AuditorBean> auditorWithVenue(@Param("venueid") String venueid);

    @Select("SELECT * FROM pp_auditor WHERE state = #{state}")
    List<AuditorBean> checkAuditorWithState(@Param("state") int state);

    @Select("SELECT * FROM pp_auditor WHERE user_id = #{userid}")
    List<AuditorBean> auditorWithUser(@Param("userid") String userid);

    @Select("SELECT * FROM pp_auditor WHERE kid = #{kid}")
    AuditorBean auditorWithId(@Param("kid") int kid);

    @Insert({"insert into pp_auditor(user_id, venue_id, name, sex, age, phone, idcard, introduce, create_date) values(#{user_id}, #{venue_id}, #{name}, #{sex}, #{age}, #{phone}, #{idcard}, #{introduce}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertAuditor(AuditorBean bean);

    @Update({"update pp_auditor set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkAuditor(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);
}
