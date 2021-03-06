package com.pingpang.grade.mapper;

import com.pingpang.grade.model.AuditorBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditorMapper {

    @Select("SELECT * FROM pp_auditor WHERE state = 1 and venue_id = #{venueid}")
    List<AuditorBean> auditorWithVenue(@Param("venueid") String venueid);

    @Select("SELECT * FROM pp_auditor WHERE state = #{state}")
    List<AuditorBean> checkAuditorWithState(@Param("state") int state);

    @Select("SELECT * FROM pp_auditor WHERE user_id = #{userid} or venue_id in (SELECT kid FROM pp_venue WHERE user_id = #{userid}) or kid in (SELECT auditor_id FROM pp_exam WHERE user_id = #{userid})")
    List<AuditorBean> myAuditorList(@Param("userid") String userid);

    @Select("select a.*, (select count(*) from pp_exam where auditor_id = a.kid) examcount from pp_auditor as a order by examcount desc limit 5")
    List<AuditorBean> topAuditorList();

    @Select("SELECT * FROM pp_auditor WHERE kid = #{kid}")
    AuditorBean auditorWithId(@Param("kid") int kid);

    @Insert({"insert into pp_auditor(user_id, venue_id, name, sex, age, phone, idcard, introduce, create_date) values(#{user_id}, #{venue_id}, #{name}, #{sex}, #{age}, #{phone}, #{idcard}, #{introduce}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertAuditor(AuditorBean bean);

    @Update({"update pp_auditor set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkAuditor(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);

    @Select("SELECT count(*) FROM pp_auditor WHERE state = #{state}")
    int auditorCountWithState(@Param("state") int state);

    @Select("SELECT count(*) FROM pp_auditor")
    int auditorCountAll();
}
