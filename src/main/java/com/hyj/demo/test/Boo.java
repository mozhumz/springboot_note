package com.hyj.demo.test;

import lombok.Data;

@Data
public class Boo {
		public static int order=1;
		private String id;
		
		private String name;
		
		private Integer c;
		
		public void setName(String name) {
			this.name=name;
			System.out.println("setName:"+(order++));
		}
		
		public void setId(String id) {
			this.id=id;
			System.out.println("setId:"+(order++));
		}
		
		{
			System.out.println("{}:"+(order++));
		}
		
		public static void main(String[] args) {
			Boo boo=new Boo();
			boo.setName("hh");
			boo.setId("1");
		}
}
