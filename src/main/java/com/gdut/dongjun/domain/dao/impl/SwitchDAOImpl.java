package com.gdut.dongjun.domain.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.SwitchMapper;
import com.gdut.dongjun.domain.dao.impl.system.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.Switch;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @Tel 15622358381
 * @state 站内消息DaoImpl
 */
@Repository
public class SwitchDAOImpl extends SinglePrimaryKeyBaseDAOImpl<Switch>
		implements SwitchMapper {

	@Override
	public List<Switch> selectByLineId(String lineId) {
		// TODO Auto-generated method stub
		return template.selectList("selectByLineId", lineId);
	}




	
	
}
