package com.gdut.dongjun.service.impl.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;
import com.gdut.dongjun.service.system.BaseService;

/**
 * @Title: BaseServiceImpl.java
 * @Package com.gdut.dongjun.service.impl.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:33:08
 * @version V1.0
 */
public class BaseServiceImpl<T> implements BaseService<T> {

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
		// TODO Auto-generated method stub
		return baseMapper.insert(record);
	}

	@Override
	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return baseMapper.insertSelective(record);
	}

	@Override
	public T selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<T> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return baseMapper.selectByParameters(map);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return baseMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return baseMapper.updateByPrimaryKeySelective(record);
	}

}
