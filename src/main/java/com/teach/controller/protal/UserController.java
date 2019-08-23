package com.teach.controller.protal;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.Eval;
import com.teach.pojo.User;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse<User> login(String phone, String password, HttpSession session){
        ServerResponse<User> response = userService.login(phone,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }

        return response;
    }

    @RequestMapping(value = "logout.do",method = RequestMethod.POST )
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST )
    public ServerResponse<String> register(User user){
        return userService.register(user);
    }

    @RequestMapping(value = "get_user_self_info.do",method = RequestMethod.POST)
    public ServerResponse<User> getUserSelfInfo(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);

        if (user != null){
            return userService.getUserInfo(user.getId());
        }
        return ServerResponse.createByErrorMessage("用户未登陆，无法获取用户信息");
    }

    @RequestMapping(value = "get_user_info.do",method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(Integer id,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return userService.getUserInfo(id);
    }

    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    public ServerResponse<String> resetPassword(HttpSession session,String passwordOld,String passwordNew){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return userService.resetPassword(passwordOld,passwordNew,user);
    }

    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    public ServerResponse<User> update_information(HttpSession session,User user){

        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);

        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }

        user.setId(currentUser.getId());
        user.setPhone(currentUser.getPhone());
        ServerResponse<User> response = userService.updateInformation(user);

        if(response.isSuccess()){
            response.getData().setPhone(currentUser.getPhone());
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }

        session.setAttribute(Const.CURRENT_USER,response.getData());
        return response;
    }

    @RequestMapping(value = "get_user_info_by_phone.do",method = RequestMethod.POST)
    public ServerResponse<User> getUserInfoByPhone(String phone,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return userService.getUserInfoByPhone(phone);
    }



    @RequestMapping(value = "update_img.do",method = RequestMethod.POST)
    public ServerResponse updateImg(HttpServletRequest req, HttpSession session, MultipartFile file){

        User user = (User)session.getAttribute(Const.CURRENT_USER);

        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/faces" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            user.setImage(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        }

        session.setAttribute(Const.CURRENT_USER,user);

        return userService.updateInformation(user);


    }
    @RequestMapping(value = "ppt.do",method = RequestMethod.POST)
    public ServerResponse uploadPPT(MultipartFile ppt , String pptname ,Integer targetId , HttpServletRequest req, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        com.teach.pojo.File file = new com.teach.pojo.File();


        try {
            String fileName = System.currentTimeMillis() + ppt.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/file" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            ppt.transferTo(destFile);
            file.setType(0);
            file.setName(pptname);
            file.setSid(targetId);
            file.setTid(user.getId());
            file.setFilepath(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        }

        return userService.uploadFile(file);
    }

    @RequestMapping(value = "testPaper.do",method = RequestMethod.POST)
    public ServerResponse uploadTestPaper(MultipartFile file , String testname ,Integer targetId , HttpServletRequest req, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        com.teach.pojo.File paper = new com.teach.pojo.File();


        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = req.getServletContext().getRealPath("") + "demo/file" + File.separator + fileName;
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            paper.setType(1);
            paper.setName(testname);
            paper.setSid(targetId);
            paper.setTid(user.getId());
            paper.setFilepath(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            return ServerResponse.createByErrorMessage("上传失败");
        }

        return userService.uploadFile(paper);
    }

    @RequestMapping(value = "getfile.do",method = RequestMethod.POST)
    public ServerResponse getFile(Integer tid,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null ){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return userService.getFileBystid(user.getId(),tid);
    }

    @RequestMapping(value = "addeval.do",method = RequestMethod.POST)
    public ServerResponse addeval(Integer tid,String content,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        Eval eval = new Eval();

        eval.setContent(content);
        eval.setRole(user.getRole());
        eval.setTargetid(tid);
        eval.setUserid(user.getId());

        return userService.addEval(eval);
    }


    @RequestMapping(value = "geteval.do",method = RequestMethod.POST)
    public ServerResponse geteval(Integer tid,HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        return userService.getEval(user.getId(),tid);
    }


}
