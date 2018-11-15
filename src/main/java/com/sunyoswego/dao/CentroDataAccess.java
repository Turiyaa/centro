package com.sunyoswego.dao;

import java.util.ArrayList;

import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;

public interface CentroDataAccess {
	Vehicle getAllVehicles();
	Stop getAllStops();
}
