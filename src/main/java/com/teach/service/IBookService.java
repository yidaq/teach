package com.teach.service;


import com.teach.common.ServerResponse;
import com.teach.pojo.Book;

public interface IBookService {

    ServerResponse getBookList();
    ServerResponse<Book> getBookInfo(Integer id);
    ServerResponse insertBook(Book book);
    ServerResponse getBookListByCourseEducation(String course, String education);
}
