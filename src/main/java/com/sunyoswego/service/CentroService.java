package com.sunyoswego.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.sunyoswego.dao.CentroDao;
import com.sunyoswego.entity.Vehicle;

public class CentroService {
	CentroDao dao;

	public Multimap<LocalTime, Integer> filterBusHistory(String lat2, String lon2, String scheduledTime, String rt) {
		dao = new CentroDao();
		//lat2 = "43.45395200000100";
		//lon2 = "-76.54026300000000";
		//scheduledTime = "08:00";
		//rt = "OSW11";
		ArrayList<Double> distanceList = new ArrayList<>();
		ArrayList<Vehicle> filterVehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> closestVehicleData = new ArrayList<Vehicle>();
		Multimap<String, Vehicle> history = dao.getVehicleHistory(rt, scheduledTime);
		Set<String> keys = history.keySet();
		for (String key : keys) {
			for (Vehicle v : history.get(key)) {
				double distance = distance(v.getLat(), v.getLon(), Double.valueOf(lat2), Double.valueOf(lon2));
				distanceList.add(distance);
				filterVehicles.add(v);
			}
			int minIndex = distanceList.indexOf(Collections.min(distanceList));
			closestVehicleData.add(filterVehicles.get(minIndex));
			filterVehicles.clear();
			distanceList.clear();
		}
		DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
		LocalTime time = formatter.parseLocalTime(scheduledTime);
		LocalTime xTime1 = time.minusMinutes(10);
		int xTime1Freq = 0;
		LocalTime xTime2 = time.minusMinutes(5);
		int xTime2Freq = 0;
		int xTime3Freq = 0;
		LocalTime xTime3 = time;
		int xTime4Freq = 0;
		LocalTime xTime4 = time.plusMinutes(5);
		int xTime5Freq = 0;
		LocalTime xTime5 = time.plusMinutes(10);

		for (Vehicle vc : closestVehicleData) {
			String timeStr = vc.getTmstmp().substring(9,14);
			LocalTime actualTime = formatter.parseLocalTime(timeStr);
			if (actualTime.isBefore(xTime1)) {
				xTime1Freq++;
			} else if (actualTime.isAfter(xTime1) && actualTime.isBefore(xTime2)) {
				xTime2Freq++;
			} else if (actualTime.isAfter(xTime2) && actualTime.isBefore(xTime3)) {
				xTime3Freq++;
			} else if (actualTime.isAfter(xTime3) && actualTime.isBefore(xTime4)) {
				xTime4Freq++;
			} else {
				xTime5Freq++;
			}
		}

		// should return times and frequency
		Multimap<LocalTime, Integer> graphData = ArrayListMultimap.create();
		graphData.put(xTime4, xTime4Freq);
		graphData.put(xTime3, xTime3Freq);
		graphData.put(xTime5, xTime5Freq);
		graphData.put(xTime2, xTime2Freq);
		graphData.put(xTime1, xTime1Freq);
		TreeMultimap<LocalTime, Integer> sortedMap = TreeMultimap.create(graphData);

		return sortedMap;
	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344 * 1000 * 3.28084;
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

}
