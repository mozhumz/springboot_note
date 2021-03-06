package com.hyj.demo.base;

import com.hyj.demo.model.po.Aoo;
import com.hyj.demo.test.Boo;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MapTest {
    @Test
    public void test(){
        Map<String,String> map = new TreeMap<String,String>();
        map.put("a", "dddd");
        map.put("d", "aaaa");
        map.put("b", "cccc");
        map.put("c", "bbbb");

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, String> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }

    }

    /**
     *
     */
    @Test
    public  void testTree() {
        Map<String,Object> map = new TreeMap<String,Object>();
        Set set=new TreeSet();
        map.put("ss",new Boo());
        map.put("ss2",new Boo());
        set.add(new Boo());

        System.out.println("ok");
    }

    @Test
    public void testEq(){
        HashMap<String, String>map1=new HashMap<>();
        map1.put("k","1");
        HashMap<String, String>map2=new HashMap<>();
        map2.put("k","k");
        System.out.println(map1.equals(map2));
    }

    @Test
    public void testCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map map=new HashMap();
        Method method=map.getClass().getDeclaredMethod("capacity");
        method.setAccessible(true);
        System.out.println(method.invoke(map));
        map.put("1",1);
        System.out.println(method.invoke(map));
    }

    @Test
    public void testEq2(){
        Map map=new HashMap();
        Aoo aoo1=new Aoo();
        aoo1.setName("1");

        Aoo aoo2=new Aoo();
        aoo1.setName("2");
        map.put(aoo1,1);
        map.put(aoo2,2);
        System.out.println(1);
    }
}