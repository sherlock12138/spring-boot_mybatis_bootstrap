package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.LineMapper;
import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.service.LineService;
import com.gdut.dongjun.service.impl.system.BaseServiceImpl;
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
public class LineServiceImpl extends BaseServiceImpl<Line> implements
		LineService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private LineMapper lineMapper;

	@Override
	public List<Line> selectAll() {
		// TODO Auto-generated method stub
		return lineMapper.selectAll();
	}

	@Override
	public Line getLineBySwitchId(String switchId) {
		// TODO Auto-generated method stub
		return lineMapper.getLineBySwitchId(switchId);
	}

	@Override
	public List<Line> selectByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return lineMapper.selectByKeyWord(keyWord);
	}

	@Override
	public List<Line> selectBySubstationId(String substationId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("substation_id", substationId);
		List<Line> list = lineMapper.selectByParameters(MyBatisMapUtil
				.warp(map));

		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

}
