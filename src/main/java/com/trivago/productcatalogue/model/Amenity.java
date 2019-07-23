package com.trivago.productcatalogue.model;

import java.math.BigInteger;

public class Amenity {
	private Integer updatedAt;
	private BigInteger usrId;
	private BigInteger amenityId;
	
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
	public BigInteger getAmenityId() {
		return amenityId;
	}
	public void setAmenityId(BigInteger amenityId) {
		this.amenityId = amenityId;
	}
	
	@Override
	public String toString() {
		return "Amenity [updatedAt=" + updatedAt + ", usrId=" + usrId + ", amenityId=" + amenityId + "]";
	}

}
