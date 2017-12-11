
package com.htdf.cc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htdf.cc.bussiness.nationstation.model.NationStationDTO;
import com.htdf.cc.bussiness.nationstation.service.NationStationService;


@RestController
public class MongodbController
{
	@Autowired
	NationStationService service;
	
	/**
	* @Title: save
	* @Description: 测试保存方法
	* @param @return    参数
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value = "save", method = RequestMethod.GET)
	public Map<String, Object> save()
	{
		Map<String, Object> msg = new HashMap<String, Object>();
		try
		{
//			NationStationDTO dto = new NationStationDTO();
//			dto.setId("e71d5664476f48fba73ab30fba296f03");
//			List<NationStationDTO> search = service.findByCondition(dto);
//			System.out.println(search.size()+"================================="+search.get(0).getStationName().toString());
			/*dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			dto.setStationCode("54517");
			dto.setStationName("天津站");
			dto.setWeather("晴转多云");
			dto.setWeatherDesc("天气描述");
			dto.setWindD("西北风");
			dto.setWindDesc("大风");
			dto.setWindv(4.5f);
			service.saveNationStation(dto);*/
			/*NationStationDTO searchDto = new NationStationDTO();
			searchDto.setId("e71d5664476f48fba73ab30fba296f03");
			searchDto.setStationName("121字");
			searchDto.setStationCode("542122");
			searchDto.setWeather("ddd");
			searchDto.setWeatherDesc("ddd");
			searchDto.setWindD("ddd");
			searchDto.setWindDesc("sss");
			searchDto.setWindv(3.4f);
			//修改
			System.out.println(searchDto.toString());
			service.updateNationStation(searchDto);*/
			
			//删除
//			service.deleteNationStation("e71d5664476f48fba73ab30fba296f03");
			List<NationStationDTO> list = new ArrayList<NationStationDTO>();
			for(int i=0;i<100;i++) {
				NationStationDTO searchDto = new NationStationDTO();
				searchDto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
				searchDto.setStationName("121字");
				searchDto.setStationCode("542122"+i);
				searchDto.setWeather("ddd"+i);
				searchDto.setWeatherDesc("ddd"+i);
				searchDto.setWindD("ddd"+i);
				searchDto.setWindDesc("sss"+i);
				searchDto.setWindv(3.4f);
				
				list.add(searchDto);
			}
			service.addBitch(list);
			msg.put("msg", "success");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			msg.put("msg", "false");
		}
		
		return msg;
	}
	
}
