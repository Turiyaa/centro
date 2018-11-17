package com.sunyoswego.entity;

public class Route {
	private int id;
    private String rt;
	private String rtnm;
	private String rtclr;
	private String rtdd;

	public Route() {
		
	}
	
	public void displayInfo() {
		System.out.println("ID: " + getId() + ", Route: " + getRt() + ", Route Name: " + getRtnm() + 
				           ", Route Color: " + getRtclr() + ", Route Designator: " + getRtdd());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getRtnm() {
		return rtnm;
	}

	public void setRtnm(String rtnm) {
		this.rtnm = rtnm;
	}

	public String getRtclr() {
		return rtclr;
	}

	public void setRtclr(String rtclr) {
		this.rtclr = rtclr;
	}

	public String getRtdd() {
		return rtdd;
	}

	public void setRtdd(String rtdd) {
		this.rtdd = rtdd;
	}
	
	
}
