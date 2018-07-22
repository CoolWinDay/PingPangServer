package com.pingpang.grade.service;

import com.pingpang.grade.mapper.ExamMapper;
import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.model.AuditorBean;
import com.pingpang.grade.model.ExamBean;
import com.pingpang.grade.model.ImageBean;
import com.pingpang.grade.model.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamMapper examMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    VenueService venueService;

    @Autowired
    AuditorService auditorService;

    public int insertExam(ExamBean bean) {
        examMapper.insertExam(bean);
        return bean.getKid();
    }

    public List<ExamBean> myExamList(boolean isChecked, String userid) {
        List<ExamBean> examList;
        if (isChecked) {
            examList = examMapper.myCheckedExamList(userid);
        }
        else {
            examList = examMapper.myUncheckExamList(userid);
        }

        for (ExamBean bean : examList) {
            List<ImageBean> imageBeans = imageMapper.imageList(3, bean.getKid(), 3);
            if (imageBeans.size() > 0) {
                bean.setAvatarImage(imageBeans.get(0));
            }

            VenueBean venueBean = venueService.venueWithId(bean.getVenue_id());
            if (venueBean != null) {
                bean.setVenue(venueBean);
            }

            AuditorBean auditorBean = auditorService.auditorWithId(bean.getAuditor_id());
            if (auditorBean != null) {
                bean.setAuditor(auditorBean);
            }

        }

        return examList;
    }

    public List<ExamBean> checkExamsWithState(int state) {
        List<ExamBean> examList = examMapper.checkExamsWithState(state);

        for (ExamBean bean : examList) {
            List<ImageBean> imageBeans = imageMapper.imageList(3, bean.getKid(), 3);
            if (imageBeans.size() > 0) {
                bean.setAvatarImage(imageBeans.get(0));
            }

            VenueBean venueBean = venueService.venueWithId(bean.getVenue_id());
            if (venueBean != null) {
                bean.setVenue(venueBean);
            }

            AuditorBean auditorBean = auditorService.auditorWithId(bean.getAuditor_id());
            if (auditorBean != null) {
                bean.setAuditor(auditorBean);
            }

        }

        return examList;
    }

    public boolean checkExam(int state, int kid, String userid) {
        int check = examMapper.checkExam(state, userid, kid);
        return check > 0;
    }

}
