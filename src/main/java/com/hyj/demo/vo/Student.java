package com.hyj.demo.vo;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {  
    private String name;  
    private int age;  
  
    @Override  
    public int compareTo(Student s) {  
        //return -1; //-1表示放在红黑树的左边,即逆序输出  
        //return 1;  //1表示放在红黑树的右边，即顺序输出  
        //return o;  //表示元素相同，仅存放第一个元素  
       return this.age-s.age;  
    }

	public Student(int age) {
		this.age=age;
	}  
      
} 
