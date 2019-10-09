package com.hyj.demo.base;

import com.hyj.demo.model.po.Aoo;
import org.junit.Test;

import java.util.HashMap;

public class BaseCase {
    @Test
    public void testEq(){
        Aoo aoo1=new Aoo();
        aoo1.setName("a1");
        aoo1.setId(1L);
        Aoo aoo2=new Aoo();
        aoo2.setId(2L);
        aoo2.setName("a2");

        System.out.println(aoo1.equals(aoo2));

        HashMap hashMap=new HashMap();
        hashMap.put(aoo1,aoo1);

    }

    /**
     * +=操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型,而a=a+b则不会自动进行类型转换
     */
    @Test
    public void testByte(){
        byte a = 127;
        byte b = 127;
//        b = a + b; // error : cannot convert from int to byte
        b += a; // ok
    }
}
