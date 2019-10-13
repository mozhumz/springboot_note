package com.hyj.demo.base;

import com.hyj.demo.model.po.Aoo;
import org.junit.Test;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BaseCase {
    @Test
    public void testInt() {
        Integer a = -128;
        Integer b = -128;
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void testEq() {
        Aoo aoo1 = new Aoo();
        aoo1.setName("a1");
        aoo1.setId(1L);
        aoo1.setName("ss");
        Aoo aoo2 = new Aoo();
        aoo2.setId(2L);
        aoo2.setName("a2");

        System.out.println(aoo1.equals(aoo2));

//        HashMap hashMap=new HashMap();
//        hashMap.put(aoo1,aoo1);

    }

    /**
     * +=操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型,而a=a+b则不会自动进行类型转换
     */
    @Test
    public void testByte() {
        byte a = 127;
        byte b = 127;
//        b = a + b; // error : cannot convert from int to byte
        b += a; // ok

        short s1 = 1;

    }

    @Test
    public void testReturn0() {
        System.out.println(testReturn());
    }

    public int testReturn() {
        int res = 2;
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            return res;
        } finally {
            res++;
        }
    }

    /**
     * 强引用 软引用 弱引用 虚引用
     */
    @Test
    public void testReference() {
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }

    @Test
    public void MathRound() {
        System.out.println(Math.round(-1.5));

    }

    @Test
    public void sort1() {
        int[] numbers=new int[]{1,5,8,2,3,9,4};
        bubbleSort(numbers,numbers.length);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public void bubbleSort(int a[], int n) {
        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

}
