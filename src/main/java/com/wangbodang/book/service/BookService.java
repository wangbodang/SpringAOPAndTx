package com.wangbodang.book.service;

import com.wangbodang.book.entity.Book;

public interface BookService {
    public String findBookById(int id);
    public void saveBook(Book book);
}
