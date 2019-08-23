package com.teach.dao;

import com.teach.pojo.ComplainMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplainMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComplainMsg record);

    int insertSelective(ComplainMsg record);

    ComplainMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComplainMsg record);

    int updateByPrimaryKey(ComplainMsg record);

    List<ComplainMsg> getList();

    List<ComplainMsg> getListByUserId(Integer userid);
}