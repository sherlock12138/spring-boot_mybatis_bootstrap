package com.gdut.dongjun.service.net_server.handler;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import org.springframework.stereotype.Component;

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
public class RandomReadCVHandler extends ChannelOutboundHandlerAdapter {
	/**
	 * @ClassName: ElectricControlServerOutBoundHandler
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月14日 下午11:56:46
	 */
	// Stateful properties
	private boolean flag = false;

	@Override
	public void write(ChannelHandlerContext ctx, Object msg,
			ChannelPromise promise) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("经过1");
		while(flag){
			System.out.println("经过2");
			ctx.writeAndFlush("bbbb");
			flag = false;
		}
		System.out.println("经过3");
//		ctx.channel().writeAndFlush("bbbbbbb");禁止
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}


}
