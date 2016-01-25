package com.gdut.dongjun.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.ExcelUtil;
import com.gdut.dongjun.util.LatitudeLongitudeMathUtil;
import com.gdut.dongjun.util.MyBatisMapUtil;
import com.gdut.dongjun.util.UUIDUtil;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class LowVoltageSwitchServiceImpl extends
		BaseServiceImpl<LowVoltageSwitch> implements LowVoltageSwitchService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(LowVoltageSwitchServiceImpl.class);

	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private LowVoltageSwitchMapper switchMapper;

	@Override
	public List<LowVoltageSwitch> selectByLineId(String lineId) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll(String) - start"); //$NON-NLS-1$
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("line_id", lineId);
		List<LowVoltageSwitch> list = switchMapper
				.selectByParameters(MyBatisMapUtil.warp(map));
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll(String) - end"); //$NON-NLS-1$
		}
		return list;
	}

	@Override
	public void delSwitchByLineId(String lineId) {
		if (logger.isDebugEnabled()) {
			logger.debug("delSwitchByLineId(String) - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated method stub
		List<LowVoltageSwitch> switchs = selectByLineId(lineId);// 查找该线路下所有的开关
		for (LowVoltageSwitch s : switchs) {// 迭代删除所有开关
			if (s != null)
				switchMapper.deleteByPrimaryKey(s.getId());
			else {
				try {
					throw new Exception();
				} catch (Exception e) {
					logger.error("delSwitchByLineId(String)", e); //$NON-NLS-1$

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("delSwitchByLineId(String) - end"); //$NON-NLS-1$
		}
	}

	public void updateSwitch(LowVoltageSwitch switch1) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateSwitch(Switch) - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated method stub

		if (isSwitchExist(switch1)) {
			logger.info("---------updating switch--------");
			switchMapper.updateByPrimaryKey(switch1);
		} else {
			logger.info("---------inserting switch--------");
			switchMapper.insert(switch1);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("updateSwitch(Switch) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public boolean isSwitchExist(LowVoltageSwitch switch1) {

		if (switch1 != null
				&& switchMapper.selectByPrimaryKey(switch1.getId()) != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("isSwitchExist(Switch) - end"); //$NON-NLS-1$
			}
			return false;
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("isSwitchExist(Switch) - end"); //$NON-NLS-1$
			}
			return true;
		}

	}

	@Override
	public String getAddress(String switchId) {
		LowVoltageSwitch switch1 = selectByPrimaryKey(switchId);
		if (switch1 != null) {
			return switch1.getAddress();
		} else {
			return null;
		}
	}

	@Override
	public String getSwitchId(String address) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("address", address);

		List<LowVoltageSwitch> switchs = selectByParameters(MyBatisMapUtil
				.warp(map));

		if (switchs != null && switchs.size() != 0) {

			LowVoltageSwitch switch1 = switchs.get(0);
			if (switch1 != null) {
				return switch1.getId();
			}
		}
		return null;
	}

	@Override
	protected boolean isExist(LowVoltageSwitch record) {

		if (record != null
				&& switchMapper.selectByPrimaryKey(record.getId()) != null) {

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean createSwitchExcel(String filePath,
			List<LowVoltageSwitch> sapis) {

		List<String> headList = createHeadList();// 生成表头
		Map<String, String> map = createHeadListMap();// 生成映射关系
		ExcelUtil poi = new ExcelUtil();
		try {
			poi.exportExcel("Sheet1", filePath, map, headList, sapis, 1,
					LowVoltageSwitch.class);
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

		List<com.gdut.dongjun.dto.LowVoltageSwitch> result = new LinkedList<>();
		// 2.解析Excel内容
		try {
			result = poi.importExcel("Sheet1", realPath, map, headList,
					com.gdut.dongjun.dto.LowVoltageSwitch.class);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		for (com.gdut.dongjun.dto.LowVoltageSwitch s : result) {

			LowVoltageSwitch switch1 = new LowVoltageSwitch();
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

			switchMapper.insert(switch1);
		}
		return true;
	}

	// @Override
	// public void updateSwtichOpen(String id) {
	//
	// Switch switch1 = switchMapper.selectByPrimaryKey(id);
	// if(switch1 != null){
	// switch1.setIsOpen(1);
	// switchMapper.updateByPrimaryKey(switch1);
	// }else {
	// logger.error("there is an error in updating switch statu!");
	// }
	// }

}
