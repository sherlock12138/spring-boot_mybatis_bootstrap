package com.gdut.dongjun.service.net_server;

import io.netty.channel.ChannelHandlerContext;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.gdut.dongjun.service.impl.DataZone;
import com.gdut.dongjun.service.impl.enums.EventVariable;
import com.gdut.dongjun.util.LowVoltageDeviceCommandUtil;

/**
 * @Title: ClientList.java
 * @Package com.gdut.dongjun.service.impl
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年8月11日 下午4:30:06
 * @version V1.0
 */
@Component
public class CtxStore {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(CtxStore.class);

	/**
	 * @ClassName: ClientList
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年8月11日 下午4:30:06
	 */
	private static List<SwitchGPRS> ctxlist = new LinkedList<SwitchGPRS>();

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
	 * @Title: add
	 * @Description: TODO
	 * @param @param ctx
	 * @return void
	 * @throws
	 */
	public static void add(SwitchGPRS ctx) {
		if (logger.isDebugEnabled()) {
			logger.debug("add(SwitchGPRS) - start"); //$NON-NLS-1$
		}

		ctxlist.add(ctx);
		printCtxStore();

		if (logger.isDebugEnabled()) {
			logger.debug("add(SwitchGPRS) - end"); //$NON-NLS-1$
		}
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
			logger.debug("remove(SwitchGPRS) - start"); //$NON-NLS-1$
		}

		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && ctx.equals(gprs.getCtx())) {
					return gprs;
				}

			}
		} else {
			logger.info("ctxlist is empty, no gprs has bean remove!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end"); //$NON-NLS-1$
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
			logger.debug("remove(SwitchGPRS) - start"); //$NON-NLS-1$
		}

		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && id.equals(gprs.getId())) {
					return gprs;
				}

			}
		} else {
			logger.info("ctxlist is empty, no gprs has bean remove!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end"); //$NON-NLS-1$
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
			logger.debug("remove(SwitchGPRS) - start"); //$NON-NLS-1$
		}
		if (ctxlist != null) {

			for (SwitchGPRS gprs : ctxlist) {

				if (gprs != null && address.equals(gprs.getAddress())) {
					return gprs.getId();
				}

			}
		} else {
			logger.info("ctxlist is empty, no gprs has bean remove!");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("remove(SwitchGPRS) - end"); //$NON-NLS-1$
		}
		return null;
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
			logger.debug("remove(SwitchGPRS) - start"); //$NON-NLS-1$
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
			logger.debug("remove(SwitchGPRS) - end"); //$NON-NLS-1$
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
			logger.debug("clear() - start"); //$NON-NLS-1$
		}

		ctxlist.clear();

		if (logger.isDebugEnabled()) {
			logger.debug("clear() - end"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @Title: beginHitchEventSpy
	 * @Description: TODO
	 * @param
	 * @return void
	 * @throws
	 */
	public static void hitchEventSpy() {

		printCtxStore();
		for (SwitchGPRS switchGPRS : ctxlist) {

			if (switchGPRS != null && switchGPRS.getCtx() != null
					&& switchGPRS.getAddress() != null) {

				logger.info("syping " + switchGPRS.getAddress());
				String msg = LowVoltageDeviceCommandUtil.read(switchGPRS.getAddress(),
						new DataZone(EventVariable.HITCH_EVENT.toString()));

				switchGPRS.getCtx().writeAndFlush(msg);
			} else {
				logger.error("the store is empty!");
			}
		}

	}

	/**
	 * 
	 * @Title: timedCVRead
	 * @Description: 定时读取电流电压
	 * @param
	 * @return void
	 * @throws
	 */
	public static void timedCVReadTask() {
		// TODO Auto-generated method stub
		for (SwitchGPRS switchGPRS : ctxlist) {

			if (switchGPRS != null && switchGPRS.getCtx() != null
					&& switchGPRS.getAddress() != null) {

				logger.info("reading " + switchGPRS.getAddress() + " voltage");
				// 读取电压
				String msg = LowVoltageDeviceCommandUtil.readAllPhaseVoltage(switchGPRS
						.getAddress());

				switchGPRS.getCtx().writeAndFlush(msg);

				logger.info("reading " + switchGPRS.getAddress() + " current");
				// 读取电流
				msg = LowVoltageDeviceCommandUtil.readAllPhaseCurrent(switchGPRS.getAddress());

				switchGPRS.getCtx().writeAndFlush(msg);

			} else {
				logger.error("the store is empty!");
			}
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
			logger.info("ctxlist is empty, no gprs has bean remove!");
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
			logger.debug("printCtxStore() - start"); //$NON-NLS-1$
		}

		logger.info("ctx in the store now:");
		if (ctxlist != null) {
			for (int i = 0; i < ctxlist.size(); i++) {

				logger.info(ctxlist.get(i));
			}
		} else {
			logger.info("CtxStore is null");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("printCtxStore() - end"); //$NON-NLS-1$
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
			logger.debug("excute(String) - start"); //$NON-NLS-1$
		}

		SwitchGPRS gprs = get(id);
		if (gprs != null && gprs.getCtx() != null) {
			gprs.getCtx().writeAndFlush(msg);
			logger.info("excute " + msg);
		} else {

			logger.info("there is an error accour in excuting !");
		}

		// CtxStore.getInstance().get(0).writeAndFlush("aabbcc");
		// for (SwitchGPRS ctx : ctxlist) {
		//
		// ChannelFuture f = ctx.writeAndFlush(msg);
		// // logger.info("this:" + f.channel().pipeline().);
		// logger.info("future  " + ctx.read());
		//
		// }

		if (logger.isDebugEnabled()) {
			logger.debug("excute(String) - end"); //$NON-NLS-1$
		}
	}
	// 多线程的支持
	// if (address.equals("1")) {
	// CtxStore.getInstance().get(0).writeAndFlush("111111");
	// try {
	// Thread.sleep(10 * 1000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// CtxStore.getInstance().get(0).writeAndFlush("111111");
	// } else if (address.equals("2")) {
	// CtxStore.getInstance().get(0).writeAndFlush("22222222");
	// }

}
