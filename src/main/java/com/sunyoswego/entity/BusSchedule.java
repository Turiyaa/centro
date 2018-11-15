package com.sunyoswego.entity;

public class BusSchedule {
	private int id;
	private Route route;
	private String stopid;
	private String scheduledTime;
	
	public BusSchedule(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getStopid() {
		return stopid;
	}

	public void setStopid(String stopid) {
		this.stopid = stopid;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	
}
