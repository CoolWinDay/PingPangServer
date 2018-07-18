package com.pingpang.grade.model;

import com.pingpang.grade.utils.MyDateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamBean {

    private int kid;
    private String user_id;
    private int venue_id;
    private int auditor_id;
    private int examinee_id;
    private String exam_grade;
    private String exam_time;
    private ExamineeBean examinee;
    private VenueBean venue;
    private AuditorBean auditor;
    private String create_date = MyDateUtils.stringWithDate(new Date());
    private int state;

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public int getAuditor_id() {
        return auditor_id;
    }

    public void setAuditor_id(int auditor_id) {
        this.auditor_id = auditor_id;
    }

    public int getExaminee_id() {
        return examinee_id;
    }

    public void setExaminee_id(int examinee_id) {
        this.examinee_id = examinee_id;
    }

    public String getExam_grade() {
        return exam_grade;
    }

    public void setExam_grade(String exam_grade) {
        this.exam_grade = exam_grade;
    }

    public String getExam_time() {
        return exam_time;
    }

    public void setExam_time(String exam_time) {
        this.exam_time = exam_time;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public ExamineeBean getExaminee() {
        return examinee;
    }

    public void setExaminee(ExamineeBean examinee) {
        this.examinee = examinee;
    }

    public VenueBean getVenue() {
        return venue;
    }

    public void setVenue(VenueBean venue) {
        this.venue = venue;
    }

    public AuditorBean getAuditor() {
        return auditor;
    }

    public void setAuditor(AuditorBean auditor) {
        this.auditor = auditor;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
