package com.wangbodang.book.dao;

import com.wangbodang.book.entity.Book;

public interface BookDao {
    public String findBookById(int id);

    public void saveBook(Book book);
}
