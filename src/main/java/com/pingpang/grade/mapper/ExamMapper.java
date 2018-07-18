package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ExamBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMapper {

    @Select("SELECT * FROM pp_exam WHERE user_id = #{userid}")
    List<ExamBean> examWithUser(@Param("userid") String userid);

    @Select("SELECT * FROM pp_exam WHERE state = #{state}")
    List<ExamBean> checkExamsWithState(@Param("state") int state);

    @Insert({"insert into pp_exam(user_id, venue_id, auditor_id, examinee_id, exam_grade, exam_time, create_date) values(#{user_id}, #{venue_id}, #{auditor_id}, #{examinee_id}, #{exam_grade}, #{exam_time}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertExam(ExamBean bean);

    @Update({"update pp_exam set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkExam(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);
}
