package com.gdut.dongjun.service.base;

import java.util.List;
import java.util.Map;

/**
 * @Title: BaseService.java
 * @Package com.gdut.dongjun.service.system
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月24日 下午2:34:11
 * @version V1.0
 */
public interface BaseService<T> {

	/**
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return int
	 * @throws
	 */
	public boolean deleteByPrimaryKey(String id);

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
	 * @Title: selectByParameters
	 * @Description: TODO
	 * @param @param map
	 * @param @return
	 * @return List<T>
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
