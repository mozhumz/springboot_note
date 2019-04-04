package com.hyj.demo.test;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.stereotype.Component;
import com.hyj.demo.constant.OutExcelEnum;
import com.hyj.demo.entity.po.po1.UserPO;
import com.hyj.demo.vo.Student;

import lombok.Data;

/**
 * 
 * @author Administrator
 *
 */
@Component
public class TestCase {
	private int count = 0;

	@Test
	public void testDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date()));
	}

	@Test
	public void testCeil() {
		double total = 1002;
		int totalPage = (int) Math.ceil(total / 1000);
		System.out.println(totalPage);
	}

	@Test
	public void testEnum() {
		OutExcelEnum e = OutExcelEnum.DORM_INFO_LIST2;
		switch (e) {
		case DORM_INFO_LIST:
			System.out.println("ok");
			break;

		default:
			System.out.println("default");
			break;
		}
	}

	@Test
	public void testLombok2Str() {
		System.out.println(new UserPO());
	}

	@Test
	public void testStr() {
		String str = ",1,22,";

		System.out.println(str.contains(",2,"));
	}

	@Test
	public void testTreeSet() {
		String str = ",1,22,";
		TreeSet<Student> s = new TreeSet<>();
		s.add(new Student(2));
		s.add(new Student(4));
		s.add(new Student(1));
		System.out.println(s);
	}

	/**
	 * 
	 */
	@Test
	public void testList() {
		// Collections.swap(data,index1,index2)
		ArrayList<String> strList = new ArrayList();
		strList.add("序列1");
		strList.add("序列2");
		strList.add("序列3");
		strList.add("序列4");
		strList.add("序列4");
		for (String s : strList) {
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
		//去重
		List<String> list= strList.stream().distinct().collect(Collectors.toList());
		System.out.println();
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
		// Collections.swap(strList,0,2);
		strList.add(0, "-1");
		strList.remove(strList.size() - 1);
		for (String s : strList) {
			System.out.println(s);
		}
	}

	@Test
	public void testInt() {
		// Double a=8.0;
		// int b=a.intValue();
		System.out.println(new ArrayList<>().get(0));
	}

	@Test
	public void testDate2() {
		SimpleDateFormat sdf = new SimpleDateFormat("");
		System.out.println("hahah");
	}

	@Test
	public void testFile() {
		File file = new File("src/main/resources/tempFile");
		if (!file.exists()) {
			file.mkdirs();
		}
		System.out.println(file.exists());
	}

	@Test
	public void testInt2() {
		int a = (int) ((5.5 + 6) / 2);
		System.out.println(a);
	}

	@Test
	public void test10To16() {
		to16(249, 99, 102);
	}

	@Test
	public void test16To10() {
		System.out.println(0xf9 + "," + 0xF0 + "," + 0xFF);
	}

	/**
	 * 数字转16进制
	 * 
	 * @param nums
	 */
	public void to16(int... nums) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i : nums) {
			sBuilder.append(Integer.toHexString(i).toUpperCase());
		}
		System.out.println(sBuilder.toString());
	}

	@Test
	public void test1101() {
		List<String> list1 = new ArrayList<>();
		list1.add("1");
		list1.add("2");

		List<String> list2 = new ArrayList<>();
		list2.add("3");
		list2.add("4");

		Aoo aoo = new Aoo();
		aoo.setList(list1);
		Set set = getCombinedSet(list1, list2);
		System.out.println(set);
		list1.clear();
		System.out.println(set);
		System.out.println(list1);
		System.out.println(aoo);
	}
	
	@Test
	public void testCmd()  {
		Byte a=1;
		Integer b=a.intValue();
		System.out.println(b);
	}
	
	
	

	public static Set getCombinedSet(List list1, List list2) {
		Set set = new HashSet<>();

		if (list1 != null && !list1.isEmpty()) {
			set.addAll(list1);
		}

		if (list2 != null && !list2.isEmpty()) {
			set.addAll(list2);
		}
		return set;
	}
	
	

}

@Data
class Aoo {
	List<String> list;
}
