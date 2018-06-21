package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ExamBean;
import com.pingpang.grade.model.ExamineeBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMapper {

//    @Select("SELECT * FROM pp_auditor WHERE venue_id = #{venueid}")
//    List<AuditorBean> auditorWithVenue(@Param("venueid") String venueid);

    @Insert({"insert into pp_exam(user_id, venue_id, auditor_id, examinee_id, exam_grade, exam_time, create_date) values(#{user_id}, #{venue_id}, #{auditor_id}, #{examinee_id}, #{exam_grade}, #{exam_time}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertExam(ExamBean bean);

//    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
//    void updateUser(UserBean person);
}
