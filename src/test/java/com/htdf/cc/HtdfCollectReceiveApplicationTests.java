
package com.htdf.cc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.htdf.cc.bussiness.nationstation.model.NationStationDTO;
import com.htdf.cc.bussiness.nationstation.service.NationStationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HtdfCollectReceiveApplicationTests
{
	
	@Autowired
	NationStationService service;
	
	@Test
	public void testSave()
	{
		NationStationDTO dto = new NationStationDTO();
		dto.setStationCode("54517");
		dto.setStationName("天津站");
		dto.setWeather("晴转多云");
		dto.setWeatherDesc("天气描述");
		dto.setWindD("西北风");
		dto.setWindDesc("大风");
		dto.setWindv(4.5f);
		service.saveNationStation(dto);
	}
	
}
