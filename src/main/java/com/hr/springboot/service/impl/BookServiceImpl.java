package com.hr.springboot.service.impl;

import com.hr.springboot.domain.Book;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hr.springboot.mapper.BookMapper;
import com.hr.springboot.service.BookService;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService{

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> list() {
        return bookMapper.selectAllBook();
    }

    @Override
    public void addOrUpdate(Book book) {
        Book oldBook = bookMapper.selectByPrimaryKey(book.getId());
        if(oldBook != null){
            bookMapper.updateByPrimaryKey(book);
        }else{
            bookMapper.insert(book);
        }
    }

    @Override
    public void deleteById(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Book> listByCategory(int cid) {
        return bookMapper.listByCategory(cid);
    }

    @Override
    public List<Book> Search(String keywords) {
        return bookMapper.findAllByTitleLikeOrAuthorLike(keywords);
    }
}
