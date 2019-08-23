package com.teach.service;


import com.teach.common.ServerResponse;
import com.teach.pojo.StudentMsg;
import com.teach.pojo.User;

public interface IStudentMsgService {

    ServerResponse<StudentMsg> getStudentMsgInfo(User user);
    ServerResponse insertStudentMsg(StudentMsg studentMsg, User user);
    ServerResponse getStudentMsgList();
    ServerResponse updateStudentMsg(StudentMsg studentMsg);
    ServerResponse deleteStudentMsg(Integer id);
    ServerResponse updateStudentMsgStatus(Integer id, Integer status);
    ServerResponse getStudentMsgListByCourse(String course);
    ServerResponse getStudentMsgListByStatus(Integer status);
    ServerResponse getStudentMsgListByPlace(String place);
    ServerResponse getStudentMsgByUserid(Integer id);

    ServerResponse getStudentMsgById(Integer id);
}
