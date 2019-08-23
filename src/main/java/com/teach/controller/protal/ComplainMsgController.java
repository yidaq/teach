package com.teach.controller.protal;

import com.teach.common.Const;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.ComplainMsg;
import com.teach.pojo.User;
import com.teach.service.IComplainMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/complain/msg")
public class ComplainMsgController {

    @Autowired
    private IComplainMsgService complainMsgService;

    @RequestMapping(value = "get_complain_msg_list.do",method = RequestMethod.POST)
    public ServerResponse getComplainMsgList(HttpSession session){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,请登录管理员");
        }
        return complainMsgService.getComplainMsgList();
    }

    @RequestMapping(value = "get_complain_msg_list_by_userid.do",method = RequestMethod.POST)
    public ServerResponse getComplainMsgListByUserId(Integer userid, HttpSession session){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,请登录管理员");
        }
        return complainMsgService.getComplainMsgListByUserId(userid);
    }

    @RequestMapping(value = "delete_complain_msg_list_by_id.do",method = RequestMethod.POST)
    public ServerResponse deleteComplainMsgListById(Integer id, HttpSession session){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (admin == null){
            return ServerResponse.createByErrorMessage("无权限,请登录管理员");
        }
        return complainMsgService.deleteComplainMsgListByUserId(id);
    }

    @RequestMapping(value = "insert_complain_msg.do",method = RequestMethod.POST)
    public ServerResponse insertComplainMsg(ComplainMsg complainMsg, HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorMessage("无权限,请登录");
        }
        return complainMsgService.insertComplainMsg(complainMsg);
    }
}
