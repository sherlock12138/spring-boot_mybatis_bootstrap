package com.gdut.dongjun.util;

import java.util.List;

/**
 * @Title: Array_ListUtil.java
 * @Package com.gdut.dongjun.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月26日 下午8:41:45
 * @version V1.0
 */
public class Array_ListUtil {
	/**
	 * @param <T>
	 * 
	 * @Title: list2DyadicArray
	 * @Description: 将list转换成二维数组，限定数组的列数
	 * @param @param list
	 * @param @param m
	 * @param @return
	 * @return String[][]
	 * @throws
	 */
	public static Object[][] list2DyadicArrayColumnRestrict(List<Object> list,
			int m) {

		int row = 0;
		int size = list.size();
		if (size % m != 0)
			row = size / m + 1;
		else
			row = size / m;

		Object[][] dyadicArray = new Object[row][m];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < m; j++) {
				if (m * i + j < size)
					dyadicArray[i][j] = list.get(m * i + j);
			}
		}
		return dyadicArray;
	}

	/**
	 * 
	 * @Title: list2DyadicArrayColumnRestrict
	 * @Description: TODO
	 * @param @param list
	 * @param @param m
	 * @param @return
	 * @return String[][]
	 * @throws
	 */
	public static Object[][] list2DyadicArrayRowRestrict(List<Object> list,
			int m) {

		int column = 0;
		int size = list.size();
		if (size % m != 0)
			column = size / m + 1;
		else
			column = size / m;

		Object[][] dyadicArray = new Object[m][column];
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < m; j++) {
				if (m * i + j < size)
					dyadicArray[j][i] = list.get(m * i + j);
			}
		}
		return dyadicArray;
	}

	/**
	 * 
	 * @Title: printDyadicArray
	 * @Description: 打印二维数组
	 * @param @param arrray
	 * @return void
	 * @throws
	 */
	public void printDyadicArray(Object[][] arrray) {

		for (int i = 0; i < arrray.length; i++) {
			for (int j = 0; j < arrray[0].length; j++) {
				System.out.print(arrray[i][j]);
				if (j == arrray[0].length - 1)
					System.out.println();
			}
		}

	}


}
