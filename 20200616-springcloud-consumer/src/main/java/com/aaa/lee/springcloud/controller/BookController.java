package com.aaa.lee.springcloud.controller;

import com.aaa.lee.springcloud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/16 10:56
 * @Description
 **/
@RestController
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @author Seven Lee
     * @description
     *      查询所有的图书信息
     *      因为consumer只和客户端打交道，所有的数据来源都来源于服务器端
     *          所以需要远程去调用provider(restful风格来进行调用)
     *          restTemplate就是最终来模拟了http协议
     *          既然要发送一个请求到达provider，就必须要知道provider的controller的地址是谁
     *          (也就是说必须要知道provider的@GetMapping的值)
     *          最终还需要去接受返回值
     * @param []
     * @date 2020/6/16
     * @return java.util.List<com.aaa.lee.springcloud.model.Book>
     * @throws
    **/
    @GetMapping("/all")
    public List<Book> selectAllBooks() {
        // 需要去调用provider项目中的方法
        // 因为restful的风格就是controller去调用controller，所以需要配置restTemplate(spring公司默认提供了)
        // 必须要保证provider中controller使用的是get请求方式getForObject()
        return restTemplate.getForObject("http://localhost:8081/all", List.class);
    }

}
