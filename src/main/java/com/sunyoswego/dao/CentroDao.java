package com.sunyoswego.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;
import com.sunyoswego.entity.BusSchedule;
import com.sunyoswego.entity.Prediction;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Schedule;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;

import java.util.ArrayList;

public class CentroDao implements CentroDataAccess {

        public ArrayList<Vehicle> getVehicles() {
                ArrayList<Vehicle> list = new ArrayList<Vehicle>();
                Vehicle vehicle = new Vehicle();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://server:3306/dbname", "user", "pass");
                        Statement stmt = (Statement) con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from vehicles");
                        while (rs.next()) {
                                list.add(new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
                                                          rs.getDouble(5), rs.getString(6), rs.getInt(7), rs.getString(8),
                                                          rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12),
                                                          rs.getString(13), rs.getString(14), rs.getString(15)));
                        }
                        con.close();
                } catch (Exception e) {
                        System.out.println(e);
                }
                return list;
        }

        public ArrayList<Stop> getStops() {
                ArrayList<Stop> list = new ArrayList<Stop>();
                Stop stop = new Stop();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://server:3306/dbname", "user", "pass");
                        Statement stmt = (Statement) con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from stops");
                        while (rs.next()) {
                                stop.setId(rs.getInt(1));
                                stop.setRoute(rs.getString(2));
                                stop.setDir(rs.getString(3));
                                stop.setStpid(rs.getInt(4));
                                stop.setStpnm(rs.getString(5));
                                stop.setLat(rs.getDouble(6));
                                stop.setLon(rs.getDouble(7));
                                list.add(stop);
                                stop = new Stop();
                        }
                        con.close();
                } catch (Exception e) {
                        System.out.println(e);
                }
                return list;
        }

        public ArrayList<Route> getRoute() {
                ArrayList<Route> list = new ArrayList<Route>();
                Route route = new Route();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://server:3306/dbname", "user", "pass");
                        Statement stmt = (Statement) con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from routes");
                        while (rs.next()) {
                                route.setId(rs.getInt(1));
                                route.setRt(rs.getString(2));
                                route.setRtnm(rs.getString(3));
                                route.setRtclr(rs.getString(4));
                                route.setRtdd(rs.getString(5));
                                list.add(route);
                                route = new Route();
                        }
                        con.close();
                } catch (Exception e) {
                        System.out.println(e);
                }
                return list;
        }

        public ArrayList<Prediction> getPrediction() {
                ArrayList<Prediction> list = new ArrayList<Prediction>();
                Prediction prediction = new Prediction();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://server:3306/dbname", "user", "pass");
                        Statement stmt = (Statement) con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from predictions");
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
                        con.close();
                } catch (Exception e) {
                        System.out.println(e);
                }
                return list;
        }

        public ArrayList<BusSchedule> getBusSchedule() {
                ArrayList<BusSchedule> list = new ArrayList<BusSchedule>();
                BusSchedule schedule = new BusSchedule();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://server:3306/dbname", "user", "pass");
                        Statement stmt = (Statement) con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from busSchedule");
                        while (rs.next()) {
                                schedule.setId(rs.getInt(1));
                                schedule.setRoute(rs.getInt(2));
                                schedule.setStpid(rs.getString(3));
                                schedule.setScheduledTime(rs.getString(4));
                                list.add(schedule);
                                schedule = new BusSchedule();
                        }
                        con.close();
                } catch (Exception e) {
                        System.out.println(e);
                }
                return list;
        }
}