package com.gdut.dongjun.service.net_server;

import io.netty.channel.ChannelHandlerContext;

/**
 * @Title: SwitchGPRS.java
 * @Package com.gdut.dongjun.service.impl
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月11日 下午7:10:20
 * @version V1.0
 */
public class SwitchGPRS {
	/**
	 * @ClassName: SwitchGPRS
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月11日 下午7:10:20
	 */
	private String id;
	private String address;
	private ChannelHandlerContext ctx;
	private boolean isOpen = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	public void setCtx(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id  " + id + "  address  " + address + "  ctx  " + ctx
				+ " isOpen " + isOpen;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

}
