package com.teach.service;

import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.Eval;
import com.teach.pojo.File;
import com.teach.pojo.User;

import java.util.List;


public interface IUserService {

    ServerResponse<User> login(String phone, String password);
    ServerResponse<String> register(User user);
    ServerResponse getList();
    ServerResponse getStudentList();
    ServerResponse getTeacherList();
    ServerResponse<Admin> adminLogin(String username, String password);
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getUserInfo(Integer id);
    ServerResponse<User> getUserInfoByPhone(String phone);
    ServerResponse uploadFile(File file);

    ServerResponse getFileBystid(Integer id, Integer tid);

    ServerResponse addEval(Eval eval);

    ServerResponse<List> getEval(Integer id, Integer tid);
}
