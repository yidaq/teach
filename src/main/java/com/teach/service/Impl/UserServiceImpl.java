package com.teach.service.Impl;

import com.teach.common.ServerResponse;
import com.teach.dao.AdminMapper;
import com.teach.dao.UserMapper;
import com.teach.pojo.Admin;
import com.teach.pojo.Eval;
import com.teach.pojo.File;
import com.teach.pojo.User;
import com.teach.service.IUserService;
import com.teach.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    public ServerResponse<User> login(String phone, String password) {
        int resultCount = userMapper.checkUsername(phone);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String MD5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(phone, MD5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    public ServerResponse<User> getUserInfo(Integer id) {
        return ServerResponse.createBySuccess(userMapper.selectByPrimaryKey(id));
    }

    public ServerResponse<String> register(User user) {
        int resultCount = userMapper.checkUsername(user.getPhone());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("该手机号以注册");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }


    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    public ServerResponse<User> updateInformation(User user) {

        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setSex(user.getSex());
        updateUser.setAddress(user.getAddress());
        updateUser.setBirthday(user.getBirthday());
        updateUser.setCourse(user.getCourse());
        updateUser.setEducation(user.getEducation());
        updateUser.setIdcard(user.getIdcard());
        updateUser.setImage(user.getImage());
        updateUser.setMajor(user.getMajor());
        updateUser.setProvince(user.getProvince());
        updateUser.setQq(user.getQq());
        updateUser.setWechat(user.getWechat());
        updateUser.setSchool(user.getSchool());
        updateUser.setName(user.getName());
        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);

        if (updateCount > 0) {
            return ServerResponse.createBySuccess("更新个人信息成功", user);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    public ServerResponse<User> getUserInfoByPhone(String phone) {
        return ServerResponse.createBySuccess(userMapper.selectUserByPhone(phone));
    }

    @Override
    public ServerResponse uploadFile(File file) {
        return ServerResponse.createBySuccess(userMapper.insertFile(file));
    }

    @Override
    public ServerResponse getFileBystid(Integer id, Integer tid) {
        return ServerResponse.createBySuccess(userMapper.selectFileBystId(id,tid));
    }

    @Override
    public ServerResponse addEval(Eval eval) {
        return ServerResponse.createBySuccess(userMapper.insertEval(eval));
    }

    @Override
    public ServerResponse<List> getEval(Integer id, Integer tid) {
        return ServerResponse.createBySuccess(userMapper.selectEval(id,tid));
    }


    //bankend
    public ServerResponse<Admin> adminLogin(String username, String password) {
        Admin admin = adminMapper.adminLogin(username, password);
        if (admin == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", admin);
    }

    public ServerResponse getList() {
        return ServerResponse.createBySuccess(userMapper.getList());
    }

    public ServerResponse getStudentList() {
        return ServerResponse.createBySuccess(userMapper.getStudentList());
    }

    public ServerResponse getTeacherList() {
        return ServerResponse.createBySuccess(userMapper.getTeacherList());
    }
}
