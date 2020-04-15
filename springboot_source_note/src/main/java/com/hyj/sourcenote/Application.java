package com.hyj.sourcenote;

import com.hyj.sourcenote.web.MyServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Application {
    public static void main(String[] args) {
        System.out.println("start....");
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8899);
        try {
            tomcat.start();
            MyServlet myServlet=new MyServlet();
            Context context=tomcat.addWebapp("/test","F:\\study\\tmp");
            tomcat.addServlet("/test","myServlet",myServlet);
            context.addServletMappingDecoded("/index.do","myServlet");
            System.out.println("ok--------------");
            tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
