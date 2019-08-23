package com.teach.controller.protal;


import com.teach.common.Const;
import com.teach.common.ResponseCode;
import com.teach.common.ServerResponse;
import com.teach.pojo.Admin;
import com.teach.pojo.Book;
import com.teach.pojo.User;
import com.teach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "get_book_list.do",method = RequestMethod.POST)
    public ServerResponse getBookList(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return bookService.getBookList();
    }

    @RequestMapping(value = "get_book_info.do",method = RequestMethod.POST)
    public ServerResponse<Book> getBookInfo(Integer id, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return bookService.getBookInfo(id);
    }

    @RequestMapping(value = "get_book_list_by_course_education.do",method = RequestMethod.POST)
    public ServerResponse getBookListByCourseEducation(String course, String education, HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_ADMIN);
        if (user == null && admin == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return bookService.getBookListByCourseEducation(course,education);
    }

}
