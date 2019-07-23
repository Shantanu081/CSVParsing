package com.trivago.productcatalogue.model;

import java.math.BigInteger;

public class Hotel {

    private Integer updatedAt;
    private BigInteger usrId;
    private BigInteger hotelId;
    private String hotelRegion;
    
	
	public Integer getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Integer updatedAt) {
		this.updatedAt = updatedAt;
	}


	public BigInteger getUsrId() {
		return usrId;
	}


	public void setUsrId(BigInteger usrId) {
		this.usrId = usrId;
	}


	public BigInteger getHotelId() {
		return hotelId;
	}


	public void setHotelId(BigInteger hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelRegion() {
		return hotelRegion;
	}


	public void setHotelRegion(String hotelRegion) {
		this.hotelRegion = hotelRegion;
	}


	@Override
	public String toString() {
		return "Hotel [updatedAt=" + updatedAt + ", usrId=" + usrId + ", hotelId=" + hotelId + ", hotelRegion="
				+ hotelRegion + "]";
	}

}
