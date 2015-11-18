package com.gdut.dongjun.web.net_server.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.gdut.dongjun.util.HexString_BytesUtil;

/**
 * @Title: TimeDecoder.java
 * @Package com.gdut.netty_testing.pojo.client
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年7月8日 上午11:21:21
 * @version V1.0
 */
public class Decoder extends ByteToMessageDecoder {
	/**
	 * @ClassName: TimeDecoder
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年7月8日 上午11:21:21
	 */
	
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) {

		if (in.readableBytes() < 6) {
			return;
		}
		byte[] bytes = new byte[in.writerIndex()];
		in.readBytes(bytes);
		out.add(HexString_BytesUtil.bytesToHexString(bytes));
	}
}
