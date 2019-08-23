package com.teach.dao;

import com.teach.pojo.Eval;
import com.teach.pojo.File;
import com.teach.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String phone);

    User selectLogin(@Param("phone") String phone, @Param("password") String password);

    List<User> getList();

    List<User> getStudentList();

    List<User> getTeacherList();

    int checkPassword(@Param(value = "password") String password, @Param("userId") Integer userId);

    User selectUserByPhone(String phone);


    int insertFile(File file);

    List<File> selectFileBystId(@Param("id") Integer id, @Param("tid") Integer tid);

    int insertEval(Eval eval);

    List<Eval> selectEval(@Param("id") Integer id, @Param("tid") Integer tid);
}