package com.teach.pojo;

public class ComplainMsg {
    private Integer id;

    private String content;

    private Integer userid;

    private Integer role;

    public ComplainMsg(Integer id, String content, Integer userid, Integer role) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.role = role;
    }

    public ComplainMsg() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}