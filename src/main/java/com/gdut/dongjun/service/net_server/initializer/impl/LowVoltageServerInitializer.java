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
package com.gdut.dongjun.service.net_server.initializer.impl;

import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.net_server.handler.Decoder;
import com.gdut.dongjun.service.net_server.handler.Encoder;
import com.gdut.dongjun.service.net_server.handler.msg_decoder.LowVoltageDataReceiver;
import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;

@Component("LowVoltageServerInitializer")
public class LowVoltageServerInitializer extends ServerInitializer {

	@Autowired
	private LowVoltageDataReceiver dataReceiver;

	@Override
	public void initChannel(SocketChannel ch) throws Exception {

		super.initChannel(ch);
		ChannelPipeline p = ch.pipeline();
		p.addLast(new Decoder());
		p.addLast(new Encoder());
		p.addLast(dataReceiver);
		// ********************************************************
		// inbound
		// 低压协议的返回数据解析器
		// ********************************************************

	}



}
