package com.gdut.dongjun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.SubstationMapper;
import com.gdut.dongjun.domain.po.Substation;
import com.gdut.dongjun.domain.po.Switch;
import com.gdut.dongjun.service.SubstationService;
import com.gdut.dongjun.service.impl.system.BaseServiceImpl;

/**
 * @Title: UserServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
@Service
public class SubstationServiceImpl extends BaseServiceImpl<Substation>
		implements SubstationService {
	/**
	 * @ClassName: UserServiceImpl
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08
	 */
	@Autowired
	private SubstationMapper substationMapper;

	@Override
	public List<Substation> selectByCompanyId(String companyId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> xx = new HashMap<String, Object>();
		map.put("company_id", companyId);
		xx.put("map", map);
		List<Substation> list = substationMapper.selectByParameters(xx);

		if (list != null) {
			return list;
		} else {
			return null;
		}

	}
	
	
	
	
	
	
}
