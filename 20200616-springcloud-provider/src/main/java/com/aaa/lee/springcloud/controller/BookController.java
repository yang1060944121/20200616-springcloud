package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import com.aaa.lee.springcloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/16 10:59
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * @author Seven Lee
     * @description
     *          localhost
     *      http://localhost:8081/all
     * @param []
     * @date 2020/6/17
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        System.out.println("8081");
        return bookService.selectAllBooks();
    }

}
