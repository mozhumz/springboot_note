package com.hyj.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Task1 extends TimerTask{
	static Timer timer=new Timer();
	@Override
	public void run() {
		System.out.println("task1");
	}
	
	public static void main(String[] args) {
		 int num= (int) Math.ceil(255.0/100);
		System.out.println(num);
		List<String>list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(""+i);
		}
		List<String> subList=list.subList(5,list.size()-1);
		for(String s:subList) {
			s="--";
		}
		System.out.println(list);
		
	}

}
