package com.gdut.dongjun.service.device_message_engine;

/**
 * @author Sherlock-lee
 * @date 2015年11月11日 下午2:40:26
 * @see TODO
 * @since 1.0
 */
public interface ControlMessageEngine {

	/***
	 * 
	 * @Title: generateCloseSwitchMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateCloseSwitchMessage(String address);

	/**
	 * 
	 * @Title: generateOpenSwitchMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateOpenSwitchMessage(String address);

}
