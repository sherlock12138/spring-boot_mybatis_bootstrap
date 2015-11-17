package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: UserService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface LineService extends BaseService<Line> {

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
	 * @Title: selectBySubstationId
	 * @Description: TODO
	 * @param @param substation_id
	 * @param @return
	 * @return List<Line>
	 * @throws
	 */
	public List<Line> selectBySubstationId(String substationId);

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
	 * @return
	 * 
	 * @Title: selectByKeyWord
	 * @Description: TODO
	 * @param @param keyWord
	 * @return List<Line>
	 * @throws
	 */
	public List<Line> selectByKeyWord(String keyWord);

}
