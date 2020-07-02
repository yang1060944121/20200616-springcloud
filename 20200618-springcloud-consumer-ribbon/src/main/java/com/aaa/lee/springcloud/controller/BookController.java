package com.aaa.lee.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/18 10:04
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        return restTemplate.getForObject("http://book-interface/all", List.class);
    }

}
