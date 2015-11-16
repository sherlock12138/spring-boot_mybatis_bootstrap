package com.gdut.dongjun.service;

import java.util.List;

import com.gdut.dongjun.service.impl.ZTreeNode;

/**
 * @Title: CommandService.java
 * @Package com.gdut.dongjun.service
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月30日 下午11:51:28
 * @version V1.0
 */
public interface ZTreeNodeService {

	/**
	 * 
	 * @Title: diplaySwitchTree
	 * @Description: TODO
	 * @param @return
	 * @return List<ZTreeNode>
	 * @throws
	 */
	public List<ZTreeNode> getSwitchTree(String company_id);

}
