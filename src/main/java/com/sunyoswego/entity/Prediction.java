package com.sunyoswego.entity;

public class Prediction {
	private int id;
	private String tmstmp;
	private String typ;
	private String stpnm;
	private String stpid;
	private String vid;
	private int dstp;
	private String rt;
	private String rtdd;
	private String rtdir;
	private String des;
	private String prdtm;
	private String tablockid;
	private String tatripid;
	private boolean dly;
	private int dyn;
	private String prdctdn;
	private String zone;

	public Prediction() {
		
	}
	
	public void displayInfo() {
		System.out.println("ID: " + id + ", Time Stamp: " + tmstmp + ", Arrival/Departure: " + typ + 
				           ", Stop Name: " + stpnm + ", Stop ID: " + stpid + ", Vehicle ID: " + vid +
				           ", Ft Until Next Stop: " + dstp + ", Route: " + rt + ", Route Designator: " + rtdd +
				           ", Direction: " + rtdir + ", Final Destination: " + des + ", Predicted TOA: " + prdtm +
				           ", TA Block: " + tablockid + ", TA Trip: " + tatripid + ", Delayed?: " + dly +
				           ", Dynamic Action: " + dyn + ", Time Left Before Arrival: " + prdctdn + ", Zone?: " + zone);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTmstmp() {
		return tmstmp;
	}

	public void setTmstmp(String tmstmp) {
		this.tmstmp = tmstmp;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
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

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public int getDstp() {
		return dstp;
	}

	public void setDstp(int dstp) {
		this.dstp = dstp;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getRtdd() {
		return rtdd;
	}

	public void setRtdd(String rtdd) {
		this.rtdd = rtdd;
	}

	public String getRtdir() {
		return rtdir;
	}

	public void setRtdir(String rtdir) {
		this.rtdir = rtdir;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getPrdtm() {
		return prdtm;
	}

	public void setPrdtm(String prdtm) {
		this.prdtm = prdtm;
	}

	public String getTablockid() {
		return tablockid;
	}

	public void setTablockid(String tablockid) {
		this.tablockid = tablockid;
	}

	public String getTatripid() {
		return tatripid;
	}

	public void setTatripid(String tatripid) {
		this.tatripid = tatripid;
	}

	public boolean isDly() {
		return dly;
	}

	public void setDly(boolean dly) {
		this.dly = dly;
	}

	public int getDyn() {
		return dyn;
	}

	public void setDyn(int dyn) {
		this.dyn = dyn;
	}

	public String getPrdctdn() {
		return prdctdn;
	}

	public void setPrdctdn(String prdctdn) {
		this.prdctdn = prdctdn;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
}
