package com.teach.service.Impl;


import com.teach.common.ServerResponse;
import com.teach.dao.ApplyMsgMapper;
import com.teach.dao.UserMapper;
import com.teach.pojo.ApplyMsg;
import com.teach.pojo.User;
import com.teach.service.IApplyMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("applyMsgService")
public class ApplyMsgServiceImpl implements IApplyMsgService {

    @Autowired
    private ApplyMsgMapper applyMsgMapper;

    @Autowired
    private UserMapper userMapper;

    public ServerResponse getApplyMsgById(Integer id) {
        return ServerResponse.createBySuccess(applyMsgMapper.selectByUserid(id));
    }

    public ServerResponse getApplyMsgByTargetId(Integer id) {
        return ServerResponse.createBySuccess(applyMsgMapper.selectByTargetid(id));
    }

    public ServerResponse getApplyMsgList() {
        return ServerResponse.createBySuccess(applyMsgMapper.getList());
    }

    @Override
    public ServerResponse insert(ApplyMsg applyMsg) {
        return ServerResponse.createBySuccess(applyMsgMapper.insert(applyMsg));
    }

    @Override
    public ServerResponse delete(ApplyMsg applyMsg) {
        return ServerResponse.createBySuccess(applyMsgMapper.deleteByPrimaryKey(applyMsg.getId()));
    }

    @Override
    public ServerResponse sAccept(Integer id, Integer targetId) {

        return ServerResponse.createBySuccess(applyMsgMapper.insertSAccept(id, targetId));
    }


    @Override
    public ServerResponse tAccept(Integer id, Integer targetId) {
        return ServerResponse.createBySuccess(applyMsgMapper.insertTAccept(id, targetId));
    }

    @Override
    public ServerResponse updateStatus(Integer applyId) {
        return ServerResponse.createBySuccess(applyMsgMapper.updateStatus(applyId));
    }

    @Override
    public ServerResponse findS(Integer id) {
        List<Integer> sIdList = applyMsgMapper.selectByTid(id);
        List<User> userList = new ArrayList<User>();
        for (Integer sid : sIdList) {
            userList.add(userMapper.selectByPrimaryKey(sid));

        }
        return ServerResponse.createBySuccess(userList);
    }

    @Override
    public ServerResponse findT(Integer id) {
        List<Integer> sIdList = applyMsgMapper.selectBySid(id);
        List<User> userList = new ArrayList<User>();
        for (Integer sid : sIdList) {
            userList.add(userMapper.selectByPrimaryKey(sid));

        }
        return ServerResponse.createBySuccess(userList);
    }
}
