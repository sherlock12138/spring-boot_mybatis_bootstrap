package com.gdut.dongjun.domain.dao;

import java.util.List;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.domain.po.Line;

public interface LineMapper extends SinglePrimaryKeyBaseMapper<Line> {

	/**
	 * 
	 * @Title: selectAll
	 * @Description: TODO
	 * @param @return
	 * @return List<Line>
	 * @throws
	 */
	public List<Line> selectAll();

	/**
	 * 
	 * @Title: getLineBySwitchId
	 * @Description: TODO
	 * @param @param switchId
	 * @param @return
	 * @return Line
	 * @throws
	 */
	public Line getLineBySwitchId(String switchId);

	/**
	 * 
	 * @Title: selectByKeyWord
	 * @Description: TODO
	 * @param @param keyWord
	 * @param @return
	 * @return List<Line>
	 * @throws
	 */
	public List<Line> selectByKeyWord(String keyWord);
}