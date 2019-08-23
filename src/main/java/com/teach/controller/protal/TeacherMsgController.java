package com.teach.controller.protal;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.TeacherMsg;
import com.teach.pojo.User;
import com.teach.service.ITeacherMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/teacher/msg")
public class TeacherMsgController {

    @Autowired
    private ITeacherMsgService teacherMsgService;

    @RequestMapping(value = "get_teacher_msg_info.do", method = RequestMethod.POST)
    public ServerResponse<TeacherMsg> getTeacherMsgInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }

        return teacherMsgService.getTeacherMsgInfo(user);
    }

    @RequestMapping(value = "get_teacher_msg_list.do", method = RequestMethod.POST)
    public ServerResponse getTeacherMsgList() {
        return teacherMsgService.getTeacherMsgList();
    }

    @RequestMapping(value = "insert_teacher_msg.do", method = RequestMethod.POST)
    public ServerResponse insertTeacherMsg(TeacherMsg teacherMsg, MultipartFile file, HttpServletRequest req, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }


        TeacherMsg teacherMsgNew = videoFileUpdate(teacherMsg, file, req);
        if (teacherMsgNew != null) {
            return  teacherMsgService.insertTeacherMsg(teacherMsgNew,user);
        }

        return teacherMsgService.insertTeacherMsg(teacherMsg, user);
    }

    private TeacherMsg videoFileUpdate(TeacherMsg teacherMsg, MultipartFile file, HttpServletRequest req) {

        if (file == null || file.isEmpty()){
            return null;
        }
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/video" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            teacherMsg.setVideopath(fileName);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return teacherMsg;
    }

    @RequestMapping(value = "update_teacher_msg.do", method = RequestMethod.POST)
    public ServerResponse updateTeacherMsg(TeacherMsg teacherMsg, MultipartFile file, HttpServletRequest req, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        teacherMsg.setStatus(0);
        teacherMsg.setUserid(user.getId());
        TeacherMsg teacherMsgNew = videoFileUpdate(teacherMsg, file, req);
        if (teacherMsgNew != null) {
          return  teacherMsgService.updateTeacherMsg(teacherMsg);
        }

        return teacherMsgService.updateTeacherMsg(teacherMsg);
    }


    @RequestMapping(value = "delete_teacher_msg.do", method = RequestMethod.POST)
    public ServerResponse deleteTeacherMsg(Integer id, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return teacherMsgService.deleteTeacherMsg(id);
    }

    @RequestMapping(value = "get_teacher_msg_list_by_course.do", method = RequestMethod.POST)
    public ServerResponse getTeacherMsgListByCourse(String course, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return teacherMsgService.getTeacherMsgListByCourse(course);
    }

    @RequestMapping(value = "get_teacher_msg_list_by_status.do", method = RequestMethod.POST)
    public ServerResponse getTeacherMsgListByStatus(Integer status, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return teacherMsgService.getTeacherMsgListByStatus(status);
    }


    @RequestMapping(value = "get_teacher_msg_by_userid.do", method = RequestMethod.POST)
    public ServerResponse getTeacherMsgByUserid(Integer id, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);

        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return teacherMsgService.getTeacherMsgByUserid(id);


    }

    @RequestMapping(value = "get_teacher_msg_by_id.do", method = RequestMethod.POST)
    public ServerResponse getTeacherMsgById(Integer id, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);

        if (user == null && admin == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return teacherMsgService.getTeacherMsgById(id);


    }
}
