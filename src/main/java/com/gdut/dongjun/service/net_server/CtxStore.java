package com.gdut.dongjun.service.net_server;

import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @Title: ClientList.java
 * @Package com.gdut.dongjun.service.impl
 * @Description: 应用单例模式，用一个List管理设备与服务器之间的连接SwitchGPRS,包含Id,address,ctx等属性
 * @author Sherlock-lee
 * @date 2015年8月11日 下午4:30:06
 * @version V1.0
 * @see {@link SwitchGPRS}
 */
@Component
public abstract class CtxStore {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CtxStore.class);
	private static final List<SwitchGPRS> ctxlist = new LinkedList<SwitchGPRS>();

	private CtxStore() {
		super();
	}

	/**
	 * 
	 * @Title: getInstance
	 * @Description: TODO
	 * @param @return
	 * @return List<SwitchGPRS>
	 * @throws
	 */
	public static List<SwitchGPRS> getInstance() {

		return ctxlist;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: TODO
	 * @param @param ctx
	 * @param @return
	 * @return SwitchGPRS
	 * @throws
	 */
	public static SwitchGPRS get(ChannelHandlerContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - start");
		}

		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && ctx.equals(gprs.getCtx())) {
					return gprs;
				}
			}
		} else {
			logger.info("ctxlist is empty!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end");
		}
		return null;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: TODO
	 * @param @param id
	 * @param @return
	 * @return SwitchGPRS
	 * @throws
	 */
	public static SwitchGPRS get(String id) {
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - start");
		}

		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && id.equals(gprs.getId())) {
					return gprs;
				}

			}
		} else {
			logger.info("ctxlist is empty!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end");
		}
		return null;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: TODO
	 * @param @param address
	 * @param @return
	 * @return SwitchGPRS
	 * @throws
	 */
	public static String getId(String address) {
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - start");
		}
		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && address.equals(gprs.getAddress())) {
					return gprs.getId();
				}

			}
		} else {
			logger.info("ctxlist is empty!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end");
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param @param ctx
	 * @return void
	 * @throws
	 */
	public static void add(SwitchGPRS ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("add(SwitchGPRS) - start");
		}

		ctxlist.add(ctx);
		printCtxStore();

		if (logger.isDebugEnabled()) {
			logger.debug("add(SwitchGPRS) - end");
		}
	}

	/**
	 * 
	 * @Title: remove
	 * @Description: TODO
	 * @param @param ctx
	 * @return void
	 * @throws
	 */
	public static void remove(ChannelHandlerContext ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - start");
		}

		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && ctx.equals(gprs.getCtx())) {
					
					ctxlist.remove(gprs);
				}
			}
		} else {
			logger.info("ctxlist is empty, no gprs has bean remove!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end");
		}
	}

	/**
	 * 
	 * @Title: clear
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public static void clear() {
		if (logger.isDebugEnabled()) {
			logger.debug("clear() - start");
		}

		ctxlist.clear();

		if (logger.isDebugEnabled()) {
			logger.debug("clear() - end");
		}
	}

	/**
	 * 
	 * @Title: updateSwtichOpen
	 * @Description: TODO
	 * @param @param id
	 * @return void
	 * @throws
	 */
	public static void updateSwtichOpen(String id) {

		SwitchGPRS gprs = get(id);
		if (gprs != null && id.equals(gprs.getId())) {
			gprs.setOpen(true);
			printCtxStore();
		} else {
			logger.info("ctxlist is empty!");
		}
	}

	/**
	 * 
	 * @Title: excute
	 * @Description: TODO
	 * @param @param msg
	 * @return void
	 * @throws
	 */
	public static void excute(String id, String msg) {

		if (logger.isDebugEnabled()) {
			logger.debug("excute(String) - start");
		}

		SwitchGPRS gprs = get(id);
		if (gprs != null && gprs.getCtx() != null) {

			gprs.getCtx().writeAndFlush(msg);
			logger.info("excute " + msg);
		} else {

			logger.info("there is an error accour in excuting !");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("excute(String) - end");
		}
	}

	/**
	 * 
	 * @Title: printCtxStore
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public static void printCtxStore() {
		if (logger.isDebugEnabled()) {
			logger.debug("printCtxStore() - start");
		}

		logger.info("ctx in the store now:");
		if (ctxlist != null) {
			for (int i = 0; i < ctxlist.size(); i++) {

				logger.info(ctxlist.get(i));
			}
		} else {
			logger.info("CtxStore is empty");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("printCtxStore() - end");
		}
	}
	

}
