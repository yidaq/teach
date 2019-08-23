package com.teach.service;

import com.teach.common.ServerResponse;
import com.teach.pojo.ApplyMsg;

public interface IApplyMsgService {

    ServerResponse getApplyMsgById(Integer id);
    ServerResponse getApplyMsgByTargetId(Integer id);
    ServerResponse getApplyMsgList();

    ServerResponse insert(ApplyMsg applyMsg);

    ServerResponse delete(ApplyMsg applyMsg);

    ServerResponse sAccept(Integer id, Integer targetId);

    ServerResponse tAccept(Integer id, Integer targetId);

    ServerResponse updateStatus(Integer applyId);

    ServerResponse findS(Integer id);

    ServerResponse findT(Integer id);
}
