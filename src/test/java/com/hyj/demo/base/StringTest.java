package com.hyj.demo.base;

import org.junit.Test;

import java.util.Arrays;

public class StringTest {
    @Test
    public void testStr() {
        String s = "ss";
        String str = new String("ww");
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder("ss");
    }

    @Test
    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer("ss123");
//        stringBuffer.reverse();
//        System.out.println(stringBuffer);
        stringBuffer.append("s");
    }

    @Test
    public void testChar() {
//        final char[] val = new char[10];
//        char[] val2 = new char[10];
//        char[]val_c=Arrays.copyOf(val, 20);
//        char[]val_c2=Arrays.copyOf(val2, 20);
//
//        System.out.println(val==val_c);
//        System.out.println(val2==val_c2);

        String str = "saf";
        char[] src = {'s', 'a', 'f'};
        final char[] value = new char[20];
        for (int i = 0; i < 3; i++) {
            value[i] = String.valueOf(i).charAt(0);
        }
        int srcBegin = 0;
        int srcEnd = str.length();
        str.getChars(0, str.length(), value, 3);
        System.arraycopy(src, 0, value, 3, srcEnd - srcBegin);
        System.out.println(value);

    }
}