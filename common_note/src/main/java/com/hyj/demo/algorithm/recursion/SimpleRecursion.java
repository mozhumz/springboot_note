package com.hyj.demo.algorithm.recursion;
import org.junit.Test;

/**
 * @author mozhumz
 * @date 2018年10月16日 上午10:04:09 简单算法
 */
public class SimpleRecursion {
	private int sum = 0;

	@Test
	public void testSum() {
		int sum0 = 0;
		for (int i = 0; i <= 10; i++) {
			sum0 += i;
		}
		System.out.println(sum0);
		System.out.println(sum1(0));
		System.out.println(sum3(1,3));
	}

	public int sum1(int start) {
		if (start <= 10) {
			sum += start;
			sum1(++start);
		}
		return sum;
	}

	public static int sum2(int num) {
		if (1 == num) {
			return 1;
		} else {
			return num + sum2(num - 1);
		}
	}
	
	/**
	 * 累加
	 * @param start 
	 * @param end
	 * @return
	 */
	public static int sum3(int start,int end){ 
		if(start>end) {
			return start;
		}
	    if(start == end){ 
	      return start; 
	    } else { 
	      return end + sum2(end -1); 
	    } 
	  }

}
