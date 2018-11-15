package com.sunyoswego.entity;

public class Stop {
	private int id;
	private int stopid;
	private String stpnm;
	private double lat;
	private double lon;
	private String route;
	private String dir;
	
	public Stop() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStopid() {
		return stopid;
	}

	public void setStopid(int stopid) {
		this.stopid = stopid;
	}

	public String getStpnm() {
		return stpnm;
	}

	public void setStpnm(String stpnm) {
		this.stpnm = stpnm;
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
	
	
}