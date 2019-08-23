package com.teach.pojo;

public class StudentMsg {
    private Integer id;

    private Integer userid;

    private String idcard;

    private String education;

    private String course;

    private String time;

    private String place;

    private Integer pay;

    private Integer status;

    public StudentMsg(Integer id, Integer userid, String idcard, String education, String course, String time, String place, Integer pay, Integer status) {
        this.id = id;
        this.userid = userid;
        this.idcard = idcard;
        this.education = education;
        this.course = course;
        this.time = time;
        this.place = place;
        this.pay = pay;
        this.status = status;
    }

    public StudentMsg() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}