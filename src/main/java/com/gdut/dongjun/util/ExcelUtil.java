package com.gdut.dongjun.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {

	private static final int DEFAULT_ROW_BEGIN = 1;

	/**
	 * 写入表头信息
	 */
	private void writeHeader(HSSFWorkbook hssfWorkbook, HSSFSheet hssfSheet,
			List<String> headList) {
		// 处理excel表头
		HSSFRow r = hssfSheet.createRow(0);
		HSSFCell cell = null;

		for (int i = 0; i < headList.size(); i++) {
			cell = r.createCell(i);

			HSSFCellStyle cellStyle2 = hssfWorkbook.createCellStyle();
			HSSFDataFormat format = hssfWorkbook.createDataFormat();
			cellStyle2.setDataFormat(format.getFormat("@"));
			cell.setCellStyle(cellStyle2);

			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(headList.get(i));
			// setCellValue(cell, );
		}
	}

	/**
	 * 写入内容部分
	 */
	private <T> void writeContent(HSSFWorkbook hssfWorkbook,
			HSSFSheet hssfSheet, int startRow, Map<String, String> headListMap,
			List<String> headList, List<T> dataList, Class<?> clazz) {
		HSSFRow row = null;
		HSSFCell cell = null;
		Field filed = null;
		Object value = null;
		startRow = startRow >= 1 ? startRow : DEFAULT_ROW_BEGIN;

		try {
			if (dataList != null) {

				for (int i = startRow; i <= dataList.size(); i++) {
					row = hssfSheet.createRow(i);
					for (int j = 0; j < headList.size(); j++) {
						filed = clazz.getDeclaredField(headListMap.get(headList
								.get(j)));
						filed.setAccessible(true);
						cell = row.createCell(j);
						value = filed.get(dataList.get(i - 1)); // 数据集合下标是从0开始的
						setCellValue(cell, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setCellValue(HSSFCell cell, Object value) {
		if (value != null) {
			if (value instanceof Boolean) {
				cell.setCellValue((Boolean) value);
			} else if (value instanceof Integer) {
				cell.setCellValue((Integer) value);
			} else if (value instanceof Long) {
				cell.setCellValue((Long) value);
			} else if (value instanceof Float) {
				cell.setCellValue((Float) value);
			} else if (value instanceof Double) {
				cell.setCellValue((Double) value);
			} else if (value instanceof Date) {
				cell.setCellValue((Date) value);
			} else if (value instanceof Double) {
				cell.setCellValue((Double) value);
			} else {
				cell.setCellValue(value.toString());
			}
		}
	}

	@SuppressWarnings("unused")
	private <T> void setField(Field field, T t, HSSFCell cell) throws Exception {
		DecimalFormat intFormat = new DecimalFormat("#");
		if (field.getType() == Boolean.class) {
			field.set(t, cell.getBooleanCellValue());
		} else if (field.getType() == Integer.class
				|| field.getType() == int.class) {
			field.set(t, Integer.parseInt(intFormat.format(cell
					.getNumericCellValue())));
		} else if (field.getType() == Long.class
				|| field.getType() == long.class) {
			field.set(t, Integer.parseInt(intFormat.format(cell
					.getNumericCellValue())));
		} else if (field.getType() == Float.class
				|| field.getType() == float.class) {
			field.set(t, cell.getNumericCellValue());
		} else if (field.getType() == Double.class
				|| field.getType() == double.class) {

			double cellValue = cell.getNumericCellValue();
			field.set(t, new DecimalFormat("#").format(cellValue));
		} else if (field.getType() == Date.class) {
			field.set(t, cell.getDateCellValue());
		} else {
			field.set(t, cell.getStringCellValue());
		}
		// 取值后会带一个E的问题

	}

	/**
	 * 将数据写入Excel
	 */
	private void writeFile(HSSFWorkbook hssfWorkbook, String filePath)
			throws Exception {
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(filePath);
			hssfWorkbook.write(fileOut);
		} finally {
			if (fileOut != null) {
				fileOut.close();
			}
		}
	}

	/**
	 * 从Excel中读取数据
	 */
	private <T> List<T> readContent(HSSFSheet sheet,
			Map<String, String> headListMap, List<String> headList,
			Class<T> clazz) throws Exception {
		List<T> list = new ArrayList<T>();
		HSSFRow row = null;
		Field field = null;

		int rows = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < rows; i++) {
			row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			T t = clazz.newInstance();

			for (int j = 0; j < headList.size(); j++) {
				field = clazz
						.getDeclaredField(headListMap.get(headList.get(j)));
				field.setAccessible(true);

				HSSFCell cell = row.getCell(j);
				if (null != cell) {
					switch (cell.getCellType()) {

					case HSSFCell.CELL_TYPE_STRING: // 字符串
						field.set(t, cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_NUMERIC: // 数字
						
						//**************************************
						//跟映射字段的类型不同经常报
						//argument type mismatch
						//**************************************
						
						//数字也当作字符串读进来，再做类型转换
						String doubleVal = new DecimalFormat("#").format(cell
								.getNumericCellValue());
						field.set(t, doubleVal);
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
						field.set(t, cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA: // 公式
						field.set(t, cell.getCellFormula());
						break;
					case HSSFCell.CELL_TYPE_BLANK: // 空值
						break;
					case HSSFCell.CELL_TYPE_ERROR: // 故障
						break;
					default:
						System.out.print("Excel 读取遇到未知类型 数据 ");
						break;
					}
				} else {
				}

			}
			list.add(t);
		}
		return list;
	}

	/**
	 * 读取文件
	 */
	private HSSFWorkbook readFile(String filePath) throws Exception {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			return new HSSFWorkbook(fis);
		} finally {
			fis.close();
		}
	}

	/**
	 * 导出Excel 1、创建excel 文本文件及sheet对象 2、将数据按照属性值写入excel文本对象 3、输出excel文本对象
	 * 
	 * @param sheetName
	 *            sheet名字
	 * @param filePath
	 *            文本地址
	 * @param headListMap
	 *            key为excel列头名、value为对象对应的属性名
	 * @param headList
	 *            excel列头名集合，按照excel顺序
	 * @param dataList
	 *            数据集合
	 * @param rowStart
	 *            开始写入行
	 * @param clazz
	 *            处理对象Class对象
	 */
	public <T> void exportExcel(String sheetName, String filePath,
			Map<String, String> headListMap, List<String> headList,
			List<T> dataList, int rowStart, Class<T> clazz) throws Exception {

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		HSSFSheet hssfSheet = hssfWorkbook.createSheet(sheetName);
		writeHeader(hssfWorkbook, hssfSheet, headList);
		writeContent(hssfWorkbook, hssfSheet, rowStart, headListMap, headList,
				dataList, clazz);
		writeFile(hssfWorkbook, filePath);
	}

	/**
	 * 导入Excel 1、读取excel文本 2、逐行读取excel文本，并读取结果返回
	 * 
	 * @param sheetName
	 *            sheet名字
	 * @param filePath
	 *            文本地址
	 * @param headListMap
	 *            key为excel列头名、value为对象对应的属性名
	 * @param headList
	 *            excel列头名集合，按照excel顺序
	 * @param clazz
	 *            处理对象Class对象
	 */
	public <T> List<T> importExcel(String sheetName, String filePath,
			Map<String, String> headListMap, List<String> headList,
			Class<T> clazz) throws Exception {

		HSSFSheet sheet = readFile(filePath).getSheet(sheetName);
		List<T> result = readContent(sheet, headListMap, headList, clazz);
		return result;
	}

	// public static void main(String[] args) {

	// //导出测试
	// List<String> headList = new ArrayList<String>();
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("名字", "name");
	// map.put("年龄", "age");
	// map.put("体重", "weight");
	// headList.add("名字");
	// headList.add("年龄");
	// headList.add("体重");
	//
	// List<User> dataList = new ArrayList<User>();
	// dataList.add(new User("Joeson1", 12, 12111111111111.0));
	// dataList.add(new User("Joeson2", 13, 1311111111111111.0));
	// dataList.add(new User("Joeson3", 14, 1411111111111.0));
	// dataList.add(new User("Joeson4", 15, 151111111111111.0));
	// dataList.add(new User("Joeson5", 16, 16111111111111.0));
	// dataList.add(new User("Joeson6", 17, 171111111111111.0));
	//
	// ExcelUtil poi = new ExcelUtil();
	// String filePath = "D:/test.xls";
	// String sheetName = "testSheet1";
	// try {
	// poi.exportExcel(sheetName, filePath, map, headList, dataList, 1,
	// User.class);
	// } catch (Exception e) { // TODO Auto-generated
	// e.printStackTrace();
	// }

	// //写入测试
	// User user = new User();
	// List<String> headList = new ArrayList<String>(); Map<String, String> map
	// = new HashMap<String, String>(); map.put("名字", "name");
	// map.put("年龄", "age");map.put("体重", "weight"); headList.add("名字");
	// headList.add("年龄");headList.add("体重");
	// List<User> list = new ArrayList<User>();
	// ExcelUtil poi = new ExcelUtil();
	// List<User> result = null;
	// try {
	// result = (List<User>) poi.importExcel("testSheet1","D:/test.xls", map,
	// headList,
	// user.getClass());
	// for (User user2 : result) {
	// System.out.println(user2.toString());
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// System.out.println("==========end==========");

	// }
}
