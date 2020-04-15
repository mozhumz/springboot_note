package com.hyj.sourcenote;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.hyj.sourcenote.web")
@Configuration
public class Application {
    public static void main(String[] args) {
        System.out.println("start....");
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8899);
        try {
            tomcat.addWebapp("/","F:\\study\\tmp");
            tomcat.start();
//            MyServlet myServlet=new MyServlet();
//            tomcat.addServlet("/test","myServlet",myServlet);
//            context.addServletMappingDecoded("/index.do","myServlet");
            System.out.println("ok--------------");
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
