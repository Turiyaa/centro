package com.sunyoswego.controller;

import com.sunyoswego.dao.CentroDao;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Stop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {
	public ComboBox<String> myBox;
	public Button myButton;
	public TextArea aText;
	public ComboBox<String> stopBox;
	public Button button2;
	public ComboBox<String> dirBox;
	private CentroDao dao = new CentroDao();
	private String selectedRoute;
	private String selectedDir;
	private String selectedStop;
	@FXML
	private ObservableList<String> routeComboBoxData = FXCollections.observableArrayList();
	private ObservableList<String> dirBoxData = FXCollections.observableArrayList();
	private ObservableList<String> stopBoxData = FXCollections.observableArrayList();


	@FXML // Initialize the combo boxes items
	public void initialize() {
		if (routeComboBoxData.isEmpty()) {
			for (Route rt : dao.getAllRoutes()) {
				routeComboBoxData.add(rt.getRtnm());
			}
		}
		myBox.setItems(routeComboBoxData);
		stopBox.setDisable(true);
		dirBox.setDisable(true);
		myBox.setOnAction((event) -> {
			dirBoxData.clear(); 
			selectedRoute = myBox.getSelectionModel().getSelectedItem();
			stopBox.setDisable(true);
			if(selectedRoute != null) {
				for (String str : dao.getDirByRoute(selectedRoute)) {
					dirBoxData.add(str.toString());
				}
				ObservableList<String> dirs = FXCollections.observableArrayList(dirBoxData);
				dirBox.setItems(dirs);
				dirBox.setDisable(false);
			}
		});
		
		dirBox.setOnAction((event) -> {
			selectedDir = dirBox.getSelectionModel().getSelectedItem();
			if(selectedRoute != null && selectedDir != null) {
				stopBox.setDisable(false);
				stopBoxData.clear();
				for (Stop stp : dao.getStopByRoutAndDir(selectedRoute, selectedDir)) {
					stopBoxData.add(stp.getStpnm());
				}
				ObservableList<String> stops = FXCollections.observableArrayList(stopBoxData);
				stopBox.setItems(stops);
			}
		});
		
		stopBox.setOnAction((event) -> {
			selectedStop = stopBox.getSelectionModel().getSelectedItem();
			stopBoxData.clear();
			System.out.println(selectedStop);
		});
	}
}
