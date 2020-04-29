package com.hr.springboot.controller;

import com.hr.springboot.domain.Book;
import com.hr.springboot.service.BookService;
import com.hr.springboot.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @GetMapping("/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/books/addOrUpdate")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @PostMapping("/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "E:/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
