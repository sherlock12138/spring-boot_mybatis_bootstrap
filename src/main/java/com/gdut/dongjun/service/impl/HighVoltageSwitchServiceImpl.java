/**
 * 
 */
package com.gdut.dongjun.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.HighVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.service.HighVoltageSwitchService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.ExcelUtil;
import com.gdut.dongjun.util.LatitudeLongitudeMathUtil;
import com.gdut.dongjun.util.UUIDUtil;

/**
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service.impl
 */
@Service
public class HighVoltageSwitchServiceImpl extends
		BaseServiceImpl<HighVoltageSwitch> implements HighVoltageSwitchService {

	@Autowired
	private HighVoltageSwitchMapper currentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#delSwitchByLineId(java
	 * .lang.String)
	 */
	@Override
	public void delSwitchByLineId(String lineId) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#updateSwitch(com.gdut
	 * .dongjun.domain.po.HighVoltageSwitch)
	 */
	@Override
	public void updateSwitch(HighVoltageSwitch switch1) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#isSwitchExist(com.gdut
	 * .dongjun.domain.po.HighVoltageSwitch)
	 */
	@Override
	public boolean isSwitchExist(HighVoltageSwitch switch1) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#getAddress(java.lang
	 * .String)
	 */
	@Override
	public String getAddress(String switchId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#selectByLineId(java
	 * .lang.String)
	 */
	@Override
	public List<HighVoltageSwitch> selectByLineId(String lineId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gdut.dongjun.service.HighVoltageSwitchService#getSwitchId(java.lang
	 * .String)
	 */
	@Override
	public String getSwitchId(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isExist(HighVoltageSwitch record) {

		if (record != null
				&& currentMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean createSwitchExcel(String filePath,
			List<HighVoltageSwitch> object) {

		List<String> headList = createHeadList();// 生成表头
		Map<String, String> map = createHeadListMap();// 生成映射关系
		ExcelUtil poi = new ExcelUtil();
		try {
			poi.exportExcel("Sheet1", filePath, map, headList, object, 1,
					HighVoltageSwitch.class);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 声明excel表的列头
	 * 
	 * @return
	 */
	private List<String> createHeadList() {

		List<String> headList = new ArrayList<String>();
		headList.add("设备号码");
		headList.add("名称");
		headList.add("地址");
		headList.add("经度");
		headList.add("纬度");
		headList.add("SIM号");
		headList.add("线路内序号");
		return headList;
	}

	/**
	 * 声明列头与数据集合的对应关系
	 * 
	 * @return
	 */
	private Map<String, String> createHeadListMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("设备号码", "deviceNumber");
		map.put("名称", "name");
		map.put("地址", "address");
		map.put("经度", "longitude");
		map.put("纬度", "latitude");
		map.put("SIM号", "simNumber");
		map.put("线路内序号", "inlineIndex");
		return map;
	}

	@Override
	public boolean uploadSwitch(String realPath, String lineId) {

		List<String> headList = createHeadList();// 生成表头
		Map<String, String> map = createHeadListMap();// 生成映射关系
		ExcelUtil poi = new ExcelUtil();

		List<com.gdut.dongjun.dto.HighVoltageSwitch> result = new LinkedList<>();
		// 2.解析Excel内容
		try {
			result = poi.importExcel("Sheet1", realPath, map, headList,
					com.gdut.dongjun.dto.HighVoltageSwitch.class);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		for (com.gdut.dongjun.dto.HighVoltageSwitch s : result) {

			HighVoltageSwitch switch1 = new HighVoltageSwitch();
			switch1.setAddress(s.getAddress());
			switch1.setDeviceNumber(s.getDeviceNumber());
			switch1.setId(UUIDUtil.getUUID());
			switch1.setInlineIndex(Integer.parseInt(s.getInlineIndex()));
			switch1.setLatitude(LatitudeLongitudeMathUtil.latlong2float(s
					.getLatitude()));
			switch1.setLongitude(LatitudeLongitudeMathUtil.latlong2float(s
					.getLongitude()));
			switch1.setLineId(lineId);
			switch1.setName(s.getName());
			switch1.setSimNumber(s.getSimNumber());

			currentMapper.insert(switch1);
		}
		return true;
	}

}
