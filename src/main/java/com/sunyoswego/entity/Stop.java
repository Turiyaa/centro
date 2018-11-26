package com.sunyoswego.entity;

public class Stop {
	private int id;
	private String stpid;
	private String stpnm;
	private double lat;
	private double lon;
	private String route;
	private String dir;
	
	public Stop() {
		
	}
	
	public Stop(int id, String stpid, String stpnm, double lat, double lon, String route, String dir) {
		setId(id);
		setStpid(stpid);
		setStpnm(stpnm);
		setLat(lat);
		setLon(lon);
		setRoute(route);
		setDir(dir);
	}
	
	public void displayInfo() {
		System.out.println("ID: " + getId() + ", Route ID: " + getRoute() + ", Direction: " + getDir() + 
				           ", Stop ID: " + getStpid() + ", Stop Name: " + getStpnm() + 
				           ", Latitude: " + getLat() + ", Longitude: " + getLon());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStpid() {
		return stpid;
	}

	public void setStpid(String stopid) {
		this.stpid = stopid;
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