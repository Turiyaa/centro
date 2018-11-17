package com.sunyoswego.entity;

public class BusSchedule {
	private int id;
	private int routeId;
	private String stpid;
	private String scheduledTime;
	
	public BusSchedule(){
		
	}
	
	public void displayInfo() {
		System.out.println("ID: " + id + ", Route ID:" + routeId + ", Stop ID: " + stpid + ", Scheduled Time: " + scheduledTime);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoute() {
		return routeId;
	}

	public void setRoute(int routeId) {
		this.routeId = routeId;
	}

	public String getStpid() {
		return stpid;
	}

	public void setStpid(String stpid) {
		this.stpid = stpid;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	
}
