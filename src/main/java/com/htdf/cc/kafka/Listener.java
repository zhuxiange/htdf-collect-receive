
package com.htdf.cc.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;


/**
* @ClassName: Listener
* @Description: kafka消息接收端处理
* @author zhuxiange
* @date 2017年12月11日
*
*/

public class Listener
{
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@KafkaListener(topics = { MsgConstants.TOPIC_MSG })
	public void listen(ConsumerRecord<?, ?> record)
	{
		logger.info("kafka的key: " + record.key());
		logger.info("kafka的value: " + record.value().toString());
		String key = record.key().toString();
		switch(key) {
			case MsgConstants.NATION_STATION_MSG:
				logger.info("国家站消息处理"+record.value());
				break;
			default:
				logger.info("消息类型不识别，不处理此消息");
		}
	}
	
}
