package com.sunyoswego.centro;

import com.sunyoswego.jdbc.MySqlConnection;
import com.sunyoswego.entity.BusSchedule;
import com.sunyoswego.entity.Prediction;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Schedule;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.entity.Vehicle;
import com.sunyoswego.dao.CentroDao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class App extends Application
{
    public static void main( String[] args )
    {
    	CentroDao dao = new CentroDao();
		ArrayList<Vehicle> v = dao.getVehicles();
		ArrayList<Stop> s = dao.getStops();
		ArrayList<Route> r = dao.getRoute();
		ArrayList<Prediction> p = dao.getPrediction();
		ArrayList<BusSchedule> b = dao.getBusSchedule();
    	MySqlConnection.Connection();
    	launch(args);
    	v.get(0).displayInfo();
    	s.get(0).displayInfo();
    	r.get(0).displayInfo();
    	p.get(0).displayInfo();
    	b.get(0).displayInfo();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/com/sunyoswego/centro/Centro.fxml"));
 
            primaryStage.setTitle("Centro");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }		
	}
}
