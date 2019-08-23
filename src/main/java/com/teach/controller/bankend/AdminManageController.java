package com.teach.controller.bankend;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.Book;
import com.teach.service.IBookService;
import com.teach.service.IStudentMsgService;
import com.teach.service.ITeacherMsgService;
import com.teach.service.IUserService;
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
@RequestMapping("/manage/user")
public class AdminManageController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentMsgService studentMsgService;
    @Autowired
    private ITeacherMsgService teacherMsgService;
    @Autowired
    private IBookService bookService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    public ServerResponse<Admin> login(String username, String password, HttpSession session){
        ServerResponse<Admin> response = userService.adminLogin(username,password);
        if(response.isSuccess()){
            Admin admin = response.getData();
            if(admin != null){
                session.setAttribute(Const.CURRENT_ADMIN,admin);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST )
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_ADMIN);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "get_list.do",method = RequestMethod.POST)
    public ServerResponse getList(HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return userService.getList();
    }

    @RequestMapping(value = "get_student_list.do",method = RequestMethod.POST)
    public ServerResponse getStudentList(HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return userService.getStudentList();
    }

    @RequestMapping(value = "get_teacher_list.do",method = RequestMethod.POST)
    public ServerResponse getTeacherList(HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return userService.getTeacherList();
    }

    @RequestMapping(value = "update_student_msg_status.do",method = RequestMethod.POST)
    public ServerResponse updateStudentMsgStatus(Integer id,HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return studentMsgService.updateStudentMsgStatus(id,1);
    }
    @RequestMapping(value = "refuse_student_msg_status.do",method = RequestMethod.POST)
    public ServerResponse refuseStudentMsgStatus(Integer id,HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return studentMsgService.updateStudentMsgStatus(id,-1);
    }

    @RequestMapping(value = "update_teacher_msg_status.do",method = RequestMethod.POST)
    public ServerResponse updateTeacherMsgStatus(Integer id,HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return teacherMsgService.updateTeacherMsgStatus(id,1);
    }

    @RequestMapping(value = "refuse_teacher_msg_status.do",method = RequestMethod.POST)
    public ServerResponse refuseTeacherMsgStatus(Integer id,HttpSession session){
        Admin admin = (Admin) session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,需要要登陆管理员");
        }
        return teacherMsgService.updateTeacherMsgStatus(id,-1);
    }


    @RequestMapping(value = "insert_book.do",method = RequestMethod.POST)
    public ServerResponse insertBook(Book book, HttpServletRequest req, HttpSession session, MultipartFile img, MultipartFile file){


        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);


        if (admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/book/file" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            book.setFilepath(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        }


        try {
            String fileName = System.currentTimeMillis() + img.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/book/img" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            img.transferTo(destFile);
            book.setImagepath(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        }

        return bookService.insertBook(book);
    }








}
