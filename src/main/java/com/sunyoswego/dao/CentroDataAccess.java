package com.sunyoswego.dao;

import com.sunyoswego.entity.BusSchedule;
import com.sunyoswego.entity.Prediction;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Schedule;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;
import java.util.ArrayList;

public interface CentroDataAccess {
	ArrayList<Vehicle> getVehicles();
	ArrayList<Stop> getStops();
	ArrayList<Route> getRoute();
	ArrayList<Prediction> getPrediction();
	ArrayList<BusSchedule> getBusSchedule();
}
