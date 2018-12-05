package com.sunyoswego.centro;

import java.awt.Color;
import java.awt.Paint;

import com.sunyoswego.jdbc.MySqlConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main( String[] args )
    {
    	MySqlConnection.getConnection();
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/sunyoswego/centro/Centro.fxml"));
            primaryStage.setTitle("Centro");
            root.setStyle("-fx-background-color: #91bbff;");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
         
        } catch(Exception e) {
            e.printStackTrace();
        }		
	}
}
