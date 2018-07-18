package com.pingpang.grade.service;

import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.mapper.UserMapper;
import com.pingpang.grade.mapper.VenueMapper;
import com.pingpang.grade.model.ImageBean;
import com.pingpang.grade.model.UserBean;
import com.pingpang.grade.model.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class VenueService {

    @Autowired
    VenueMapper venueMapper;

    @Autowired
    ImageMapper imageMapper;

    public int insertVenue(VenueBean bean) {
        venueMapper.insertVenue(bean);
        return bean.getKid();
    }

    public List<VenueBean> venuesWithCity(String province, String city, String county) {
        List<VenueBean> venueList = venueMapper.venuesWithCity(province, city, county);

        for (VenueBean bean : venueList) {
            List<ImageBean> images = imageMapper.imageList(1, bean.getKid(), 1);
            bean.getVenueImage().clear();
            bean.getVenueImage().addAll(images);
        }

        return venueList;
    }

    public List<VenueBean> checkVenueWithState(int state) {
        List<VenueBean> venueList = venueMapper.checkVenueWithState(state);

        for (VenueBean bean : venueList) {
            List<ImageBean> images = imageMapper.imageList(1, bean.getKid(), 1);
            bean.getVenueImage().clear();
            bean.getVenueImage().addAll(images);
        }

        return venueList;
    }

    public boolean checkVenue(int kid, String userid) {
        int check = venueMapper.checkVenue(1, userid, kid);
        return check > 0;
    }

    public List<VenueBean> venuesWithUser(String userid) {
        List<VenueBean> venueList = venueMapper.venuesWithUser(userid);

        for (VenueBean bean : venueList) {
            List<ImageBean> images = imageMapper.imageList(1, bean.getKid(), 1);
            bean.getVenueImage().clear();
            bean.getVenueImage().addAll(images);
        }

        return venueList;
    }

    public VenueBean venueWithId(int kid) {
        VenueBean venueBean = venueMapper.venueWithId(kid);
        return venueBean;
    }

}
