package com.pingpang.grade.mapper;

import com.pingpang.grade.model.UserBean;
import com.pingpang.grade.model.VenueBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueMapper {


//    @Select("SELECT * FROM pp_user WHERE user_id = #{id}")
//    UserBean selectUser(String id);

    @Insert({"insert into pp_venue(name, charger, phone, city, address, introduce) values(#{name}, #{charger}, #{phone}, #{city}, #{address}, #{introduce})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertVenue(VenueBean bean);

//    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
//    void updateUser(UserBean person);
}
