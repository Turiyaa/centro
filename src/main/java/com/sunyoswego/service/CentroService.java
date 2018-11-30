package com.sunyoswego.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Multimap;
import com.sunyoswego.dao.CentroDao;
import com.sunyoswego.entity.Vehicle;

public class CentroService {
	CentroDao dao;

	public ArrayList<Vehicle> filterBusHistory(String lat2, String lon2) {
		dao = new CentroDao();
		lat2 = "43.45395200000100";
		lon2 = "-76.54026300000000";
		ArrayList<Double> distanceList = new ArrayList<>();
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> filterVehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> closestVehicleData = new ArrayList<Vehicle>();
		Multimap<String, Vehicle> history = dao.getVehicleHistory("OSW11", "08:00");
		Set<String> keys = history.keySet();
		for (String key : keys) {
			System.out.println("Key = " + key);
			System.out.println("Values = " + history.get(key) + "n");
			for (Vehicle v : history.get(key)) {
				System.out.println(
						v.getLat() + " " + v.getLon() + " " + Double.valueOf(lat2) + " " + Double.valueOf(lon2));
				double distance = distance(v.getLat(), v.getLon(), Double.valueOf(lat2), Double.valueOf(lon2));
				distanceList.add(distance);
				filterVehicles.add(v);
			}
			int minIndex = distanceList.indexOf(Collections.min(distanceList));
			closestVehicleData.add(filterVehicles.get(minIndex));
			filterVehicles.clear();
			distanceList.clear();
		}
		for (Vehicle vc : closestVehicleData) {
			vc.displayInfo();
		}
		return vehicles;

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
