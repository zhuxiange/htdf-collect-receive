
package com.htdf.cc.bussiness.nationstation.service;

import java.util.Collection;
import java.util.List;

import com.htdf.cc.bussiness.nationstation.model.NationStationDTO;
import com.htdf.cc.mongodb.MongoSearchEntity;


/**
* @ClassName: NationStationDao
* @Description: 国家站入库(增、删、改、查、分页查样例)
* @author zhuxiange
* @date 2017年12月10日
*
*/

public interface NationStationService
{
	
	/**
	* @Title: findByCondition
	* @Description: 按照条件查询
	* @param @param user
	* @param @return    参数
	* @return List<NationStationDTO>    返回类型
	* @throws
	*/
	
	List<NationStationDTO> findByCondition(NationStationDTO model);
	
	/**
	* @Title: findUserByPage
	* @Description: 分页查询
	* @param @param queryBean
	* @param @param pageBean
	* @param @return    参数
	* @return List<NationStationDTO>    返回类型
	* @throws
	*/
	
	List<NationStationDTO> findUserByPage(NationStationDTO queryBean, MongoSearchEntity pageBean);
	
	/**
	* @Title: saveNationStation
	* @Description: 保存对象
	* @param @param user    参数
	* @return void    返回类型
	* @throws
	*/
	
	void saveNationStation(NationStationDTO model);
	
	/**
	* @Title: updateNationStation
	* @Description: 更新对象
	* @param @param model    参数
	* @return void    返回类型
	* @throws
	*/
	
	void updateNationStation(NationStationDTO model);
	
	/**
	* @Title: deleteNationStation
	* @Description: 删除
	* @param @param uuid    参数
	* @return void    返回类型
	* @throws
	*/
	
	void deleteNationStation(String uuid);
	
	/**
	* @Title: addBitch
	* @Description: 批量插入
	* @param @param list    参数
	* @return void    返回类型
	* @throws
	*/
	
	void addBitch(Collection<NationStationDTO> list);
	
}
