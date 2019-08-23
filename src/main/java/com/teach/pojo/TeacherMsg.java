package com.teach.pojo;

public class TeacherMsg {
    private Integer id;

    private Integer userid;

    private String imagepath;

    private String name;

    private String idcard;

    private String phone;

    private String education;

    private String school;

    private String course;

    private String videopath;

    private String time;

    private Integer pay;

    private Integer status;

    public TeacherMsg(Integer id, Integer userid, String imagepath, String name, String idcard, String phone, String education, String school, String course, String videopath, String time, Integer pay, Integer status) {
        this.id = id;
        this.userid = userid;
        this.imagepath = imagepath;
        this.name = name;
        this.idcard = idcard;
        this.phone = phone;
        this.education = education;
        this.school = school;
        this.course = course;
        this.videopath = videopath;
        this.time = time;
        this.pay = pay;
        this.status = status;
    }

    public TeacherMsg() {
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

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public String getVideopath() {
        return videopath;
    }

    public void setVideopath(String videopath) {
        this.videopath = videopath == null ? null : videopath.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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