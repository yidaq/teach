package com.teach.dao;

import com.teach.pojo.ApplyMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ApplyMsg record);

    int insertSelective(ApplyMsg record);

    ApplyMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ApplyMsg record);

    int updateByPrimaryKey(ApplyMsg record);

    List<ApplyMsg> selectByUserid(Integer id);

    List<ApplyMsg> selectByTargetid(Integer id);

    List<ApplyMsg> getList();

    int insertTAccept(@Param("id") Integer id, @Param("targetId") Integer targetId);

    int insertSAccept(@Param("id") Integer id, @Param("targetId") Integer targetId);

    int updateStatus(Integer applyId);

    List<Integer> selectByTid(Integer id);

    List<Integer> selectBySid(Integer id);
}