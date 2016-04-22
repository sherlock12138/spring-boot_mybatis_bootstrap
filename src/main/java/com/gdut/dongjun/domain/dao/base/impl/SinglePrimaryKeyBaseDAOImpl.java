package com.gdut.dongjun.domain.dao.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.dongjun.domain.dao.base.SinglePrimaryKeyBaseMapper;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @param <T>
 * @Tel 15622358381
 * @state 单主键基础DAO实现类
 */
public class SinglePrimaryKeyBaseDAOImpl<T> implements
		SinglePrimaryKeyBaseMapper<T> {

	@Resource(name = "msg_sqlSessionTemplate")
	protected SqlSessionTemplate template;

	public int deleteByPrimaryKey(String id) {

		return template.delete(getNamespace("deleteByPrimaryKey"), id);
	}

	public int insert(T record) {

		return template.insert(getNamespace("insert"), record);
	}

	public int insertSelective(T record) {

		return template.insert(getNamespace("insertSelective"), record);
	}

	public T selectByPrimaryKey(String id) {

		return template.selectOne(getNamespace("selectByPrimaryKey"), id);
	}

	public List<T> selectByParameters(Map<String, Object> map) {

		return template.selectList(getNamespace("selectByParameters"), map);
	}

	public int updateByPrimaryKey(T record) {

		return template.update(getNamespace("updateByPrimaryKey"), record);
	}

	@Transactional
	public int updateByPrimaryKeySelective(T record) {

		return template.update(getNamespace("updateByPrimaryKeySelective"),
				record);
	}

	/**
	 * 
	 * @Title: getFirstInterface
	 * @Description: 返回类实现的第一个接口名称
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getFirstInterface() {

		return this.getClass().getInterfaces()[0].toString().split(" ")[1]
				.toString();
	}

	/**
	 * 
	 * @Title: getNamespace
	 * @Description: 为获取namespace特别提供的方法
	 * @param @param methodName
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String getNamespace(String methodName) {

		return getFirstInterface() + "." + methodName;
	}

}
