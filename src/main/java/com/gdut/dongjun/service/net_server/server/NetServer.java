package com.gdut.dongjun.service.net_server.server;

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

import org.springframework.stereotype.Service;

import com.gdut.dongjun.service.net_server.initializer.ServerInitializer;

/**
 * @Title: NetServer.java
 * @Package com.gdut.dongjun.web.net_server
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月9日 上午11:12:29
 * @version V1.0
 */
@Service
public abstract class NetServer {

	private Channel channel;//
	protected ServerInitializer initializer;

	protected static boolean hitchEventSypSign = false;
	protected static boolean cvReadTaskSign = false;
	protected int hitchEventBreak = defaultHitchEventBreak;// 报警事件监听的间隔
	protected int cvReadBreak = defaultCVReadBreak;// 电流电压读取的间隔

	protected static final int defaultHitchEventBreak = 5 * 60 * 1000;
	protected static final int defaultCVReadBreak = 15 * 60 * 1000;

	static final boolean SSL = false;//当需要实现加密连接时才打开，否则会报错！！，没有加包头
	private int port;

	// Integer.parseInt(System.getProperty("port", "8463"));

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
			// **********************************************************
			// 使用initializer进行初始化
			// **********************************************************
			ChannelFuture f = null;
			if (port != 0) {

				f = b.bind(port).sync();
				f.awaitUninterruptibly();
			}
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
	 * @Title: start
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void start() {

		createChannel();// 开启监听
		hitchEventSypSign = true;
		cvReadTaskSign = true;
		
		new HitchEventSpyThread().start();// 开启跳闸事件监听
		new CVReadTaskThread().start();// 开启定时抄表任务
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

		if (channel != null) {
			// handler.setFlag(0);
			hitchEventSypSign = false;// 停止跳闸事件监听
			cvReadTaskSign = false;// 停止抄表任务

			channel.eventLoop().shutdownGracefully();
			channel.close().addListener(ChannelFutureListener.CLOSE);
		}
	}
	
	/**
	 *
	 * @Title: restart
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public void restart() {
		stop();
		start();
	}

	/**
	 * 
	 * @Title: hitchEventSpy
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	protected abstract void hitchEventSpy();

	/**
	 * 
	 * @Title: timedCVReadTask
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	protected abstract void timedCVReadTask();

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * 
	 * @author Sherlock-lee
	 * @date 2015年11月18日 下午1:27:58
	 * @see TODO
	 * @since 1.0
	 */
	class HitchEventSpyThread extends Thread {

		/**
		 * 报警事件监听线程
		 */
		@Override
		public void run() {

			while (hitchEventSypSign) {

				try {

					Thread.sleep(hitchEventBreak);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hitchEventSpy();
			}
		}
	}

	/**
	 * 
	 * @author Sherlock-lee
	 * @date 2015年11月18日 下午1:27:54
	 * @see TODO
	 * @since 1.0
	 */
	class CVReadTaskThread extends Thread {

		@Override
		public void run() {

			while (cvReadTaskSign) {

				try {

					Thread.sleep(cvReadBreak);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				timedCVReadTask();
			}
		}
	}

	

}
