package com.gdut.dongjun.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.service.base.BaseService;

/**
 * @Title: BaseServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private SinglePrimaryKeyBaseMapper<T> baseMapper;

	@Override
	public boolean deleteByPrimaryKey(String id) {

		try {
			baseMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public int insert(T record) {
		
		return baseMapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		
		return baseMapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> selectByParameters(Map<String, Object> map) {
		
		return baseMapper.selectByParameters(map);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		
		if (isExist(record)) {

			return baseMapper.updateByPrimaryKey(record);
		} else {

			return baseMapper.insert(record);
		}
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		
		if (isExist(record)) {

			return baseMapper.updateByPrimaryKeySelective(record);
		} else {

			return baseMapper.insert(record);
		}
	}

	/**
	 * 
	 * @Title: isExist
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	protected abstract boolean isExist(T record);

}
