package com.teach.service.Impl;


import com.teach.common.ServerResponse;
import com.teach.dao.StudentMsgMapper;
import com.teach.dao.UserMapper;
import com.teach.pojo.StudentMsg;
import com.teach.pojo.User;
import com.teach.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentMsgService")
public class StudentMsgServiceImpl implements IStudentMsgService {

    @Autowired
    private StudentMsgMapper studentMsgMapper;
    @Autowired
    private UserMapper userMapper;

    public ServerResponse getStudentMsgInfo(User user){
        int result = userMapper.checkUsername(user.getPhone());
        if (result == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        return ServerResponse.createBySuccess(studentMsgMapper.selectByPrimaryUserId(user.getId()));
    }

    public ServerResponse getStudentMsgList(){
        return ServerResponse.createBySuccess(studentMsgMapper.getList());
    }

    public ServerResponse insertStudentMsg(StudentMsg studentMsg, User user){
        studentMsg.setUserid(user.getId());
        int result = studentMsgMapper.insertSelective(studentMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccess("添加成功");
    }

    public ServerResponse updateStudentMsg(StudentMsg studentMsg){
        int result =  studentMsgMapper.updateByPrimaryKeySelective(studentMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("修改信息失败");
        }
        return ServerResponse.createBySuccess("修改信息成功");
    }

    public ServerResponse deleteStudentMsg(Integer id){
        int result =  studentMsgMapper.deleteByPrimaryKey(id);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("修改信息失败");
        }
        return ServerResponse.createBySuccess("修改信息成功");
    }

    public ServerResponse getStudentMsgListByCourse(String course){
        return ServerResponse.createBySuccess(studentMsgMapper.getListByCourse(course));
    }

    public ServerResponse getStudentMsgListByStatus(Integer status){
        return ServerResponse.createBySuccess(studentMsgMapper.getListByStatus(status));
    }

    @Override
    public ServerResponse getStudentMsgByUserid(Integer id) {
        return ServerResponse.createBySuccess(studentMsgMapper.selectByPrimaryUserId(id));
    }

    @Override
    public ServerResponse getStudentMsgById(Integer id) {
        return ServerResponse.createBySuccess(studentMsgMapper.selectByPrimaryKey(id));
    }

    public ServerResponse getStudentMsgListByPlace(String place){
        return ServerResponse.createBySuccess(studentMsgMapper.getListByPlace(place));
    }


    //bankend

    public ServerResponse updateStudentMsgStatus(Integer id, Integer status){
        StudentMsg studentMsg = studentMsgMapper.selectByPrimaryKey(id);
        if (studentMsg == null){
            return ServerResponse.createByErrorMessage("学生申请信息不存在");
        }
        studentMsg.setStatus(status);
        int result =  studentMsgMapper.updateByPrimaryKeySelective(studentMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("同意申请信息失败");
        }
        return ServerResponse.createBySuccess("同意申请信息成功");
    }


}
