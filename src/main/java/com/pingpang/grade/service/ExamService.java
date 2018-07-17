package com.pingpang.grade.service;

import com.pingpang.grade.mapper.ExamMapper;
import com.pingpang.grade.mapper.ExamineeMapper;
import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.mapper.VenueMapper;
import com.pingpang.grade.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamMapper examMapper;

    @Autowired
    ExamineeMapper examineeMapper;

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

    public List<ExamBean> examWithUser(String userid) {
        List<ExamBean> examList = examMapper.examWithUser(userid);

        for (ExamBean bean : examList) {
            ExamineeBean examineeBean = examineeMapper.examineeWithExamid(bean.getExaminee_id());
            if (examineeBean != null) {
                List<ImageBean> imageBeans = imageMapper.imageList(3, examineeBean.getKid(), 3);
                if (imageBeans.size() > 0) {
                    examineeBean.setAvatarImage(imageBeans.get(0));
                }

                bean.setExaminee(examineeBean);
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

    public List<ExamBean> uncheckExams() {
        List<ExamBean> examList = examMapper.uncheckExams();

        for (ExamBean bean : examList) {
            ExamineeBean examineeBean = examineeMapper.examineeWithExamid(bean.getExaminee_id());
            if (examineeBean != null) {
                List<ImageBean> imageBeans = imageMapper.imageList(3, examineeBean.getKid(), 3);
                if (imageBeans.size() > 0) {
                    examineeBean.setAvatarImage(imageBeans.get(0));
                }

                bean.setExaminee(examineeBean);
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

    public boolean checkExam(int kid, String userid) {
        int check = examMapper.checkExam(1, userid, kid);
        return check > 0;
    }

}
