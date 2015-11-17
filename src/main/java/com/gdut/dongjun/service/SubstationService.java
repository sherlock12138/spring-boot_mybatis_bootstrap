package com.gdut.dongjun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.LowVoltageCurrentMapper;
import com.gdut.dongjun.domain.dao.LowVoltageSwitchMapper;
import com.gdut.dongjun.domain.po.Substation;
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
public interface SubstationService extends BaseService<Substation> {

	/**
	 * 
	 * @Title: selectByCompanyId
	 * @Description: TODO
	 * @param @param company_id
	 * @param @return
	 * @return List<Substation>
	 * @throws
	 */
	public List<Substation> selectByCompanyId(String companyId);
}
