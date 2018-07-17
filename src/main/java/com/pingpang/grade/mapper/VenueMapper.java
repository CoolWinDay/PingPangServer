package com.pingpang.grade.mapper;

import com.pingpang.grade.model.VenueBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueMapper {

    @Select("SELECT * FROM pp_venue WHERE state = 1 and province = #{province} and city = #{city} and county = #{county}")
    List<VenueBean> venuesWithCity(@Param("province") String province, @Param("city") String city, @Param("county") String county);

    @Select("SELECT * FROM pp_venue WHERE state = 0")
    List<VenueBean> uncheckVenues();

    @Select("SELECT * FROM pp_venue WHERE user_id = #{userid}")
    List<VenueBean> venuesWithUser(@Param("userid") String userid);

    @Select("SELECT * FROM pp_venue WHERE kid = #{kid}")
    VenueBean venueWithId(@Param("kid") int kid);

    @Insert({"insert into pp_venue(user_id, name, charger, phone, province, city, county, address, introduce, create_date) values(#{user_id}, #{name}, #{charger}, #{phone}, #{province}, #{city}, #{county}, #{address}, #{introduce}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertVenue(VenueBean bean);

    @Update({"update pp_venue set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkVenue(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);
}
