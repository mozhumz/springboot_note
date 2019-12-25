package com.hyj.demo.util;

import java.io.*;
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
}
