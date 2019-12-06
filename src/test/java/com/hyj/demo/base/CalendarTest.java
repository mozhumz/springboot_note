package com.hyj.demo.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	private static int getDifference(String start, String end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String str1 = start.substring(0, 7);
//		String str2 = end.substring(0, 7);
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		try {
			bef.setTime(sdf.parse(start));
			aft.setTime(sdf.parse(end));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		return Math.abs(month + result);
	}

	public static void main(String[] args) {
		String start="20190101000000";
		String end="20190201000000";
		System.out.println(getDifference(start,end));
	}
}
