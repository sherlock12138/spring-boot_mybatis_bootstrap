package com.gdut.dongjun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdut.dongjun.domain.dao.CompanyMapper;
import com.gdut.dongjun.domain.po.Company;
import com.gdut.dongjun.service.CompanyService;
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
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService{
	/** 
	 * @ClassName: UserServiceImpl 
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月24日 下午2:33:08 
	 */
	@Autowired
	private CompanyMapper companyMapper;
}
