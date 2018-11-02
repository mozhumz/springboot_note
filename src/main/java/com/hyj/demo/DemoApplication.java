package com.hyj.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.hyj.demo.test.TestCase;
import com.hyj.demo.util.CommonUtil;


@SpringBootApplication
// 扫描dao层
@MapperScan({"com.hyj.demo.mapper"})
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
