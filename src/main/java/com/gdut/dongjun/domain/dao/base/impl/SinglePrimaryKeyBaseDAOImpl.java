package com.gdut.dongjun.domain.dao.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger
			.getLogger(SinglePrimaryKeyBaseMapper.class);

	@Transactional
	public int deleteByPrimaryKey(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("deleteByPrimaryKey(String) - start"); //$NON-NLS-1$
		}

		template.delete(getNamespace("deleteByPrimaryKey"), id);

		if (logger.isDebugEnabled()) {
			logger.debug("deleteByPrimaryKey(String) - end"); //$NON-NLS-1$
		}
		return 0;
	}

	@Transactional
	public int insert(T record) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(T) - start"); //$NON-NLS-1$
		}

		template.insert(getNamespace("insert"), record);

		if (logger.isDebugEnabled()) {
			logger.debug("insert(T) - end"); //$NON-NLS-1$
		}
		return 0;
	}

	@Transactional
	public int insertSelective(T record) {
		if (logger.isDebugEnabled()) {
			logger.debug("insertSelective(T) - start"); //$NON-NLS-1$
		}
		// com.a. + inse
		template.insert(getNamespace("insertSelective"), record);

		if (logger.isDebugEnabled()) {
			logger.debug("insertSelective(T) - end"); //$NON-NLS-1$
		}
		return 0;
	}

	public T selectByPrimaryKey(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectByPrimaryKey(String) - start"); //$NON-NLS-1$
		}
		if (logger.isDebugEnabled()) {
			logger.debug("selectByPrimaryKey(String) - end"); //$NON-NLS-1$
		}
		return template.selectOne(getNamespace("selectByPrimaryKey"), id);
	}

	public List<T> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if (logger.isDebugEnabled()) {
			logger.debug("selectByParamsters(Map<String, Object>) - start"); //$NON-NLS-1$
		}
		if (logger.isDebugEnabled()) {
			logger.debug("selectByParamsters(Map<String, Object>) - end"); //$NON-NLS-1$
		}
		return template.selectList(getNamespace("selectByParameters"), map);
	}

	@Transactional
	public int updateByPrimaryKey(T record) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateByPrimaryKey(T) - start"); //$NON-NLS-1$
		}

		template.update(getNamespace("updateByPrimaryKey"), record);

		if (logger.isDebugEnabled()) {
			logger.debug("updateByPrimaryKey(T) - end"); //$NON-NLS-1$
		}
		return 0;
	}

	@Transactional
	public int updateByPrimaryKeySelective(T record) {
		if (logger.isDebugEnabled()) {
			logger.debug("updateByPrimaryKeySelective(T) - start"); //$NON-NLS-1$
		}

		template.update(getNamespace("updateByPrimaryKeySelective"), record);

		if (logger.isDebugEnabled()) {
			logger.debug("updateByPrimaryKeySelective(T) - end"); //$NON-NLS-1$
		}
		return 0;
	}

	/**
	 * 
	 * @author Sherlock-lee 功能: 返回类实现的第一个接口名称
	 * @return 第一个接口名称
	 */
	public String getFirstInterface() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFirstInterface() - start"); //$NON-NLS-1$
		}
		// String string = this.getClass().toString();
		String returnString = this.getClass().getInterfaces()[0].toString()
				.split(" ")[1].toString();

		if (logger.isDebugEnabled()) {
			logger.debug("getFirstInterface() - end"); //$NON-NLS-1$
		}
		return returnString;
	}

	/**
	 * 
	 * @author Sherlock-lee 功能:为获取namespace特别提供的方法
	 * @return namespace
	 */
	public String getNamespace(String methodName) {
		if (logger.isDebugEnabled()) {
			logger.debug("getNamespace(int) - start"); //$NON-NLS-1$
		}

		String returnString = getFirstInterface() + "." + methodName;
		if (logger.isDebugEnabled()) {
			logger.debug("getNamespace(int) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

}
