package com.trivago.productcatalogue.domain.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.trivago.productcatalogue.model.Amenity;
import com.trivago.productcatalogue.model.Hotel;

public interface ProductService {
	
	Map<BigInteger, List<Hotel>> getTopHotels(String ursId);
	Map<BigInteger, List<Amenity>> getTopAmenities(String objectId);

}
