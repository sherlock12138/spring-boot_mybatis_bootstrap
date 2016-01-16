package com.gdut.dongjun.service;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.gdut.dongjun.domain.po.HighVoltageSwitch;
import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.base.BaseService;

/**
 * 
 * @author zjd
 * @email 452880294@qq.com
 * @date 2015年11月21日
 * @description
 * @package com.gdut.dongjun.service
 */
public interface HighVoltageSwitchService extends
		BaseService<HighVoltageSwitch> {
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
	public void updateSwitch(HighVoltageSwitch switch1);

	/**
	 * 
	 * @Title: 判断开关是否存在
	 * @Description: TODO
	 * @param @param switch1
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean isSwitchExist(HighVoltageSwitch switch1);

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
	public List<HighVoltageSwitch> selectByLineId(String lineId);

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
	 * @Title: createSwitchExcel
	 * @Description: TODO
	 * @param @param filePath
	 * @param @param object
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean createSwitchExcel(String filePath,
			List<HighVoltageSwitch> sapis);

	/**
	 * 
	 * @Title: uploadSwitch
	 * @Description: TODO
	 * @param @param f
	 * @param @param lineId
	 * @return void
	 * @throws
	 */
	public boolean uploadSwitch(String f, String lineId);

}
