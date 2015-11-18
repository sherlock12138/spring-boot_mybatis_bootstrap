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
package com.gdut.dongjun.web.net_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import org.springframework.stereotype.Component;

import ch.qos.logback.core.net.server.Client;

/**
 * Receives a list of continent/city pairs from a {@link Client} to get the
 * local times of the specified cities.
 */
@Component
public final class ServerChannelFactory {

	static final boolean SSL = true;
	static final int PORT = Integer
			.parseInt(System.getProperty("port", "8463"));

	public static Channel createChannel(ServerInitializer initializer) {
		// TODO Auto-generated method stub
		SslContext sslCtx = null;
		SelfSignedCertificate ssc = null;
		Channel channel = null;
		if (SSL) {

			try {
				ssc = new SelfSignedCertificate();
				sslCtx = SslContextBuilder.forServer(ssc.certificate(),
						ssc.privateKey()).build();
			} catch (CertificateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SSLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			sslCtx = null;
		}

		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup(6);
		try {
			ServerBootstrap b = new ServerBootstrap();
			initializer.setSslCtx(sslCtx);
			b.group(bossGroup, workerGroup)
					// NioDatagramChannel.class
					// NioServerSocketChannel
					.channel(NioServerSocketChannel.class)
					.handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(initializer);

			ChannelFuture f = b.bind(PORT).sync();
			f.awaitUninterruptibly();
			channel = f.channel();

			System.out.println("inside" + channel);
			return channel;
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// finally {
		// bossGroup.shutdownGracefully();
		// workerGroup.shutdownGracefully();
		// }
		return null;
	}

	// public static void main(String[] args) throws Exception {
	// // Configure SSL.
	// final SslContext sslCtx;
	// if (SSL) {
	// SelfSignedCertificate ssc = new SelfSignedCertificate();
	// sslCtx = SslContextBuilder.forServer(ssc.certificate(),
	// ssc.privateKey()).build();
	// } else {
	// sslCtx = null;
	// }
	//
	// EventLoopGroup bossGroup = new NioEventLoopGroup(1);
	// EventLoopGroup workerGroup = new NioEventLoopGroup();
	// try {
	// ServerBootstrap b = new ServerBootstrap();
	// b.group(bossGroup, workerGroup)
	// .channel(NioServerSocketChannel.class)
	// .handler(new LoggingHandler(LogLevel.INFO))
	// .childHandler(new ElectricControlServerInitializer(sslCtx));
	//
	// b.bind(PORT).sync().channel().closeFuture().sync();
	// } finally {
	// bossGroup.shutdownGracefully();
	// workerGroup.shutdownGracefully();
	// }
	// }

}
