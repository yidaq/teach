package com.teach.dao;

import com.teach.pojo.TeacherMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeacherMsg record);

    int insertSelective(TeacherMsg record);

    TeacherMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeacherMsg record);

    int updateByPrimaryKey(TeacherMsg record);

    List<TeacherMsg> selectByPrimaryUserId(Integer userid);

    List<TeacherMsg> getList();

    List<TeacherMsg> getListByCourse(String course);

    List<TeacherMsg> getListByStatus(Integer status);




}