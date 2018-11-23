package com.hyj.demo.excel;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import com.hyj.demo.entity.po.po1.UserPO;

public class ExcelTest {  
	@Test
	public void test1() {
		try {
			// 创建HSSFWorkbook对象
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建HSSFSheet对象
			HSSFSheet sheet = wb.createSheet("sheet0");
			// 创建HSSFRow对象
			HSSFRow row = sheet.createRow(0);
			// 创建HSSFCell对象
			HSSFCell cell = row.createCell(0);
			// 设置单元格的值
			cell.setCellValue("单元格中的中文");
			// 输出Excel文件
			FileOutputStream output = new FileOutputStream("f:/temp/workbook.xls");
			wb.write(output);
			output.flush();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void TestClass(){
		Class s=UserPO.class;
		System.out.println(s.getClass()==UserPO.class.getClass());
	}
	
	@Test
	public void test2() throws Exception {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("成绩表");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);

		// 创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");
		row2.createCell(4).setCellValue("列表test");
		row2.createCell(5).setCellValue("列表test2");
		// 在sheet里创建第三行
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("李明\n张三");
		CellStyle cs = wb.createCellStyle();
	    cs.setWrapText(true);
	    row3.getCell(0).setCellStyle(cs);

		row3.createCell(1).setCellValue("As178");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);

		HSSFRow row = null;
		for (int i = 3; i < 6; i++) {

			if (i == 3) {
				row = sheet.getRow(i - 1);
			} else {
				row = sheet.createRow(i - 1);
			}
			row.createCell(4).setCellValue(i);
		}

		addRow(sheet);
		// .....省略部分代码
		// 输出Excel文件
		FileOutputStream output = new FileOutputStream("f:/temp/workbook3.xls");
		wb.write(output);
		output.flush();
		System.out.println("ok");
		// 输出Excel文件
		// OutputStream output=response.getOutputStream();
		// response.reset();
		// response.setHeader("Content-disposition", "attachment;
		// filename=details.xls");
		// response.setContentType("application/msexcel");
		// wkb.write(output);
		// output.close();
	}

	private void addRow(HSSFSheet sheet) {
		HSSFRow row;
		for (int i = 3; i < 8; i++) {

				row = sheet.getRow(i - 1);
				if(row==null){
					
					row = sheet.createRow(i - 1);
				}
			row.createCell(5).setCellValue(i);
		}
	}
	@Test
	public void testln(){
		System.out.println("sss\nsss");
	}
}
