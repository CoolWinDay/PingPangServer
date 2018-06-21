package com.pingpang.grade.service;

import com.pingpang.grade.mapper.AuditorMapper;
import com.pingpang.grade.mapper.ExamineeMapper;
import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.model.AuditorBean;
import com.pingpang.grade.model.ExamineeBean;
import com.pingpang.grade.model.ImageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamineeService {

    @Autowired
    ExamineeMapper examineeMapper;

    @Autowired
    ImageMapper imageMapper;

    public int insertExaminee(ExamineeBean bean) {
        examineeMapper.insertAuditor(bean);
        return bean.getKid();
    }

//    public List<AuditorBean> auditorWithVenue(String venueid) {
//        List<AuditorBean> auditorList = auditorMapper.auditorWithVenue(venueid);
//
//        for (AuditorBean bean : auditorList) {
//            List<ImageBean> avatarImage = imageMapper.imageList(2, bean.getKid(), 3);
//            if (avatarImage.size() > 0) {
//                bean.setAvatarImage(avatarImage.get(0));
//            }
//        }
//
//        return auditorList;
//    }

}
