package com.gdut.dongjun.domain.dao.impl.system;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.gdut.dongjun.domain.dao.system.SinglePrimaryKeyBaseMapper;

/**
 * @author Sherlock-lee
 * @version 创建时间：2015年3月20日 上午8:56:12
 * @param <T>
 * @Tel 15622358381
 * @state 单主键基础DAO实现类
 */
public class SinglePrimaryKeyBaseDAOImpl<T> implements
		SinglePrimaryKeyBaseMapper<T> {

	@Resource(name="msg_sqlSessionTemplate")
	protected SqlSessionTemplate template;
	private static final Logger logger = Logger
			.getLogger(SinglePrimaryKeyBaseMapper.class);

	/**
	 * 按主键删除
	 */
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

	/**
	 * 插入记录
	 */
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

	/**
	 * 插入缺省字段的记录，在缺省字段无默认值时报错，插入失败
	 */
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

	/**
	 * 按主键查找（单条记录）
	 */
	public T selectByPrimaryKey(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectByPrimaryKey(String) - start"); //$NON-NLS-1$
		}
		if (logger.isDebugEnabled()) {
			logger.debug("selectByPrimaryKey(String) - end"); //$NON-NLS-1$
		}
		return template.selectOne(getNamespace("selectByPrimaryKey"), id);
	}

	/**
	 * 按主键更新（单条记录）
	 */
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

	/**
	 * 按主键更新缺省字段的记录，在缺省字段无默认值时报错，更新失败
	 */
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

		// ***************************************************************
		// 接口的名称是按照类定义时的书写顺序
		// ***************************************************************
		String string = this.getClass().toString();
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
