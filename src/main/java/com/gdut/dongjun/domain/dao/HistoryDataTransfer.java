package com.gdut.dongjun.domain.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDataTransfer {
	
	@Resource(name = "msg_sqlSessionTemplate")
	protected SqlSessionTemplate template;
	
	/**
	 * 间隔时间
	 */
	private int interval = 1;

	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public void transferData() {
		
		int result = 0;
		
		result = template.insert(
				"com.gdut.dongjun.domain.dao.HistoryDataTransfer." +
				"TransferHighVoltageVoltage", interval);
		if(result != 0) {
			template.delete(
				"com.gdut.dongjun.domain.dao.HistoryDataTransfer." +
				"deleteOlderHighVoltageVoltage", interval);
		}
		
		result = template.insert(
				"com.gdut.dongjun.domain.dao.HistoryDataTransfer." +
				"TransferHighVoltageCurrent", interval);
		if(result != 0) {
			template.delete(
				"com.gdut.dongjun.domain.dao.HistoryDataTransfer." +
				"deleteOlderHighVoltageCurrent", interval);
		}
	}
}
