package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ExamBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMapper {

    @Select("SELECT * FROM pp_exam WHERE state = #{state} and (user_id = #{userid} or venue_id in (SELECT kid FROM pp_venue WHERE user_id = #{userid}) or auditor_id in (SELECT kid FROM pp_auditor WHERE user_id = #{userid}))")
    List<ExamBean> myExamList(@Param("state") int state, @Param("userid") String userid);

    @Select("SELECT * FROM pp_exam WHERE state != 0 and (user_id = #{userid} or venue_id in (SELECT kid FROM pp_venue WHERE user_id = #{userid}) or auditor_id in (SELECT kid FROM pp_auditor WHERE user_id = #{userid}))")
    List<ExamBean> myCheckedExamList( @Param("userid") String userid);

    @Select("SELECT * FROM pp_exam WHERE state = 0 and (user_id = #{userid} or venue_id in (SELECT kid FROM pp_venue WHERE user_id = #{userid}) or auditor_id in (SELECT kid FROM pp_auditor WHERE user_id = #{userid}))")
    List<ExamBean> myUncheckExamList(@Param("userid") String userid);

    @Select("SELECT * FROM pp_exam WHERE state = #{state}")
    List<ExamBean> checkExamsWithState(@Param("state") int state);

    @Insert({"insert into pp_exam(user_id, venue_id, auditor_id, name, sex, age, phone, idcard, grade, exam_date, create_date) values(#{user_id}, #{venue_id}, #{auditor_id}, #{name}, #{sex}, #{age}, #{phone}, #{idcard}, #{grade}, #{exam_date}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertExam(ExamBean bean);

    @Update({"update pp_exam set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkExam(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);

    @Select("SELECT count(*) FROM pp_exam WHERE state = #{state}")
    int examCountWithState(@Param("state") int state);

    @Select("SELECT count(*) FROM pp_exam")
    int examCountAll();
}
