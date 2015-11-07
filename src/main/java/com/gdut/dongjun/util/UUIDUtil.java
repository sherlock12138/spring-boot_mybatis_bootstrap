package com.gdut.dongjun.util;

import java.util.UUID;

/**
 * 
 * 项目名称：school  <br>
 * 类名称：UUIDUtil  <br>
 * 类描述：  生成主键UUID<br>
 * 创建人：luozhangjie  <br>
 * 创建时间：2015年4月1日 下午3:53:25  <br>
 * 修改人：luozhangjie<br>
 * 修改时间：2015年4月1日 下午3:53:25  <br>
 * 修改备注：  <br>
 * @version 1.0  <br>
 *
 */
public class UUIDUtil {

	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
