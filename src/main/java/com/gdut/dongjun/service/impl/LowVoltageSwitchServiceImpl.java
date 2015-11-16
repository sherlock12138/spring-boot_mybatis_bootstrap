package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.service.base.impl.BaseServiceImpl;
import com.gdut.dongjun.util.MyBatisMapUtil;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class LowVoltageSwitchServiceImpl extends BaseServiceImpl<LowVoltageSwitch> implements
		LowVoltageSwitchService {
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
		List<LowVoltageSwitch> list = switchMapper.selectByParameters(MyBatisMapUtil
				.warp(map));
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
		if (logger.isDebugEnabled()) {
			logger.debug("isSwitchExist(Switch) - start"); //$NON-NLS-1$
		}

		// TODO Auto-generated method stub

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sim_number", switch1.getSimNumber());
		map.put("id", switch1.getId());
		if (switchMapper.selectByParameters(MyBatisMapUtil.warp(map)).size() == 0) {
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

		List<LowVoltageSwitch> switchs = selectByParameters(MyBatisMapUtil.warp(map));
		
		if (switchs != null && switchs.size() != 0) {
			
			LowVoltageSwitch switch1 = switchs.get(0);
			if (switch1 != null) {
				return switch1.getId();
			}
		}
		return null;
	}

//	@Override
//	public void updateSwtichOpen(String id) {
//
//		Switch switch1 = switchMapper.selectByPrimaryKey(id);
//		if(switch1 != null){
//			switch1.setIsOpen(1);
//			switchMapper.updateByPrimaryKey(switch1);
//		}else {
//			logger.error("there is an error in updating switch statu!");
//		}
//	}

}
