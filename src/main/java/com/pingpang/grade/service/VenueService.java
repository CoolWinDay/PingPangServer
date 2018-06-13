package com.pingpang.grade.service;

import com.pingpang.grade.mapper.UserMapper;
import com.pingpang.grade.mapper.VenueMapper;
import com.pingpang.grade.model.UserBean;
import com.pingpang.grade.model.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    VenueMapper venueMapper;

    public void insertVenue(VenueBean bean) {
        venueMapper.insertVenue(bean);
        int kid = bean.getKid();
    }

}
