package com.sunyoswego.dao;

import java.util.ArrayList;

import com.sunyoswego.entity.BusSchedule;
import com.sunyoswego.entity.Prediction;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;

public interface CentroDataAccess {
	ArrayList<Vehicle> getVehicles();
	ArrayList<Prediction> getPrediction();
	ArrayList<BusSchedule> getBusSchedule();
	ArrayList<Stop> getAllStops();
	ArrayList<Route> getAllRoutes();
	ArrayList<String> getDirByRoute(String rt);
	ArrayList<Stop> getStopByRoutAndDir(String rt, String dir);
	ArrayList<Vehicle> getVehicleHistory(String rt, String time);
}
