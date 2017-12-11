
package com.htdf.cc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
* @ClassName: HtdfCollectReceiveApplication
* @Description: kafka消费端\入库端
* @author zhuxiange
* @date 2017年11月28日
*
*/

@SpringBootApplication
public class HtdfCollectReceiveApplication
{
	
	private static final Logger Logger = LoggerFactory.getLogger(HtdfCollectReceiveApplication.class);
	
	public static void main(String[] args)
	{
		
		Logger.info("微服务入口函数编码-" + System.getProperty("file.encoding"));
		
		SpringApplication.run(HtdfCollectReceiveApplication.class, args);
		
		System.out.println("【【【【【【 采集集群项目 】】】】】】已启动.");
	}
}
