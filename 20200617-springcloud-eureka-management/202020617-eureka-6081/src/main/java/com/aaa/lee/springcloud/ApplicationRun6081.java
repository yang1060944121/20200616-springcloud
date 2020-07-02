package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/6/17 9:06
 * @Description
 *      springcloud只有三步:
 *          1.添加jar包
 *          2.添加注解(每一个组件都自带的有自己注解)
 *          3.编写配置(application.properties/application.yml)
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class, args);
    }

}
