package com.teach.pojo;



public class File {
    int id;
    int sid;
    int tid;
    String filepath;
    String name;
    int type;

    public File() {
    }

    public File(int id, int sid, int tid, String filepath, String name, int type) {
        this.id = id;
        this.sid = sid;
        this.tid = tid;
        this.filepath = filepath;
        this.name = name;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
