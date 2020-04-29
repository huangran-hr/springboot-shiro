package com.hr.springboot.mapper;

import com.hr.springboot.domain.Book;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: HR
 * @Date: 2020/4/22 15:08
 * @Description:
 */
public interface BookMapper extends Mapper<Book> {
    List<Book> findAllByTitleLikeOrAuthorLike(String keywords);

    List<Book> listByCategory(int cid);

    List<Book> selectAllBook();
}
