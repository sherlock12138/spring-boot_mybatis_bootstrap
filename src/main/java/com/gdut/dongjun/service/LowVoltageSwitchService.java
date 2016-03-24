package com.gdut.dongjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface LowVoltageSwitchService extends BaseService<LowVoltageSwitch> {

	/**
	 * 
	 * @Title: delSwitchByLineId
	 * @Description: TODO
	 * @param @param lineId
	 * @return void
	 * @throws
	 */
	public void delSwitchByLineId(String lineId);

	/**
	 * 
	 * @Title: updateSwitch
	 * @Description: TODO
	 * @param @param switch1
	 * @return void
	 * @throws
	 */
	public void updateSwitch(LowVoltageSwitch switch1);

	/**
	 * 
	 * @Title: 判断开关是否存在
	 * @Description: TODO
	 * @param @param switch1
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean isSwitchExist(LowVoltageSwitch switch1);

	/**
	 * 
	 * @Title: getAddress
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getAddress(String switchId);

	/**
	 * 
	 * @Title: selectAll
	 * @Description: 根据线路id查找开关
	 * @param @param lineId
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<LowVoltageSwitch> selectByLineId(String lineId);

	/**
	 * 
	 * @Title: getSwitchId
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getSwitchId(String address);

	/**
	 * 
	 * @Title: createStudentAndParentExcel
	 * @Description: TODO
	 * @param @param filePath
	 * @param @param sapis
	 * @return boolean
	 * @throws
	 */
	public boolean createSwitchExcel(String filePath,
			List<LowVoltageSwitch> sapis);

	/**
	 * 
	 * @Title: uploadSwitch
	 * @Description: TODO
	 * @param @param vo
	 * @param @param lineId
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean uploadSwitch(String vo, String lineId);

	/**
	 * @param id
	 * 
	 * @Title: updateSwtichOpen
	 * @Description: TODO
	 * @param String
	 *            id
	 * @return void
	 * @throws
	 */
	// public void updateSwtichOpen(String id);

}
