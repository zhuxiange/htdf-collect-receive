
package com.htdf.cc.activemq;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.jms.JMSException;
import javax.jms.Message;

import org.apache.activemq.BlobMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MsgCustomer
{
	@JmsListener(destination = "test.queue")
	public void receiveMsg(String text)
	{
		System.out.println("<<<<<<============接收端2 收到消息： " + text);
	}
	
	@JmsListener(destination = "test.queueFile")
	public void receiveMsgFile(Message msg) throws IOException, JMSException
	{
		if(msg instanceof BlobMessage) {
			long start = System.currentTimeMillis();
			BlobMessage blobMessage = (BlobMessage) msg;
			String sendType = blobMessage.getStringProperty("sendType");
            String jsonData = blobMessage.getStringProperty("jsonData");
            String fileName = blobMessage.getStringProperty("fileName");
            String fileSize = blobMessage.getStringProperty("fileSize");
			OutputStream os = new FileOutputStream("d:/exe/receive/"+fileName);
            InputStream inputStream = blobMessage.getInputStream();
            // 写文件，你也可以使用其他方式
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) > 0) {
                os.write(buff, 0, len);
            }
            os.close();
            long end = System.currentTimeMillis();
            System.out.println("处理一个文件消息一共花费时间"+(end-start)+"；====文件大小为"+fileSize);
            //System.out.println(jsonData);
		}else {
			System.out.println("不是文件类型消息");
		}
	}
}
