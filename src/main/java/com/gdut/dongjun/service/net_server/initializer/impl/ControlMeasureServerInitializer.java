package com.gdut.dongjun.service.net_server.initializer.impl;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.net_server.handler.Decoder;
import com.gdut.dongjun.service.net_server.handler.Encoder;
import com.gdut.dongjun.service.net_server.handler.msg_decoder.ControlMeasureDataReceiver;
import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;


/**   
 * @author	Sherlock-lee
 * @date	2015年11月17日 上午11:51:05
 * @see 	TODO
 * @since   1.0
 */
@Component("ControlMeasureServerInitializer")
public class ControlMeasureServerInitializer extends ServerInitializer{

	@Autowired
	private ControlMeasureDataReceiver dataReceiver;
	
	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		
		super.initChannel(ch);
		ChannelPipeline p = ch.pipeline();
		p.addLast(new Decoder());
		p.addLast(new Encoder());
		p.addLast(dataReceiver);
		
		
	}
	
	
	
	
	
	
	

}
