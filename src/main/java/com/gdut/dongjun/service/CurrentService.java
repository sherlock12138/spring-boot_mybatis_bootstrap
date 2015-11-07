package com.gdut.dongjun.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.CurrentMapper;
import com.gdut.dongjun.domain.dao.SwitchMapper;
import com.gdut.dongjun.domain.po.Current;
import com.gdut.dongjun.domain.po.Switch;
import com.gdut.dongjun.service.system.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface CurrentService extends BaseService<Current> {

	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return List<Current>
	 * @throws
	 */
	public Map<String, Object> selectBySwitchId(String switchId);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param switchId
	 * @param @param d
	 * @return void
	 * @throws
	 */
	public Map<String, Object> selectByTime(String switchId, String date);

	/**
	 * 
	 * @Title: getRecentlyHitchEvent
	 * @Description: TODO
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<Current> getRecentlyCurrent();

}
