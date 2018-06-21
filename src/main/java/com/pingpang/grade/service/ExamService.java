package com.pingpang.grade.service;

import com.pingpang.grade.mapper.ExamMapper;
import com.pingpang.grade.mapper.ExamineeMapper;
import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.model.ExamBean;
import com.pingpang.grade.model.ExamineeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    @Autowired
    ExamMapper examMapper;

    @Autowired
    ImageMapper imageMapper;

    public int insertExam(ExamBean bean) {
        examMapper.insertExam(bean);
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
