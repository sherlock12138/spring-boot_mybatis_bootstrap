package com.gdut.dongjun.domain.dao.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Sherlock-lee
 * @state 单主键类的DAO接口
 * @param <T>
 *            T为单主键PO类
 */
public interface SinglePrimaryKeyBaseMapper<T> {
	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int deleteByPrimaryKey(String id);

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insert(T record);

	/**
	 * 
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int insertSelective(T record);

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return T
	 * @throws
	 */
	public T selectByPrimaryKey(String id);

	/**
	 * 
	 * @Title: selectByParamsters
	 * @Description: TODO
	 * @param @param map (null 为全查询)
	 * @return void
	 * @throws
	 */
	public List<T> selectByParameters(Map<String, Object> map);

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int updateByPrimaryKeySelective(T record);

	/**
	 * 
	 * @Title: updateByPrimaryKey
	 * @Description: TODO
	 * @param @param record
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int updateByPrimaryKey(T record);

}