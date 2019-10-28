package com.hyj.demo.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {
    @Test
    public void testAdd(){
        List list=new ArrayList();
        Map map=new HashMap();
        map.put("1",1);
        list.add(map);
        System.out.println(list);
        map.put("2",2);

        System.out.println(list);
    }

}
