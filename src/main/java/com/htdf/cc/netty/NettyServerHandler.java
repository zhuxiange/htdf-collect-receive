
package com.htdf.cc.netty;

import java.io.File;
import java.io.RandomAccessFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.htdf.cc.netty.model.Message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
* @ClassName: NettyServerHandler
* @Description: 服务端处理通道
* @author zhuxiange
* @date 2017年11月29日
*
*/

public class NettyServerHandler extends ChannelInboundHandlerAdapter
{
	private int					byteRead;
	private volatile int		start		= 0;
	private String				file_dir	= "e:";
	private static final Logger	Logger		= LoggerFactory.getLogger(NettyServerHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{
		super.channelActive(ctx);
		Logger.info("服务端通道启动");
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception
	{
		super.channelInactive(ctx);
		ctx.flush();
		ctx.close();
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		if (msg instanceof Message)
		{
			Message ef = (Message) msg;
			byte[] bytes = ef.getBytes();
			byteRead = ef.getEndPos();
			String md5 = ef.getFile_md5();
			String path = file_dir + File.separator + md5;
			File file = new File(path);
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
			randomAccessFile.seek(start);
			randomAccessFile.write(bytes);
			start = start + byteRead;
			if (byteRead > 0)
			{
				ctx.writeAndFlush(start);
				randomAccessFile.close();
				if (byteRead != 1024 * 10)
				{
					Thread.sleep(1000);
					channelInactive(ctx);
				}
			}
			else
			{
				ctx.close();
			}
			
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		cause.printStackTrace();
		ctx.close();
		Logger.info("netty服务端接收异常");
	}
}
