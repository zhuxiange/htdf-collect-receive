
package com.htdf.cc.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;


/**
* @ClassName: NettyServer
* @Description: netty服务端
* @author zhuxiange
* @date 2017年11月29日
*
*/

public class NettyServer
{
	//服务端开启的端口号
	public static final int FILE_PORT = 9991;
	
	private static final Logger Logger = LoggerFactory.getLogger(NettyServer.class);
	
	public void bind(int port) throws Exception
	{
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		Logger.info("等待客户端链接===========================");
		try
		{
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 1024)
					.childHandler(new ChannelInitializer<Channel>()
					{
						
						@Override
						protected void initChannel(Channel ch) throws Exception
						{
							Logger.info("客户端链接的IP" + ch.localAddress().toString());
							ch.pipeline().addLast(new ObjectEncoder());
							ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null))); // ��󳤶�
							ch.pipeline().addLast(new NettyServerHandler());
						}
					});
			ChannelFuture f = b.bind(port).sync();
			Logger.info("服务端开始处理=================");
			f.channel().closeFuture().sync();
			Logger.info("服务端处理结束=================");
		}
		finally
		{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	
/*	public static void main(String[] args)
	{
		int port = FILE_PORT;
		if (args != null && args.length > 0)
		{
			try
			{
				port = Integer.valueOf(args[0]);
			}
			catch (NumberFormatException e)
			{
				e.printStackTrace();
			}
		}
		try
		{
			new NettyServer().bind(port);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/
	
	
}
