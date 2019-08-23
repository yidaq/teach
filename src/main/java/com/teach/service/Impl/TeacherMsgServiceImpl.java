package com.teach.service.Impl;


import com.teach.common.ServerResponse;
import com.teach.dao.TeacherMsgMapper;
import com.teach.dao.UserMapper;
import com.teach.pojo.TeacherMsg;
import com.teach.pojo.User;
import com.teach.service.ITeacherMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherMsgService")
public class TeacherMsgServiceImpl implements ITeacherMsgService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMsgMapper teacherMsgMapper;

    public ServerResponse getTeacherMsgInfo(User user){
        int result = userMapper.checkUsername(user.getPhone());
        if (result == 0){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        return ServerResponse.createBySuccess(teacherMsgMapper.selectByPrimaryUserId(user.getId()));
    }

    public ServerResponse getTeacherMsgList(){
        return ServerResponse.createBySuccess(teacherMsgMapper.getList());
    }

    public ServerResponse insertTeacherMsg(TeacherMsg teacherMsg,User user){
        teacherMsg.setUserid(user.getId());
        int result = teacherMsgMapper.insertSelective(teacherMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccess("添加成功");
    }

    public ServerResponse updateTeacherMsg(TeacherMsg teacherMsg){
        int result =  teacherMsgMapper.updateByPrimaryKeySelective(teacherMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("修改信息失败");
        }
        return ServerResponse.createBySuccess("修改信息成功");
    }

    public ServerResponse deleteTeacherMsg(Integer id){
        int result =  teacherMsgMapper.deleteByPrimaryKey(id);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("修改信息失败");
        }
        return ServerResponse.createBySuccess("修改信息成功");
    }

    public ServerResponse getTeacherMsgListByCourse(String course){
        return ServerResponse.createBySuccess(teacherMsgMapper.getListByCourse(course));
    }

    public ServerResponse getTeacherMsgListByStatus(Integer status){
        return ServerResponse.createBySuccess(teacherMsgMapper.getListByStatus(status));
    }

    @Override
    public ServerResponse getTeacherMsgByUserid(Integer id) {
        return ServerResponse.createBySuccess(teacherMsgMapper.selectByPrimaryUserId(id));
    }

    @Override
    public ServerResponse getTeacherMsgById(Integer id) {
        return ServerResponse.createBySuccess(teacherMsgMapper.selectByPrimaryKey(id));
    }

    //bankend
    public ServerResponse updateTeacherMsgStatus(Integer id,Integer status){
        TeacherMsg teacherMsg = teacherMsgMapper.selectByPrimaryKey(id);
        if (teacherMsg == null){
            return ServerResponse.createByErrorMessage("老师申请信息不存在");
        }
        teacherMsg.setStatus(status);
        int result =  teacherMsgMapper.updateByPrimaryKeySelective(teacherMsg);
        if (result == 0 ){
            return ServerResponse.createByErrorMessage("同意申请信息失败");
        }
        return ServerResponse.createBySuccess("同意申请信息成功");
    }

}
