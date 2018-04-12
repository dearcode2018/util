/**
 * Location.java
 * @author  qye.zheng
 * 
 * 	version 1.0
 */
package com.hua.entity.location;

/**
 * Location
 * 描述: 位置信息
 * @author  qye.zheng
 * 
 */
public final class Location
{
	
	/* 经度 */
	private float longitude;

	/* 纬度 */
	private float latitude;

	/**
	 * @return the longitude
	 */
	public float getLongitude()
	{
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public float getLatitude()
	{
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude)
	{
		this.latitude = latitude;
	}
	
}
