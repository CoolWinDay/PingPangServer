package com.pingpang.grade.model;

import com.pingpang.grade.utils.MyDateUtils;

import java.util.Date;

public class ExamBean {

    private int kid;
    private String user_id;
    private int venue_id;
    private int auditor_id;
    private int examinee_id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String idcard;
    private String grade;
    private String exam_date;
    private VenueBean venue;
    private AuditorBean auditor;
    private String create_date = MyDateUtils.stringWithDate(new Date());
    private int state;
    private ImageBean avatarImage;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getExam_date() {
        return exam_date;
    }

    public void setExam_date(String exam_date) {
        this.exam_date = exam_date;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public ImageBean getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(ImageBean avatarImage) {
        this.avatarImage = avatarImage;
    }
}
