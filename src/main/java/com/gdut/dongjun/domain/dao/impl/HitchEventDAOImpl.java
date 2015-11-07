package com.gdut.dongjun.domain.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gdut.dongjun.domain.dao.HitchEventMapper;
import com.gdut.dongjun.domain.dao.impl.system.SinglePrimaryKeyBaseDAOImpl;
import com.gdut.dongjun.domain.po.HitchEvent;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @Tel 15622358381
 * @state 站内消息DaoImpl
 */
@Repository
public class HitchEventDAOImpl extends SinglePrimaryKeyBaseDAOImpl<HitchEvent>
		implements HitchEventMapper {

	@Override
	public HitchEvent getRecentlyHitchEvent() {
		// TODO Auto-generated method stub
		return template.selectOne(getNamespace("getRecentlyHitchEvent"));
	}

	@Override
	public List<com.gdut.dongjun.dto.HitchEvent> hitchEventList() {
		// TODO Auto-generated method stub
		return template.selectList(getNamespace("hitchEventList"));
	}

}