package com.teach.pojo;

public class ApplyMsg {
    private Integer id;

    private Integer userid;

    private Integer targetid;

    private String name;

    private String phone;

    private String course;

    private String place;

    private String content;

    private String qq;

    private String wechat;

    private String address;

    private Integer role;

    public ApplyMsg(Integer id, Integer userid, Integer targetid, String name, String phone, String course, String place, String content, String qq, String wechat, String address, Integer role) {
        this.id = id;
        this.userid = userid;
        this.targetid = targetid;
        this.name = name;
        this.phone = phone;
        this.course = course;
        this.place = place;
        this.content = content;
        this.qq = qq;
        this.wechat = wechat;
        this.address = address;
        this.role = role;
    }

    public ApplyMsg() {
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

    public Integer getTargetid() {
        return targetid;
    }

    public void setTargetid(Integer targetid) {
        this.targetid = targetid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course == null ? null : course.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}