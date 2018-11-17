package com.sunyoswego.entity;

public class Schedule {
	private int id;
	private String stpnm;
	private String stpid;
	private double lat;
	private double lon;
	private String route;
	private String dir;
	private String scheduledTime;
	
	public Schedule() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStpnm() {
		return stpnm;
	}

	public void setStpnm(String stpnm) {
		this.stpnm = stpnm;
	}

	public String getStpid() {
		return stpid;
	}

	public void setStpid(String stpid) {
		this.stpid = stpid;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	
}
