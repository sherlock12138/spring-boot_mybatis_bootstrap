package com.gdut.dongjun.domain.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName HistoryDataTransfer.java
 *@Time 2016年2月27日下午8:08:15
 *@Description 历史转移数据Dao
 *@Version 1.0 Topview
 */
@Repository
public class HistoryDataTransfer {
	
	@Resource(name = "msg_sqlSessionTemplate")
	protected SqlSessionTemplate template;
	
	private static final String namespace = 
			"com.gdut.dongjun.domain.dao.HistoryDataTransfer.";
	
	/**
	 * 间隔时间
	 */
	private int interval = 8;
	
	/**
	 * <code>unit</code>的值相对应不同时间单位
	 * 1代表天
	 * 2代表小时
	 */
	private int unit = 2;

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public void setUnit(int unit) {
		if(unit >= 1 && unit <= 2) {
			this.unit = unit;
		}
	}
	
	public void transferData() {
		
		int result = 0;
		
		result = template.insert(getStatement(namespace + "TransferHighVoltageVoltage")
				, interval);
		if(result != 0) {
			template.delete(getStatement(namespace + "deleteOlderHighVoltageVoltage")
				, interval);
		}
		
		result = template.insert(getStatement(namespace + "TransferHighVoltageCurrent")
				, interval);
		if(result != 0) {
			template.delete(getStatement(namespace + "deleteOlderHighVoltageCurrent")
				, interval);
		}
	}
	
	private String getStatement(String statement) {
		switch(unit) {
		case 1 : return statement + "ByDay";
		case 2 : return statement + "ByHour";
		default : return statement;
		}
	}
}
