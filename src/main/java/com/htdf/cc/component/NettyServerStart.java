
package com.htdf.cc.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.htdf.cc.netty.NettyServer;


/**
* @ClassName: NettyServerStart
* @Description: 采集接收端默认启动netty服务端（order执行顺序，值越小越优先）
* @author zhuxiange
* @date 2017年11月29日
*
*/
@Component
@Order(value=1)
public class NettyServerStart implements CommandLineRunner
{
	private static final Logger Logger = LoggerFactory.getLogger(NettyServerStart.class);
	@Override
	public void run(String... arg0) throws Exception
	{
		Logger.info(">>>>>>>>>>>>>>>服务启动执行，执行nettyserver启动 <<<<<<<<<<<<<");
		//new NettyServer().bind(NettyServer.FILE_PORT);
	}
	
}
