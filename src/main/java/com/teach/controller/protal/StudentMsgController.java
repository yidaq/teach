package com.teach.controller.protal;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.StudentMsg;
import com.teach.pojo.User;
import com.teach.service.IStudentMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/student/msg")
public class StudentMsgController {

    @Autowired
    private IStudentMsgService studentMsgService;

    @RequestMapping(value = "get_student_msg_info.do",method = RequestMethod.POST)
    public ServerResponse<StudentMsg> getStudentMsgInfo(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgInfo(user);
    }


    @RequestMapping(value = "get_student_msg_list.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgList(){
        return studentMsgService.getStudentMsgList();
    }

    @RequestMapping(value = "insert_student_msg.do",method = RequestMethod.POST)
    public ServerResponse insertStudentMsg(StudentMsg studentMsg, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.insertStudentMsg(studentMsg,user);
    }

    @RequestMapping(value = "update_student_msg.do",method = RequestMethod.POST)
    public ServerResponse updateStudentMsg(StudentMsg studentMsg, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        studentMsg.setStatus(0);
        return studentMsgService.updateStudentMsg(studentMsg);
    }

    @RequestMapping(value = "delete_student_msg.do",method = RequestMethod.POST)
    public ServerResponse deleteStudentMsg(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.deleteStudentMsg(id);
    }

    @RequestMapping(value = "get_student_msg_list_by_course.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgListByCourse(String course, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgListByCourse(course);
    }

    @RequestMapping(value = "get_student_msg_list_by_place.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgListByPlace(String place, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgListByPlace(place);
    }

    @RequestMapping(value = "get_student_msg_list_by_status.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgListByStatus(Integer status, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgListByStatus(status);
    }

    @RequestMapping(value = "get_student_msg_by_userid.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgByUserid(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);

        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgByUserid(id);


    }
      @RequestMapping(value = "get_student_msg_by_id.do",method = RequestMethod.POST)
    public ServerResponse getStudentMsgById(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);

        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return studentMsgService.getStudentMsgById(id);


    }



}
