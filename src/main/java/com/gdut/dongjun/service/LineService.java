package com.gdut.dongjun.service;

import com.gdut.dongjun.domain.po.Line;
import com.gdut.dongjun.service.system.BaseService;

/**   
 * @Title: UserService.java 
 * @Package com.gdut.dongjun.service.system 
 * @Description: TODO 
 * @author Sherlock-lee   
 * @date 2015年7月24日 下午2:34:11 
 * @version V1.0   
 */
public interface LineService extends BaseService{

	public Line selectByPrimaryKey(String string);

}
