package com.teach.dao;

import com.teach.pojo.StudentMsg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentMsg record);

    int insertSelective(StudentMsg record);

    StudentMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentMsg record);

    int updateByPrimaryKey(StudentMsg record);

    List<StudentMsg> selectByPrimaryUserId(Integer userid);

    List<StudentMsg> getList();

    List<StudentMsg> getListByCourse(String course);

    List<StudentMsg> getListByStatus(Integer status);

    List<StudentMsg> getListByPlace(String place);

}