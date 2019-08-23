package com.teach.controller.protal;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.ApplyMsg;
import com.teach.pojo.User;
import com.teach.service.IApplyMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private IApplyMsgService applyMsgService;


    @RequestMapping(value = "get_apply_msg_by_userid.do",method = RequestMethod.POST)
    public ServerResponse<ApplyMsg> getApplyMsgByUserId(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return applyMsgService.getApplyMsgById(id);
    }

    @RequestMapping(value = "get_apply_msg_by_targetid.do",method = RequestMethod.POST)
    public ServerResponse<ApplyMsg> getApplyMsgByTargetId(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return applyMsgService.getApplyMsgByTargetId(id);
    }

    @RequestMapping(value = "get_apply_msg_list.do",method = RequestMethod.POST)
    public ServerResponse getApplyMsgList(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return applyMsgService.getApplyMsgList();
    }

    @RequestMapping(value = "add_applymsg.do",method = RequestMethod.POST)
    public ServerResponse addApplyMsg(ApplyMsg applyMsg, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        applyMsg.setRole(0);
        return applyMsgService.insert(applyMsg);
    }

    @RequestMapping(value = "del_applymsg.do",method = RequestMethod.POST)
    public ServerResponse delApplyMsg(ApplyMsg applyMsg, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return applyMsgService.delete(applyMsg);
    }

    @RequestMapping(value = "accept.do",method = RequestMethod.POST)
    public ServerResponse accept(Integer targetId, Integer applyId, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        applyMsgService.updateStatus(applyId);
        if (user.getRole() == 0){
            return applyMsgService.sAccept(user.getId(),targetId);
        }

        return applyMsgService.tAccept(user.getId(),targetId);
    }

    @RequestMapping(value = "findStudent.do" ,method = RequestMethod.POST)
    public ServerResponse findS(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        return applyMsgService.findS(user.getId());
    }

    @RequestMapping(value = "findTeacher.do" ,method = RequestMethod.POST)
    public ServerResponse findT(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }

        return applyMsgService.findT(user.getId());
    }
}
