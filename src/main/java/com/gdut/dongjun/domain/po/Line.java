package com.gdut.dongjun.domain.po;

import java.util.LinkedList;
import java.util.List;

/**
 * @Title: Wire.java
 * @Package com.gdut.dongjun.domain.po
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午1:55:08
 * @version V1.0
 */
public class Line {
	/**
	 * @ClassName: Wire
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午1:55:08
	 */
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<Object> convert2Object(List<Line> lines) {

		List<Object> objects = new LinkedList<Object>();
		for (int i = 0; i < lines.size(); i++) {
			objects.add(i, lines.get(i));
		}
		return objects;
	}

	public static List<String> getNames(List<Line> lines) {

		List<String> list = new LinkedList<String>();
		if (lines != null) {
			for (Line line : lines) {
				list.add(line.getName());
			}
		}
		return list;
	}

}
