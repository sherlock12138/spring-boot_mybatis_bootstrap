/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.gdut.dongjun.service.net_server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.net_server.handler.DataReceiver;
import com.gdut.dongjun.service.net_server.handler.Decoder;
import com.gdut.dongjun.service.net_server.handler.Encoder;
import com.gdut.dongjun.service.net_server.handler.RandomReadCVHandler;
import com.gdut.dongjun.service.net_server.handler.TimedReadCVHandler;

@Component
public class ServerInitializer extends ChannelInitializer<SocketChannel> {

	private SslContext sslCtx;
	private static final EventExecutorGroup group = new DefaultEventExecutorGroup(
			6);

	public void setSslCtx(SslContext sslCtx) {
		this.sslCtx = sslCtx;
	}

	public ServerInitializer() {
		super();
	}

	@Autowired
	private DataReceiver dataReceiver;
	@Autowired
	private RandomReadCVHandler randomReadCVHandler;
	@Autowired
	private TimedReadCVHandler timedReadCurrentVoltageHandler;

	public ServerInitializer(SslContext sslCtx) {
		this.sslCtx = sslCtx;
	}

	@Override
	public void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();
		if (sslCtx != null) {
			p.addLast(sslCtx.newHandler(ch.alloc()));
		}

		p.addLast(new Decoder());
		p.addLast(new Encoder());

		
		p.addLast(dataReceiver);// inbound
//		p.addLast(randomReadCVHandler);// outbound

		// p.addLast(group, "out", timedReadCurrentVoltageHandler);

		// p.addLast(outBoundHandler);
		// p.addLast(new ElectricControlServerOutBoundHandler());
	}

	public DataReceiver getDataReceiver() {
		return dataReceiver;
	}

	public void setDataReceiver(DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
	}

	public TimedReadCVHandler getTimedReadCurrentVoltageHandler() {
		return timedReadCurrentVoltageHandler;
	}

	public void setTimedReadCurrentVoltageHandler(
			TimedReadCVHandler timedReadCurrentVoltageHandler) {
		this.timedReadCurrentVoltageHandler = timedReadCurrentVoltageHandler;
	}

}
