package com.gdut.dongjun.service.authc;

import java.util.List;

import com.gdut.dongjun.domain.po.authc.Module;

/**
 * @Title: ExtTreeNode.java
 * @Package com.topview.school.service.authority
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月19日 上午12:29:41
 * @version V1.0
 */
public class ExtTreeNode{
	/**
	 * @ClassName: ExtTreeNode
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月19日 上午12:29:42
	 */

	private String id;
	private String parentId;
	private String text;
	private String imgUrl;
	private String iconCls;
	private String className;
	private Integer leaf;
	private boolean checked = false;
	private List<ExtTreeNode> items;

	/**
	 * 
	 * @Title: fromModule
	 * @Description: TODO
	 * @param @param module
	 * @param @return
	 * @return ExtTreeNode
	 * @throws
	 */
	public static ExtTreeNode fromModule(Module module) {

		ExtTreeNode node = new ExtTreeNode();
		node.id = module.getId();
		node.parentId = module.getParentId();
		node.text = module.getText();
		node.imgUrl = module.getImgurl();
		node.iconCls = module.getIconcls();
		node.className = module.getClassname();
		node.leaf = module.getLeaf();
		return node;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<ExtTreeNode> getItems() {
		return items;
	}

	public void setItems(List<ExtTreeNode> items) {
		this.items = items;
	}

}
