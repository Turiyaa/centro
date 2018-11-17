package com.sunyoswego.entity;

public class Vehicle {
	private int id;
	private String vid;
	private String tmstmp;
	private Double lat;
	private Double lon;
	private String hdg;
	private int pid;
	private String rt;
	private String des;
	private int dly;
	private int pdist;
	private int spd;
	private String tatripid;
	private String tablockid;
	private String zone;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int id, String vid, String tmstmp, Double lat, Double lon, String hdg, int pid, String rt, 
			       String des, int dly, int pdist, int spd, String tatripid, String tablockid, String zone) {
		setId(id);
		setVid(vid);
		setTmstmp(tmstmp);
		setLat(lat);
		setLon(lon);
		setHdg(hdg);
		setPid(pid);
		setRt(rt);
		setDes(des);
		setDly(dly);
		setPdist(pdist);
		setSpd(spd);
		setTatripid(tatripid);
		setTablockid(tablockid);
		setZone(zone);
	}
	
	public void displayInfo() {
		System.out.println("ID: " + getId() + ", Bus Number: " + getVid() + ", Time Stamp: " + getTmstmp() + 
				           ", Latitude: " + getLat() + ", Longitude: " + getLon() + ", Direction: " + getHdg() + 
				           ", Pattern ID: " + getPid() + ", Route: " + getRt() + ", Destination: " + getDes() + 
				           ", Delayed?: " + getDly() + ", Ft. Traveled: " + getPdist() + ", MPH: " + getSpd() + 
				           ", TA Trip ID: " + getTatripid() + ", TA Block ID: " + getTablockid() + ", Zone?" + getZone());
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getTmstmp() {
		return tmstmp;
	}

	public void setTmstmp(String tmstmp) {
		this.tmstmp = tmstmp;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getHdg() {
		return hdg;
	}

	public void setHdg(String hdg) {
		this.hdg = hdg;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getDly() {
		return dly;
	}

	public void setDly(int dly) {
		this.dly = dly;
	}

	public Integer getPdist() {
		return pdist;
	}

	public void setPdist(int pdist) {
		this.pdist = pdist;
	}

	public Integer getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public String getTatripid() {
		return tatripid;
	}

	public void setTatripid(String tatripid) {
		this.tatripid = tatripid;
	}

	public String getTablockid() {
		return tablockid;
	}

	public void setTablockid(String tablockid) {
		this.tablockid = tablockid;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	

}
