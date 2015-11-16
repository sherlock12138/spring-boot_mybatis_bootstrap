package com.gdut.dongjun.service.net_server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.domain.po.LowVoltageSwitch;
import com.gdut.dongjun.service.LowVoltageSwitchService;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;

/**
 * 
 * @Title: TimedReadCurrentVoltageHandler.java
 * @Package com.gdut.dongjun.web.net_server.handler.outboundhandler
 * @Description: 定时（15分钟）读取电流电压
 * @author Sherlock-lee
 * @date 2015年8月9日 下午10:34:41
 * @version V1.0
 */
@Sharable
@Component
public class TimedReadCVHandler extends
		ChannelOutboundHandlerAdapter {
	/**
	 * @ClassName: ElectricControlServerOutBoundHandler
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月14日 下午11:56:46
	 */
	// Stateful properties
	@Autowired
	private LowVoltageSwitchService switchService;

	private int flag;

	@Override
	public void write(ChannelHandlerContext ctx, Object msg,
			ChannelPromise promise) throws InterruptedException {

		List<LowVoltageSwitch> switchs = switchService.selectByParameters(null);// 读取所有开关

		while (flag != 0) {

			if (switchs != null) {
				for (LowVoltageSwitch s : switchs) {
					if (s != null) {
						System.out.println("switchId  " + s.getId());
						String address = switchService.getAddress(s.getId());
						String data = LowVoltageDeviceCommandUtil
								.readAllPhaseCurrent(address);
						// seriesData
						ctx.writeAndFlush(data);// 发送命令

						LowVoltageDeviceCommandUtil.readAllPhaseVoltage(address);
						data = LowVoltageDeviceCommandUtil.readAllPhaseVoltage(address);
						ctx.writeAndFlush(data);// 发送命令
					}
				}
			}
			Thread.sleep(10 * 1000);
		}
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
