/*
 * @(#)SimpleWrite.java	1.12 98/06/25 SMI
 *
 * Copyright (c) 1998 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Sun grants you ("Licensee") a non-exclusive, royalty free, license 
 * to use, modify and redistribute this software in source and binary
 * code form, provided that i) this copyright notice and license appear
 * on all copies of the software; and ii) Licensee does not utilize the
 * software in a manner which is disparaging to Sun.
 *
 * This software is provided "AS IS," without a warranty of any kind.
 * ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES,
 * INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN AND
 * ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THE
 * SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT,
 * INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES,
 * HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING
 * OUT OF THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * This software is not designed or intended for use in on-line control
 * of aircraft, air traffic, aircraft navigation or aircraft
 * communications; or in the design, construction, operation or
 * maintenance of any nuclear facility. Licensee represents and
 * warrants that it will not use or redistribute the Software for such
 * purposes.
 */
package com.gdut.dongjun.util;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.log4j.Logger;

/**
 * 
* @Title: CommandUtil.java 
* @Package com.gdut.Netty_testing.dongjun.util 
* @Description: TODO 
* @author Sherlock-lee   
* @date 2015年7月16日 下午9:59:43 
* @version V1.0
 */
public class CommUtil {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CommUtil.class);

	private static final String DEFAULT_PORT_ID = "COM4";
	private static CommPortIdentifier portId;
	private static SerialPort serialPort;

	public CommUtil() {

		try {
			portId = CommPortIdentifier.getPortIdentifier(DEFAULT_PORT_ID);
		} catch (NoSuchPortException e) {
			logger.error("CommUtil()", e); //$NON-NLS-1$

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSerialPort(portId);
	}

	public CommUtil(String port) {

		Enumeration portList = CommPortIdentifier.getPortIdentifiers();

		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portId.getName().equals(port)) {
					setSerialPort(portId);
					return;// 找到当前串口并且当前串口可用就停止
				}
			}
		}
	}

	private void setSerialPort( CommPortIdentifier portId) {
		if (logger.isDebugEnabled()) {
			logger.debug("setSerialPort(CommPortIdentifier) - start"); //$NON-NLS-1$
		}

		try {
			this.serialPort = (SerialPort) portId.open("SimpleWriteApp", 2000);
		} catch (PortInUseException e) {
			logger.warn("setSerialPort(CommPortIdentifier) - exception ignored", e); //$NON-NLS-1$
		}

		if (logger.isDebugEnabled()) {
			logger.debug("setSerialPort(CommPortIdentifier) - end"); //$NON-NLS-1$
		}
	}

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
    }
	/**
	 * 
	 * @Title: excute
	 * @Description: 执行命令
	 * @param @param command
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String excute(String command) {
		if (logger.isDebugEnabled()) {
			logger.debug("excute(String) - start"); //$NON-NLS-1$
		}

		OutputStream outputStream = null;
		byte[] respond = null;

		try {
			outputStream = serialPort.getOutputStream();
		} catch (IOException e) {
			logger.warn("excute(String) - exception ignored", e); //$NON-NLS-1$
			logger.info("串口被占用，或者该串口不存在");
		}
		try {
			serialPort.setSerialPortParams(2400, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_EVEN);
		} catch (UnsupportedCommOperationException e) {
			logger.warn("excute(String) - exception ignored", e); //$NON-NLS-1$
		}
		try {
			System.out.println(command);
			outputStream.write(HexString_BytesUtil.hexStringToBytes(command));

			// 等待响应
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				logger.error("excute(String)", e); //$NON-NLS-1$

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InputStream inputStream = serialPort.getInputStream();

			respond = new byte[inputStream.available()];
			inputStream.read(respond);
			System.out.println("Respond: " + HexString_BytesUtil.bytesToHexString(respond));
			
			run();
			inputStream = serialPort.getInputStream();

			respond = new byte[inputStream.available()];
			inputStream.read(respond);
			System.out.println("Respond: " + HexString_BytesUtil.bytesToHexString(respond));
			serialPort.close();

		} catch (IOException e) {
			logger.warn("excute(String) - exception ignored", e); //$NON-NLS-1$
		}
		String returnString = HexString_BytesUtil.bytesToHexString(respond);
		if (logger.isDebugEnabled()) {
			logger.debug("excute(String) - end"); //$NON-NLS-1$
		}
		return returnString;
	}

//	java.lang.IllegalArgumentException: Test class can only have one constructor
//	at org.junit.runners.model.TestClass.<init>(TestClass.java:40)
//	at org.junit.runners.ParentRunner.<init>(ParentRunner.java:75)
//	at org.junit.runners.BlockJUnit4ClassRunner.<init>(BlockJUnit4ClassRunner.java:57)
//	at org.junit.internal.builders.JUnit4Builder.runnerForClass(JUnit4Builder.java:10)
//	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
//	at org.junit.internal.builders.AllDefaultPossibilitiesBuilder.runnerForClass(AllDefaultPossibilitiesBuilder.java:26)
//	at org.junit.runners.model.RunnerBuilder.safeRunnerForClass(RunnerBuilder.java:59)
//	at org.junit.internal.requests.ClassRequest.getRunner(ClassRequest.java:26)
//	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.<init>(JUnit4TestReference.java:33)
//	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestClassReference.<init>(JUnit4TestClassReference.java:25)
//	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.createTest(JUnit4TestLoader.java:48)
//	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.loadTests(JUnit4TestLoader.java:38)
//	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:444)
//	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
//	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
//	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)


//	@Test
//	public void test() {
//		System.out.println(CheckCodeUtil.check("68AAAAAAAAAAAA681506343333333336", "df"));
//		;
//	}
}
