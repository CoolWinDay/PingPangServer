package com.pingpang.grade.model;

import com.pingpang.grade.utils.MyDateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditorBean implements Serializable {

    private int kid;
    private String user_id;
    private int venue_id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String idcard;
    private String introduce;
    private String create_date = MyDateUtils.stringWithDate(new Date());

    private List<ImageBean> certificateImage = new ArrayList<>();
    private ImageBean avatarImage;
    private VenueBean venue;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public List<ImageBean> getCertificateImage() {
        return certificateImage;
    }

    public void setCertificateImage(List<ImageBean> certificateImage) {
        this.certificateImage = certificateImage;
    }

    public ImageBean getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(ImageBean avatarImage) {
        this.avatarImage = avatarImage;
    }

    public VenueBean getVenue() {
        return venue;
    }

    public void setVenue(VenueBean venue) {
        this.venue = venue;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
