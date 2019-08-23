package com.teach.common;


public class Const {

    public static final String CURRENT_USER = "currentUser";
    public static final String CURRENT_ADMIN = "currentAdmin";
    public static final String USERNAME = "username";


    public interface Role{
        int ROLE_STUDENT = 0; //家长用户
        int ROLE_TEACHER = 1;//老师用户
    }


}
