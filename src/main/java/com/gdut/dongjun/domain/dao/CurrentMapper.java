package com.gdut.dongjun.domain.dao;

import java.util.List;
import java.util.Map;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.Current;

public interface CurrentMapper extends SinglePrimaryKeyBaseMapper<Current> {

	/**
	 * 
	 * @Title: selectBySwitchId
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return List<Current>
	 * @throws
	 */
	public List<Current> selectBySwitchId(Map<String, Object> xx);

	/**
	 * 
	 * @Title: selectByTime
	 * @Description: TODO
	 * @param @param xx
	 * @param @return
	 * @return Object
	 * @throws
	 */
	public List<Current> selectByTime(Map<String, Object> xx);

	/**
	 * 
	 * @Title: getRecentlyCurrent
	 * @Description: TODO
	 * @param @param switchId
	 * @return void
	 * @throws
	 */
	public List<Current> getRecentlyCurrent();

}