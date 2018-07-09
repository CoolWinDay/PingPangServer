package com.pingpang.grade.service;

import com.pingpang.grade.mapper.AuditorMapper;
import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.mapper.VenueMapper;
import com.pingpang.grade.model.AuditorBean;
import com.pingpang.grade.model.ImageBean;
import com.pingpang.grade.model.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditorService {

    @Autowired
    AuditorMapper auditorMapper;

    @Autowired
    ImageMapper imageMapper;

    public int insertAuditor(AuditorBean bean) {
        auditorMapper.insertAuditor(bean);
        return bean.getKid();
    }

    public List<AuditorBean> auditorWithVenue(String venueid) {
        List<AuditorBean> auditorList = auditorMapper.auditorWithVenue(venueid);

        for (AuditorBean bean : auditorList) {
            List<ImageBean> avatarImage = imageMapper.imageList(2, bean.getKid(), 3);
            if (avatarImage.size() > 0) {
                bean.setAvatarImage(avatarImage.get(0));
            }
        }

        return auditorList;
    }

    public List<AuditorBean> uncheckAuditorWithVenue() {
        List<AuditorBean> auditorList = auditorMapper.uncheckAuditorWithVenue();

        for (AuditorBean bean : auditorList) {
            List<ImageBean> avatarImage = imageMapper.imageList(2, bean.getKid(), 3);
            if (avatarImage.size() > 0) {
                bean.setAvatarImage(avatarImage.get(0));
            }
        }

        return auditorList;
    }

    public List<AuditorBean> auditorWithUser(String userid) {
        List<AuditorBean> auditorList = auditorMapper.auditorWithUser(userid);

        for (AuditorBean bean : auditorList) {
            List<ImageBean> avatarImage = imageMapper.imageList(2, bean.getKid(), 3);
            if (avatarImage.size() > 0) {
                bean.setAvatarImage(avatarImage.get(0));
            }
        }

        return auditorList;
    }

    public AuditorBean auditorWithId(int kid) {
        AuditorBean auditorBean = auditorMapper.auditorWithId(kid);
        return auditorBean;
    }

}
