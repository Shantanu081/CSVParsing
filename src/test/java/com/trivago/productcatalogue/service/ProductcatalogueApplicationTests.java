package com.trivago.productcatalogue.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.trivago.productcatalogue.model.Amenity;
import com.trivago.productcatalogue.model.Hotel;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductcatalogueApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetHotels() {
    	@SuppressWarnings("unchecked")
		Map<BigInteger, List<Hotel>> hotels = (Map<BigInteger, List<Hotel>>) restTemplate.getForObject("/productcatalogue/hotels/{objectId}", Map.class, "1063458341271753948");
    	assertEquals(hotels.keySet().toString(), "[1063458341271753948]");
    }
    
    @Test
    public void testGetAmenitise() {
    	@SuppressWarnings("unchecked")
		Map<BigInteger, List<Amenity>> hotels = (Map<BigInteger, List<Amenity>>) restTemplate.getForObject("/productcatalogue/amenities/{objectId}", Map.class, "2835680135910998");
    	assertEquals(hotels.keySet().toString(), "[2835680135910998]");
    }

}
