package com.trivago.productcatalogue.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trivago.productcatalogue.domain.service.ProductService;
import com.trivago.productcatalogue.model.Amenity;
import com.trivago.productcatalogue.model.Hotel;


@RestController
@RequestMapping("/productcatalogue")
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * Read clicks.csv from resource folder.
	 * 
	 * @param objectId
	 * @return timestamp(int), hotel_id(int), hotel_region(string) on the basis of a
	 *         giver User Id.
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/hotels/{objectId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	Map<BigInteger, List<Hotel>> getHotelDetails(@PathVariable String objectId) throws Exception{
		Map<BigInteger, List<Hotel>> topHotels = productService.getTopHotels(objectId);
		if (topHotels == null) {
			throw new Exception("Could not find any data with user Id :" + objectId);
		}
		return topHotels;
	}
	
	/**
	 * Read selections.csv from resource folder.
	 * 
	 * @param objectId
	 * @return timestamp(int), amenity_id(int) on the basis of a given User Id.
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/amenities/{objectId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	Map<BigInteger, List<Amenity>> getAmenitiesDetails(@PathVariable String objectId) throws Exception {
		Map<BigInteger, List<Amenity>> topAmenity = productService.getTopAmenities(objectId);
		if (topAmenity == null) {
			throw new Exception("Could not find any data with user Id :" + objectId);
		}
		return topAmenity;
	}

}
