package com.hyj.demo.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

	/**
	 * 去除xml标签之间的空格
	 * @param xml
	 * @return
	 */
	public static String trimXml(String xml) {
		Pattern p = Pattern.compile(">(\\s*|\n|\t|\r)<");
		Matcher m = p.matcher(xml);
		return m.replaceAll("><");
	}

	/**
	 * 文本文件转换为指定编码的字符串
	 *
	 * @param file         文本文件
	 * @param encoding 编码类型
	 * @return 转换后的字符串
	 * @throws IOException
	 */
	public static String file2String(File file, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding == null || "".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file), encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(file));
			}
			//将输入流写入输出流
			char[] buffer = new char[2048];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		//返回转换结果
		if (writer != null)
			return writer.toString();
		else return null;
	}


	/**
	 * 实体类转map
	 *
	 * @param obj obj
	 * @return Map Map
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		List<Field> declaredFields = getFields(obj.getClass());
		for (Field field : declaredFields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(obj));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static List<Field> getFields(Class clazz){
		List fieldsList = new ArrayList<Field>();
		while (clazz != null) {  // 遍历所有父类字节码对象
			Field[] declaredFields = clazz.getDeclaredFields();
			fieldsList.addAll(Arrays.asList(declaredFields));  //将`Filed[]`数组转换为`List<>`然后再将其拼接至`ArrayList`上

			clazz = clazz.getSuperclass();  // 获得父类的字节码对象
		}
		return fieldsList;
	}

	/**
	 * map转实体
	 *
	 * @param map map
	 * @param beanClass beanClass
	 * @return Object Object
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
		if (map == null)
			return null;
		Object obj = null;
		try {
			obj = beanClass.newInstance();
			List<Field> fields = getFields(obj.getClass());
			for (Field field : fields) {
				int mod = field.getModifiers();
				if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
					continue;
				}

				field.setAccessible(true);
				if (map.get(field.getName()) == null) {
					continue;
				}
				field.set(obj, map.get(field.getName()));
			}
		} catch (Exception e) {
			throw new RuntimeException("系统错误");
		}

		return obj;
	}

	public static String initLog(String s){
		System.out.println(s);
		return null;
	}

}
