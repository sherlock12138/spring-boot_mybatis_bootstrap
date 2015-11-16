package com.gdut.dongjun.service.device_message_engine;

/**
 * @author Sherlock-lee
 * @date 2015年11月10日 下午9:03:22
 * @see TODO
 * @since 1.0
 */
public interface DataMessageEngine {

	/**
	 * 
	 * @Title: generateReadAPhaseCurrentMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadAPhaseCurrentMessage(String address);

	/**
	 * 
	 * @Title: generateReadBPhaseCurrentMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadBPhaseCurrentMessage(String address);

	/**
	 * 
	 * @Title: generateReadCPhaseCurrentMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadCPhaseCurrentMessage(String address);

	/**
	 * 
	 * @Title: generateReadAPhaseVoltageMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadAPhaseVoltageMessage(String address);

	/**
	 * 
	 * @Title: generateReadBPhaseVoltageMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadBPhaseVoltageMessage(String address);

	/**
	 * 
	 * @Title: generateReadCPhaseVoltageMessage
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String generateReadCPhaseVoltageMessage(String address);

}
