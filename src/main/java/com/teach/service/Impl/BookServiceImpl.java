package com.teach.service.Impl;


import com.teach.common.ServerResponse;
import com.teach.dao.BookMapper;
import com.teach.pojo.Book;
import com.teach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    public ServerResponse getBookList(){
        return ServerResponse.createBySuccess(bookMapper.getList());
    }

    public ServerResponse<Book> getBookInfo(Integer id){
        Book book = bookMapper.selectByPrimaryKey(id);
        if (book == null){
            return ServerResponse.createBySuccessMessage("教材不存在");
        }
        return ServerResponse.createBySuccess(book);
    }

    public ServerResponse getBookListByCourseEducation(String course, String education){
        return ServerResponse.createBySuccess(bookMapper.getListByCourseEducation(course,education));
    }

    //bankend
    public ServerResponse insertBook(Book book){
        int result = bookMapper.insertSelective(book);
        if (result == 0){
            return ServerResponse.createByErrorMessage("上传教材失败");
        }
        return ServerResponse.createBySuccessMessage("上传教材成功");
    }


}
