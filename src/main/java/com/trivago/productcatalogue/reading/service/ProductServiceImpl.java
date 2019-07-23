package com.trivago.productcatalogue.reading.service;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.trivago.productcatalogue.domain.service.ProductService;
import com.trivago.productcatalogue.model.Amenity;
import com.trivago.productcatalogue.model.Hotel;
import com.trivago.util.ReadCSV;

@Service
public class ProductServiceImpl implements ProductService {

	private static final String pathToClicksCSV = "/csv/clicks.csv";
	private static final String pathToAmenitiesCSV = "/csv/selections.csv";

	@Override
	public Map<BigInteger, List<Hotel>> getTopHotels(String ursId) {
		Map<BigInteger, List<Hotel>> topHotels = new HashMap<>();
		try {

			ReadCSV readCSV = new ReadCSV();
			topHotels = readCSV.readClicks(pathToClicksCSV, ursId);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return topHotels;
	}

	@Override
	public Map<BigInteger, List<Amenity>> getTopAmenities(String objectId) {
		Map<BigInteger, List<Amenity>> topAmenitiesByUserId = new HashMap<>();
		try {

			ReadCSV readCSV = new ReadCSV();
			topAmenitiesByUserId = readCSV.readSelections(pathToAmenitiesCSV, objectId);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return topAmenitiesByUserId;

	}

}
