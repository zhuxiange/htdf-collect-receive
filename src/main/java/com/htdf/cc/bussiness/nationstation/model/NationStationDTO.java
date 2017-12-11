
package com.htdf.cc.bussiness.nationstation.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


/**
* @ClassName: NationStationDTO
* @Description: 国家站实体类
* @author zhuxiange
* @date 2017年12月10日
*
*/

public class NationStationDTO implements Serializable
{
	
	private static final long	serialVersionUID	= 1L;
	@Id
	private String				id;
	private String				stationCode;
	private String				stationName;
	private Float				windv;
	private String				windD;
	private String				windDesc;
	private String				weather;
	private String				weatherDesc;
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getStationCode()
	{
		return stationCode;
	}
	
	public void setStationCode(String stationCode)
	{
		this.stationCode = stationCode;
	}
	
	public String getStationName()
	{
		return stationName;
	}
	
	public void setStationName(String stationName)
	{
		this.stationName = stationName;
	}
	
	public Float getWindv()
	{
		return windv;
	}
	
	public void setWindv(Float windv)
	{
		this.windv = windv;
	}
	
	public String getWindD()
	{
		return windD;
	}
	
	public void setWindD(String windD)
	{
		this.windD = windD;
	}
	
	public String getWindDesc()
	{
		return windDesc;
	}
	
	public void setWindDesc(String windDesc)
	{
		this.windDesc = windDesc;
	}
	
	public String getWeather()
	{
		return weather;
	}
	
	public void setWeather(String weather)
	{
		this.weather = weather;
	}
	
	public String getWeatherDesc()
	{
		return weatherDesc;
	}
	
	public void setWeatherDesc(String weatherDesc)
	{
		this.weatherDesc = weatherDesc;
	}

	@Override
	public String toString()
	{
		return "NationStationDTO [id=" + id + ", stationCode=" + stationCode + ", stationName=" + stationName + ", windv=" + windv + ", windD=" + windD
				+ ", windDesc=" + windDesc + ", weather=" + weather + ", weatherDesc=" + weatherDesc + "]";
	}
	
}
