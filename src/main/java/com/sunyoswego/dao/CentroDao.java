package com.sunyoswego.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sunyoswego.entity.BusSchedule;
import com.sunyoswego.entity.Prediction;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;
import com.sunyoswego.jdbc.MySqlConnection;

public class CentroDao implements CentroDataAccess {
	private PreparedStatement stmnt;
	private Stop stp;

	public ArrayList<Vehicle> getVehicles() {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		try {
			Connection con = MySqlConnection.getConnection();
			String vehiclesQuery = "select * from vehicles";
			stmnt = con.prepareStatement(vehiclesQuery);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				list.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11),
						rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15)));
			}
			stmnt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public ArrayList<Prediction> getPrediction() {
		ArrayList<Prediction> list = new ArrayList<Prediction>();
		Prediction prediction = new Prediction();
		try {
			Connection con = MySqlConnection.getConnection();
			String predictionsQuery = "select * from predictions";
			stmnt = con.prepareStatement(predictionsQuery);
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				prediction.setId(rs.getInt(1));
				prediction.setTmstmp(rs.getString(2));
				prediction.setTyp(rs.getString(3));
				prediction.setStpnm(rs.getString(4));
				prediction.setStpid(rs.getString(5));
				prediction.setVid(rs.getString(6));
				prediction.setDstp(rs.getInt(7));
				prediction.setRt(rs.getString(8));
				prediction.setRtdd(rs.getString(9));
				prediction.setRtdir(rs.getString(10));
				prediction.setDes(rs.getString(11));
				prediction.setPrdtm(rs.getString(12));
				prediction.setTablockid(rs.getString(13));
				prediction.setTatripid(rs.getString(14));
				prediction.setDly(rs.getBoolean(15));
				prediction.setDyn(rs.getInt(16));
				prediction.setPrdctdn(rs.getString(17));
				prediction.setZone(rs.getString(18));
				list.add(prediction);
				prediction = new Prediction();
			}
			stmnt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public ArrayList<BusSchedule> getBusSchedule() {
		ArrayList<BusSchedule> list = new ArrayList<BusSchedule>();
		BusSchedule schedule = new BusSchedule();
		try {
			Connection con = MySqlConnection.getConnection();
			String busSchedulesQuery = "select * from busSchedule";
			stmnt = con.prepareStatement(busSchedulesQuery);
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				schedule.setId(rs.getInt(1));
				schedule.setRoute(rs.getInt(2));
				schedule.setStpid(rs.getString(3));
				schedule.setScheduledTime(rs.getString(4));
				list.add(schedule);
				schedule = new BusSchedule();
			}
			stmnt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public ArrayList<Stop> getAllStops() {
		ArrayList<Stop> stopList = new ArrayList<Stop>();
		ResultSet rs = null;
		Connection con = null;
		String allStop = "select * from stops";
		try {
			// con = MySqlConnection.getConnection();
			con = MySqlConnection.getConnection();
			stmnt = con.prepareStatement(allStop);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				stp = new Stop();
				stp.setId(rs.getInt(1));
				stp.setRoute(rs.getString(2));
				stp.setDir(rs.getString(3));
				stp.setStpid(rs.getString(4));
				stp.setStpnm(rs.getString(5));
				stp.setLat(rs.getDouble(6));
				stp.setLon(rs.getDouble(7));
				stopList.add(stp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmnt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(stopList.toString());
		return stopList;
	}

	public ArrayList<Route> getAllRoutes() {
		ArrayList<Route> rtList = new ArrayList<Route>();
		Route rt = null;
		Connection con = null;
		ResultSet rs = null;
		String rtQuery = "select * from routes";
		try {
			con = MySqlConnection.getConnection();
			stmnt = con.prepareStatement(rtQuery);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				rt = new Route();
				rt.setId(rs.getInt(1));
				rt.setRt(rs.getString(2));
				rt.setRtnm(rs.getString(3));
				rt.setRtclr(rs.getString(4));
				rt.setRtdd(rs.getString(5));
				rtList.add(rt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmnt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rtList;
	}

	@Override
	public ArrayList<String> getDirByRoute(String rtnm) {
		ArrayList<String> dirList = new ArrayList<String>();
		Connection con = null;
		ResultSet rs = null;
		String rtQuery = "select distinct dir from stops inner join routes on stops.rtId = routes.id where routes.rtnm = ?";
		try {
			con = MySqlConnection.getConnection();
			// con = MySqlConnection.getConnection();
			stmnt = con.prepareStatement(rtQuery);
			stmnt.setString(1, rtnm);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				dirList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmnt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dirList;
	}

	@Override
	public ArrayList<Stop> getStopByRoutAndDir(String rtnm, String dir) {
		ArrayList<Stop> stpList = new ArrayList<Stop>();
		ResultSet rs = null;
		Connection con = null;
		String rtQuery = "select * from stops inner join routes on stops.rtId = routes.id where routes.rtnm =? and dir=?";
		try {
			con = MySqlConnection.getConnection();
			// con = MySqlConnection.getConnection();
			stmnt = con.prepareStatement(rtQuery);
			stmnt.setString(1, rtnm);
			stmnt.setString(2, dir);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				stp = new Stop();
				stp.setId(rs.getInt(1));
				stp.setRoute(rs.getString(2));
				stp.setDir(rs.getString(3));
				stp.setStpid(rs.getString(4));
				stp.setStpnm(rs.getString(5));
				stp.setLat(rs.getDouble(6));
				stp.setLon(rs.getDouble(7));
				stpList.add(stp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmnt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return stpList;

	}

	@Override
	public Multimap<String, Vehicle> getVehicleHistory(String rt, String scheduledTime) {
		Multimap<String, Vehicle> multiMap = ArrayListMultimap.create();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");
		LocalTime time = formatter.parseLocalTime(scheduledTime);
		LocalTime lowerTime = time.minusMinutes(5);
		LocalTime upperTime = time.plusMinutes(5);
		System.out.println(lowerTime);
		System.out.println(upperTime);
		try {
			Connection con = MySqlConnection.getConnection();
			String vehicleHistory = "select * from vehicles\r\n" + "where rt = ? \r\n"
					+ "			and (select substring_index(tmstmp, \" \", -1) between ? and ?);";
			stmnt = con.prepareStatement(vehicleHistory);
			stmnt.setString(1, rt);
			stmnt.setString(2, lowerTime.toString());
			stmnt.setString(3, upperTime.toString());
			System.out.println(vehicleHistory);
			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				multiMap.put(rs.getString(3).substring(0, 8),
						new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5),
								rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10),
								rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15)));

			}
 
			stmnt.close();
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return multiMap;
	}

}