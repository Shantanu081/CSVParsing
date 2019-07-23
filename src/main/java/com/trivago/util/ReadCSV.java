package com.trivago.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.trivago.productcatalogue.model.Amenity;
import com.trivago.productcatalogue.model.Hotel;

public class ReadCSV {
	private static final String csvSplitBy = ",";

	public Map<BigInteger, List<Hotel>> readClicks(String pathToClicksCSV, String ursId) throws FileNotFoundException {
		ArrayList<Hotel> hotels = new ArrayList<>();
		Map<BigInteger, List<Hotel>> topHotels = null;
		InputStreamReader is = new InputStreamReader(getClass().getResourceAsStream(pathToClicksCSV));
		BufferedReader br = new BufferedReader(is);
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				Hotel hotel = new Hotel();
				// use comma as separator
				String[] cols = line.split(csvSplitBy);

				hotel.setUpdatedAt(cols[0].isEmpty() ? null : Integer.valueOf(cols[0]));
				hotel.setUsrId(cols[1].isEmpty() ? null : new BigInteger(cols[1]));
				hotel.setHotelId(cols[2].isEmpty() ? null : new BigInteger(cols[2]));
				hotel.setHotelRegion(cols[3].isEmpty() ? null : cols[3]);

				hotels.add(hotel);
			}
			topHotels = retriveHotels(hotels, ursId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return topHotels;
	}

	public Map<BigInteger, List<Amenity>> readSelections(String pathToAmenitiesCSV, String objectId)
			throws FileNotFoundException {
		ArrayList<Amenity> amenities = new ArrayList<>();
		Map<BigInteger, List<Amenity>> topAmenities = null;
		InputStreamReader is = new InputStreamReader(getClass().getResourceAsStream(pathToAmenitiesCSV));
		BufferedReader br = new BufferedReader(is);
		try {
			String line = null;
			while ((line = br.readLine()) != null) {
				Amenity hotel = new Amenity();
				// use comma as separator
				String[] cols = line.split(csvSplitBy);

				hotel.setUpdatedAt(Integer.valueOf(cols[0]));
				hotel.setUsrId(new BigInteger(cols[1]));
				hotel.setAmenityId(new BigInteger(cols[2]));

				amenities.add(hotel);
			}
			topAmenities = retriveAminities(amenities, objectId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return topAmenities;
	}

	private static Map<BigInteger, List<Amenity>> retriveAminities(ArrayList<Amenity> amenities, String objectId)
			throws Exception {

		if (objectId.isEmpty()) {
			throw new Exception("User Id cannot be null, please provide a value");
		}
		Map<BigInteger, List<Amenity>> result = amenities.stream()
				.filter(T -> T.getUsrId().equals(new BigInteger(objectId)))
				.collect(Collectors.groupingBy(Amenity::getUsrId));

		if (result == null) {
			throw new Exception("Could not find any data with user Id :" + objectId);
		}
		result.forEach((k, v) -> System.out.println("UserId : " + k + " Details : " + v));

		return result;
	}

	private static Map<BigInteger, List<Hotel>> retriveHotels(ArrayList<Hotel> hotels, String usrId) throws Exception {

		if (usrId.isEmpty()) {
			throw new Exception("User Id cannot be null, please provide a value");
		}
		Map<BigInteger, List<Hotel>> result = hotels.stream().filter(T -> T.getUsrId().equals(new BigInteger(usrId)))
				.collect(Collectors.groupingBy(Hotel::getUsrId));

		if (result == null) {
			throw new Exception("Could not find any data with user Id :" + usrId);
		}
		result.forEach((k, v) -> System.out.println("UserId : " + k + " Details : " + v));

		return result;

	}
}
