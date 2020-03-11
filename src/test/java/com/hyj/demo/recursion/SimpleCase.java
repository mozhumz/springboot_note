package com.hyj.demo.recursion;

import org.junit.Test;

public class SimpleCase {
    /**
     * 给定一个非负整数 计算各位数字之和
     *
     * @param n
     * @return
     */
    public int getSumNum(int n) {
        if (n > 9) {
            return n % 10 + getSumNum(n / 10);
        }
        return n;
    }

    @Test
    public void test1() {
        System.out.println(getSumNum(123456));
    }
}
