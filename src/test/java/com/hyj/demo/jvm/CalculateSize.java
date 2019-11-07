package com.hyj.demo.jvm;

import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

public class CalculateSize {

    /**
     * lucene core里面的RamUsageEstimator来计算大小，shallowSizeOf 计算自身引用的大小，humanSizeOf所引用的对象大小
     */
    @Test
    public void testSize() {
        Map map = new HashMap();
        //jdk 计算对象占用的内存大小 返回值单位为byte
        long size = getObjectSize(map);
        System.out.println(size);
        //Lucene包 计算对象占用的内存大小 返回值单位为byte
        String s = RamUsageEstimator.humanSizeOf(map);
        System.out.println("s:" + s);
        for (int i = 0; i < 1000000; i++) {
            map.put(i, "1");
        }
        size = getObjectSize(map);
        System.out.println(size);

        s = RamUsageEstimator.humanSizeOf(map);
        System.out.println("s:" + s);
    }
}
