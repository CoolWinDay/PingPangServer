package com.pingpang.grade.mapper;

import com.pingpang.grade.model.VenueBean;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueMapper {

    @Select("SELECT * FROM pp_venue WHERE state = 1 and province = #{province} and city = #{city} and county = #{county}")
    List<VenueBean> venuesWithCity(@Param("province") String province, @Param("city") String city, @Param("county") String county);

    @Select("SELECT * FROM pp_venue WHERE state = #{state}")
    List<VenueBean> checkVenueWithState(@Param("state") int state);

    @Select("SELECT * FROM pp_venue WHERE kid = #{kid}")
    VenueBean venueWithId(@Param("kid") int kid);

    @Select("SELECT * FROM pp_venue WHERE user_id = #{userid} or kid in (select venue_id from pp_auditor where user_id = #{userid}) or kid in (SELECT venue_id FROM pp_exam WHERE user_id = #{userid})")
    List<VenueBean> myVenueList(@Param("userid") String userid);

    @Insert({"insert into pp_venue(user_id, name, charger, phone, province, city, county, address, introduce, create_date) values(#{user_id}, #{name}, #{charger}, #{phone}, #{province}, #{city}, #{county}, #{address}, #{introduce}, #{create_date})"})
    @Options(useGeneratedKeys = true, keyProperty = "kid", keyColumn = "kid")
    int insertVenue(VenueBean bean);

    @Update({"update pp_venue set state=#{state}, check_user=#{userid} where kid = #{kid}"})
    int checkVenue(@Param("state") int state, @Param("userid") String userid, @Param("kid") int kid);

    @Select("SELECT count(*) FROM pp_venue WHERE state = #{state}")
    int venueCountWithState(@Param("state") int state);

    @Select("SELECT count(*) FROM pp_venue")
    int venueCountAll();
}
