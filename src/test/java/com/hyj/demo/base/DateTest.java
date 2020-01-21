package com.hyj.demo.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//		ZonedDateTime dateTime=new ZonedDateTime();
//		System.out.println(new Date());
//		Date date=new Date();
//		System.out.println(sdf.format(date));


		Date curr_date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr_date);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		calendar.add(Calendar.DATE, -1);
		System.out.println(sdf.format(calendar.getTime()));
	}
}
