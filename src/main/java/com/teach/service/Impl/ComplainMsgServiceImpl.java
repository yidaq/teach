package com.teach.service.Impl;


import com.teach.common.ServerResponse;
import com.teach.dao.ComplainMsgMapper;
import com.teach.pojo.ComplainMsg;
import com.teach.service.IComplainMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("complainService")
public class ComplainMsgServiceImpl implements IComplainMsgService {

    @Autowired
    private ComplainMsgMapper complainMsgMapper;

    public ServerResponse getComplainMsgList(){
        return ServerResponse.createBySuccess(complainMsgMapper.getList());
    }

    public ServerResponse getComplainMsgListByUserId(Integer userid){
        return ServerResponse.createBySuccess(complainMsgMapper.getListByUserId(userid));
    }

    public ServerResponse deleteComplainMsgListByUserId(Integer id) {
        int result = complainMsgMapper.deleteByPrimaryKey(id);
        if (result == 0){
            return ServerResponse.createByErrorMessage("删除失败");
        }
        return ServerResponse.createBySuccessMessage("删除"+id+"投诉成功");
    }

    public ServerResponse insertComplainMsg(ComplainMsg complainMsg) {
        int result = complainMsgMapper.insertSelective(complainMsg);
        if (result == 0){
            return ServerResponse.createByErrorMessage("投诉失败");
        }
        return ServerResponse.createBySuccessMessage("投诉成功");
    }
}
