package com.gdut.dongjun.service.net_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: NetServer.java
 * @Package com.gdut.dongjun.web.net_server
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月9日 上午11:12:29
 * @version V1.0
 */
@Service
public class NetServer {
	/**
	 * @ClassName: NetServer
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月9日 上午11:12:29
	 */
	private Channel channel;//
	@Autowired
	private ServerInitializer initializer;

	private static boolean hitchEventSypSign = false;
	private static boolean cvReadTaskSign = false;

	static final boolean SSL = System.getProperty("ssl") != null;
	static final int PORT = Integer
			.parseInt(System.getProperty("port", "8463"));

	/**
	 * 
	 * @Title: createChannel
	 * @Description: TODO
	 * @param @return
	 * @return Channel
	 * @throws
	 */
	private void createChannel() {
		// TODO Auto-generated method stub
		SslContext sslCtx = null;
		SelfSignedCertificate ssc = null;

		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
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
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		// finally {
		// bossGroup.shutdownGracefully();
		// workerGroup.shutdownGracefully();
		// }
	}

	/**
	 * 
	 * @Title: hitchEventSpy
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	private void beginHitchEventSpy() {

		while (hitchEventSypSign) {

			CtxStore.hitchEventSpy();
			try {
				Thread.sleep(5 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @Title: beginCVReadTask
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	private void beginCVReadTask() {

		while (cvReadTaskSign) {

			CtxStore.timedCVReadTask();
			try {
				Thread.sleep(15 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @Title: start
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void start() {

		createChannel();// 开启监听
		hitchEventSypSign = true;
		beginHitchEventSpy();// 开启跳闸事件监听
		cvReadTaskSign = true;
		beginCVReadTask();// 开启定时抄表任务

		System.out.println(channel);
	}

	/**
	 * 
	 * @Title: stop
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void stop() {

		System.out.println("停1");
		if (channel != null) {
			System.out.println("停2");
			// handler.setFlag(0);
			hitchEventSypSign = false;// 停止跳闸事件监听
			cvReadTaskSign = false;// 停止抄表任务

			channel.eventLoop().shutdownGracefully();
			channel.close().addListener(ChannelFutureListener.CLOSE);
		}
	}

	/**
	 * 
	 * @Title: test
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void remove() {

//		channel.pipeline().remove(RandomReadCVHandler.class);

	}

	//
	// /**
	// *
	// * @Title: restart
	// * @Description: TODO
	// * @param
	// * @return void
	// * @throws
	// */
	// public void restart() {
	// stop();
	// start();
	// }

}
