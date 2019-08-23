package com.teach.service;

import com.teach.common.ServerResponse;
import com.teach.pojo.ComplainMsg;

public interface IComplainMsgService {

    ServerResponse getComplainMsgList();
    ServerResponse getComplainMsgListByUserId(Integer userid);
    ServerResponse deleteComplainMsgListByUserId(Integer id);
    ServerResponse insertComplainMsg(ComplainMsg complainMsg);
}
