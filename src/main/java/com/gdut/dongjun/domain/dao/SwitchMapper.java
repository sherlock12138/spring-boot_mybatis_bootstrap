package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.Switch;

public interface SwitchMapper extends SinglePrimaryKeyBaseMapper<Switch> {

	/**
	 * 
	 * @Title: selectByLineId
	 * @Description: TODO
	 * @param @param lineId
	 * @param @return
	 * @return List<Switch>
	 * @throws
	 */
	public List<Switch> selectByLineId(String lineId);


}