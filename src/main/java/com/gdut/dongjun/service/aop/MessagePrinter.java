package com.gdut.dongjun.service.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import sun.util.logging.resources.logging;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @author Sherlock-lee
 * @date 2016年1月15日 上午9:47:29
 * @see TODO
 * @since 1.0
 */
@Aspect
public class MessagePrinter {

	// @After("com.gdut.dongjun.service.device.Device.generateCloseSwitchMessage()")
	@Before("execution(com.gdut.dongjun.service.device_message_engine.impl.*.*generateCloseSwitchMessage(*))")
	// @AfterReturning(
	// pointcut="com.gdut.dongjun.service..*.*(..)",
	// returning="msg")
	public void printMsg() {

		Logger.getLogger(MessagePrinter.class).info("遥控合闸");
	}

	@Before("execution(com.gdut.dongjun.service.device_message_engine.impl.*.*generateOpenSwitchMessage(*))")
	// @AfterReturning(
	// pointcut="com.gdut.dongjun.service..*.*(..)",
	// returning="msg")
	public void printMsgx() {

		Logger.getLogger(MessagePrinter.class).info("遥控分闸");
	}
}
