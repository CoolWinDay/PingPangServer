package com.pingpang.grade.mapper;

import com.pingpang.grade.model.VenueBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueMapper {

    @Select("SELECT * FROM pp_venue WHERE province = #{province} and city = #{city} and county = #{county}")
    List<VenueBean> venuesWithCity(@Param("province") String province, @Param("city") String city, @Param("county") String county);

    @Select("SELECT * FROM pp_venue WHERE user_id = #{userid}")
    List<VenueBean> venuesWithUser(@Param("userid") String userid);

    @Select("SELECT * FROM pp_venue WHERE kid = #{kid}")
    VenueBean venueWithId(@Param("kid") int kid);

    @Insert({"insert into pp_venue(user_id, name, charger, phone, province, city, county, address, introduce, create_date) values(#{user_id}, #{name}, #{charger}, #{phone}, #{province}, #{city}, #{county}, #{address}, #{introduce}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertVenue(VenueBean bean);

//    @Update({"update pp_user set user_name=#{user_name}, login_token=#{login_token}, login_time=#{login_time} where user_id=#{user_id}"})
//    void updateUser(UserBean person);
}
