package com.gdut.dongjun.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.CompanyMapper;
import com.gdut.dongjun.domain.dao.base.impl.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.Company;

/**
 * 
 * @author Sherlock-lee
 * @date 2015年11月14日 下午4:56:43
 * @see TODO
 * @since 1.0
 */
@Repository
public class CompanyDAOImpl extends SinglePrimaryKeyBaseDAOImpl<Company>
		implements CompanyMapper {

}
