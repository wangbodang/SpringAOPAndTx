package com.wangbodang.book.service.impl;

import com.wangbodang.book.dao.BookDao;
import com.wangbodang.book.entity.Book;
import com.wangbodang.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public String findBookById(int id)
    {
        return bookDao.findBookById(id);
    }
    public void saveBook(Book book)
    {
        bookDao.saveBook(book);

    }
}
