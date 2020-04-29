package com.hr.springboot.service;

import com.hr.springboot.domain.Book;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
public interface BookService{

    List<Book> list();

    void addOrUpdate(Book book);

    void deleteById(Integer id);

    List<Book> listByCategory(int cid);

    List<Book> Search(String keywords);
}
