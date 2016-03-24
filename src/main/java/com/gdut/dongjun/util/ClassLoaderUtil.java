package com.gdut.dongjun.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


//获取项目外部资源工具类（最好改成从属性文件读取）
public class ClassLoaderUtil {

	private static Log log = LogFactory.getLog(ClassLoaderUtil.class);

	/**
	 * 得到类加载器
	 * 
	 * @return
	 */

	public static ClassLoader getClassLoader() {
		return ClassLoaderUtil.class.getClassLoader();
	}




	/**
	 * 得到本Class所在的ClassLoader的Classpath的绝对路径。 
	 * @return
	 */
	public static String getAbsolutePathOfClassLoaderClassPath() {
//		ClassLoaderUtil.log.info(ClassLoaderUtil.getClassLoader()
//				.getResource("").toString());
		return ClassLoaderUtil.getClassLoader().getResource("").toString();
	}

	/**
	 * @param relativePath 是相对于classpath的路径。查找classpath外部的资源需要使用 ../来查找
	 * @return资源的绝对URL的String形式
	 * @throws MalformedURLException
	 */
	public static String getExtendResource(String relativePath, String projectName)
			throws MalformedURLException {
		
		ClassLoaderUtil.log.info("传入的相对路径：" + relativePath);
		
		if (!relativePath.contains("../")) {
			return ClassLoaderUtil.getResource(relativePath).toString();
		}
		
		String classPathAbsolutePath = ClassLoaderUtil
				.getAbsolutePathOfClassLoaderClassPath();
		try {
			classPathAbsolutePath = URLDecoder.decode(classPathAbsolutePath,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (relativePath.substring(0, 1).equals("/")) {
			relativePath = relativePath.substring(1);
		}
//		ClassLoaderUtil.log.info(Integer.valueOf(relativePath
//				.lastIndexOf("../")));
		String wildcardString = relativePath.substring(0,
				relativePath.lastIndexOf("../") + 3);
		relativePath = relativePath
				.substring(relativePath.lastIndexOf("../") + 3);
		int containSum = ClassLoaderUtil.containSum(wildcardString, "../");
		classPathAbsolutePath = ClassLoaderUtil.cutLastString(
				classPathAbsolutePath, "/", containSum);
		int index = classPathAbsolutePath.lastIndexOf(projectName);  //计算项目名出现的下标
		
		if(index == -1){
			
			ClassLoaderUtil.log.info("项目名称写错");
			return "";
		}
		classPathAbsolutePath = classPathAbsolutePath.substring(0, index); //把项目名截掉，即将绝对路径保留至项目的同一级目录
		String resourceAbsolutePath = classPathAbsolutePath + relativePath; //加上相对路径拼成完整的绝对路径（前面还保留有file:/）
		resourceAbsolutePath = resourceAbsolutePath.substring(6); //截取掉file:/
		ClassLoaderUtil.log.info("找到的绝对路径：" + resourceAbsolutePath);
		return resourceAbsolutePath;
	}

	/**
	 * @paramsource
	 * @paramdest
	 * @return
	 */
	private static int containSum(String source, String dest) {
		int containSum = 0;
		int destLength = dest.length();
		while (source.contains(dest)) {
			containSum = containSum + 1;
			source = source.substring(destLength);
		}
		return containSum;
	}

	/**
	 * @param source
	 * @param dest
	 * @param num
	 * @return
	 */
	private static String cutLastString(String source, String dest, int num) {
		for (int i = 0; i < num; i++) {
			source = source.substring(0,
					source.lastIndexOf(dest, source.length() - 2) + 1);
		}
		return source;
	}

	/**
	 * @paramresource
	 * @return
	 */
	public static URL getResource(String resource) {
		ClassLoaderUtil.log.info("传入的相对于classpath的路径：" + resource);
		return ClassLoaderUtil.getClassLoader().getResource(resource);
	}

}
