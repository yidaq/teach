package com.teach.pojo;



public class Eval {
    Integer id;
    Integer userid;
    Integer targetid;
    Integer role;
    String content;

    public Eval() {
    }

    public Eval(Integer id, Integer userid, Integer targetid, Integer role, String content) {
        this.id = id;
        this.userid = userid;
        this.targetid = targetid;
        this.role = role;
        this.content = content;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

