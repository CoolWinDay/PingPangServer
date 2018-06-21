package com.pingpang.grade.model;

import com.pingpang.grade.utils.MyDateUtils;

import java.util.Date;

public class ExamineeBean {

    private int kid;
    private String user_id;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private String idcard;
    private String create_date = MyDateUtils.stringWithDate(new Date());

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
