
package com.htdf.cc.bussiness.nationstation.service;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.htdf.cc.bussiness.nationstation.model.NationStationDTO;
import com.htdf.cc.mongodb.MongoQueryUtils;
import com.htdf.cc.mongodb.MongoSearchEntity;
import com.mongodb.WriteResult;


/**
* @ClassName: NationStationServiceImpl
* @Description: 国家站mogodb入库实现类
* @author zhuxiange
* @date 2017年12月10日
*
*/
@Component
public class NationStationServiceImpl implements NationStationService
{
	private static final Logger	Logger			= LoggerFactory.getLogger(NationStationServiceImpl.class);
	//对应的表名
	private final static String	COLLECTION_NAME	= "b_nation_station";
	
	@Autowired
	private MongoTemplate		mongoTemplate;
	
	@Override
	public List<NationStationDTO> findByCondition(NationStationDTO model)
	{
		Logger.info("开始按条件查询国家站信息" + model.toString());
		Query queryBean = MongoQueryUtils.getMongoQuery(model);
		List<NationStationDTO> models = mongoTemplate.find(queryBean, NationStationDTO.class, COLLECTION_NAME);
		Logger.info("按条件查询国家站信息结束,总条数为:" + models.size());
		return models;
	}
	
	@Override
	public List<NationStationDTO> findUserByPage(NationStationDTO model, MongoSearchEntity pageBean)
	{
		Logger.info("开始按分页查询国家站信息" + model.toString());
		Query queryBean = MongoQueryUtils.getMongoQueryWithPage(model, pageBean);
		Logger.info("按分页查询国家站信息结束" + model.toString());
		return mongoTemplate.find(queryBean, NationStationDTO.class, COLLECTION_NAME);
	}
	
	@Override
	public void saveNationStation(NationStationDTO model)
	{
		Logger.info("开始按保存国家站信息" + model.toString());
		mongoTemplate.save(model, COLLECTION_NAME);
		Logger.info("保存国家站信息结束" + model.toString());
	}
	
	@Override
	public void updateNationStation(NationStationDTO model)
	{
		Logger.info("开始修改国家站信息" + model.toString());
		Query query = new Query(Criteria.where("_id").is(model.getId()));
		Update update = new Update().set("stationName", model.getStationName()).set("stationCode", model.getStationCode());
				/*.set("weatherDesc",model.getWeatherDesc()).set("weather", model.getWeather()).set("windD",model.getWindD())
				.set("windDesc", model.getWindDesc()).set("windv", model.getWindv());*/
		//更新查询返回结果集的第一条
		WriteResult result = mongoTemplate.upsert(query, update, COLLECTION_NAME);
		if(result!=null) {
			Logger.info(result.getN()+"==========");
		}else {
			Logger.info("0"+"==========");
		}
		//更新查询返回结果集的所有
		//mongoTemplate.updateMulti(query,update,NationStationDTO.class);
		Logger.info("修改国家站信息结束" + model.toString());
	}
	
	@Override
	public void deleteNationStation(String uuid)
	{
		Logger.info("开始删除国家站信息" + uuid);
		Query query = new Query(Criteria.where("_id").is(uuid));
		mongoTemplate.remove(query, COLLECTION_NAME);
		Logger.info("删除国家站信息结束" + uuid);
	}

	@Override
	public void addBitch(Collection<NationStationDTO> list)
	{
		mongoTemplate.insert(list,COLLECTION_NAME);
		
	}
	
}
