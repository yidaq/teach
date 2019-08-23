package com.teach.service;


import com.teach.common.ServerResponse;
import com.teach.pojo.TeacherMsg;
import com.teach.pojo.User;

public interface ITeacherMsgService {

    ServerResponse getTeacherMsgInfo(User user);
    ServerResponse getTeacherMsgList();
    ServerResponse insertTeacherMsg(TeacherMsg teacherMsg, User user);
    ServerResponse updateTeacherMsg(TeacherMsg teacherMsg);
    ServerResponse deleteTeacherMsg(Integer id);
    ServerResponse updateTeacherMsgStatus(Integer id, Integer status);
    ServerResponse getTeacherMsgListByCourse(String course);
    ServerResponse getTeacherMsgListByStatus(Integer status);

    ServerResponse<TeacherMsg> getTeacherMsgByUserid(Integer id);

    ServerResponse getTeacherMsgById(Integer id);
}
