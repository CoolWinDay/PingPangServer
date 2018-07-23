package com.pingpang.grade.model;

public class StatisticsBean {

    private int venueCountAll = 0;
    private int venueCountChecked = 0;
    private int venueCountUncheck = 0;

    private int auditorCountAll = 0;
    private int auditorCountChecked = 0;
    private int auditorCountUncheck = 0;

    private int examCountAll = 0;
    private int examCountWaiting = 0;
    private int examCountPassed = 0;
    private int examCountUnpass = 0;

    public int getVenueCountAll() {
        return venueCountAll;
    }

    public void setVenueCountAll(int venueCountAll) {
        this.venueCountAll = venueCountAll;
    }

    public int getVenueCountChecked() {
        return venueCountChecked;
    }

    public void setVenueCountChecked(int venueCountChecked) {
        this.venueCountChecked = venueCountChecked;
    }

    public int getVenueCountUncheck() {
        return venueCountUncheck;
    }

    public void setVenueCountUncheck(int venueCountUncheck) {
        this.venueCountUncheck = venueCountUncheck;
    }

    public int getAuditorCountAll() {
        return auditorCountAll;
    }

    public void setAuditorCountAll(int auditorCountAll) {
        this.auditorCountAll = auditorCountAll;
    }

    public int getAuditorCountChecked() {
        return auditorCountChecked;
    }

    public void setAuditorCountChecked(int auditorCountChecked) {
        this.auditorCountChecked = auditorCountChecked;
    }

    public int getAuditorCountUncheck() {
        return auditorCountUncheck;
    }

    public void setAuditorCountUncheck(int auditorCountUncheck) {
        this.auditorCountUncheck = auditorCountUncheck;
    }

    public int getExamCountAll() {
        return examCountAll;
    }

    public void setExamCountAll(int examCountAll) {
        this.examCountAll = examCountAll;
    }

    public int getExamCountWaiting() {
        return examCountWaiting;
    }

    public void setExamCountWaiting(int examCountWaiting) {
        this.examCountWaiting = examCountWaiting;
    }

    public int getExamCountPassed() {
        return examCountPassed;
    }

    public void setExamCountPassed(int examCountPassed) {
        this.examCountPassed = examCountPassed;
    }

    public int getExamCountUnpass() {
        return examCountUnpass;
    }

    public void setExamCountUnpass(int examCountUnpass) {
        this.examCountUnpass = examCountUnpass;
    }
}
