package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/18 9:22
 * @Description
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6083 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6083.class, args);
    }

}
