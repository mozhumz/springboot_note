package com.hyj.demo.base;

import org.junit.Test;

import java.util.*;

public class ListTest {
    @Test
    public void testAdd() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("1", 1);
        list.add(map);
        System.out.println(list);
        map.put("2", 2);

        System.out.println(list);
    }

    @Test
    public void testRemove() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        Iterator<String> iterator = list.iterator();//实例化迭代器
        while (iterator.hasNext()) {
            //不合法 未调用iterator.next()
//            iterator.remove();
            String str = iterator.next();//读取当前集合数据元素
            if ("b".equals(str)) {
//                list.remove(str); 该方法会中断循环
                iterator.remove();//该方法不会中断循环
            } else {
                System.out.println(str + " ");
            }
        }
        System.out.println("\n删除\"b\"之后的集合当中的数据为:" + list);
    }

    @Test
    public void testArrAndLinkedList() {
        ArrayList arr=new ArrayList();
        LinkedList linked=new LinkedList();
        long ms1=System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            arr.add(new Object());
        }
        System.out.println("arr-ms:"+(System.currentTimeMillis()-ms1));

        long ms2=System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            linked.add(new Object());
        }
        System.out.println("linked-ms:"+(System.currentTimeMillis()-ms2));

        long ms3=System.currentTimeMillis();
        arr.get(10000000-5000000);
        System.out.println("get-linked-ms:"+(System.currentTimeMillis()-ms3));

        long ms4=System.currentTimeMillis();
        linked.get(10000000-5000000);
        System.out.println("get-linked-ms:"+(System.currentTimeMillis()-ms4));
    }



}

