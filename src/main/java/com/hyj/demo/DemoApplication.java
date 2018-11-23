package com.hyj.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
// 扫描dao层
//@MapperScan({"com.hyj.demo.dao.mapper"})
// @EnableScheduling
public class DemoApplication
{
    private static ConfigurableApplicationContext context;

    public static void main(String[] args)
    {
        context = SpringApplication.run(DemoApplication.class, args);
//        context.getBean("commonUtil", CommonUtil.class).test();
    }
}
