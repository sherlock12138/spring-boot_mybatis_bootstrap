package com.gdut.dongjun.domain.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gdut.dongjun.util.GenericUtil;
import com.gdut.dongjun.util.TimeUtil;

/**
 *@Author link xiaoMian <972192420@qq.com>
 *@ClassName SwitchTableData.java
 *@Time 2016年3月7日下午9:47:26
 *@Description 呵呵哒的数据库表数据前端获取vo类
 *@Version 1.0 Topview
 */
public class SwitchTableData {
	
	//private String id;
	
	private String time;
	
	private Float aValue;
	
	private Float bValue;
	
	private Float cValue;
	
	public <T> List<SwitchTableData> getJsonTable(List<T> data) {
		
		List<SwitchTableData> result = new ArrayList<>();
		SwitchTableData tempData = null;
		Object chase;
		
		for(int length = data.size(), i = length - 1, count = 0; i >= 0;--i) {
			
			chase = GenericUtil.getPrivateObjectValue(data.get(i), "phase");
			if(count == 0) {
				tempData = new SwitchTableData();
				//tempData.setId(GenericUtil.getPrivateObjectValue(data.get(i), "switchId").toString());
				tempData.setTime(TimeUtil.timeFormat(
						(Date)GenericUtil.getPrivateObjectValue(data.get(i), "time"), "yyyy-MM-dd HH:mm:ss"));
			}
			switch(chase.toString().charAt(0)) {
			case 'A' : tempData.setaValue(getFloatValue(
					GenericUtil.getPrivatyIntegerValue(data.get(i), "value")));++count;break;
			case 'B' : tempData.setbValue(getFloatValue(
					GenericUtil.getPrivatyIntegerValue(data.get(i), "value")));++count;break;
			case 'C' : tempData.setcValue(getFloatValue(
					GenericUtil.getPrivatyIntegerValue(data.get(i), "value")));++count;break;
			}
			if(count == 3) {
				result.add(tempData);
				count = 0;
			}
		}
		return result;
	}
	
	private float getFloatValue(Integer value) {
		
		BigDecimal decimal = new BigDecimal(value);
		return decimal.divide(new BigDecimal(100)).floatValue();
	}

/*	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}*/
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

	public Float getaValue() {
		return aValue;
	}

	public void setaValue(Float aValue) {
		this.aValue = aValue;
	}

	public Float getbValue() {
		return bValue;
	}

	public void setbValue(Float bValue) {
		this.bValue = bValue;
	}

	public Float getcValue() {
		return cValue;
	}

	public void setcValue(Float cValue) {
		this.cValue = cValue;
	}
}
