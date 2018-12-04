package com.sunyoswego.controller;

import java.util.Set;

import org.joda.time.LocalTime;

import com.google.common.collect.Multimap;
import com.sunyoswego.dao.CentroDao;
import com.sunyoswego.entity.Route;
import com.sunyoswego.entity.Stop;
import com.sunyoswego.service.CentroService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Controller {
	public ComboBox<String> myBox;
	public Button myButton;
	public ComboBox<String> stopBox;
	public Button button2;
	public ComboBox<String> dirBox;
	public ComboBox<String> timeBox;
	public BarChart<?, ?> myBarChart;
	private CentroDao dao = new CentroDao();
	private CentroService service = new CentroService();
	private String selectedRoute;
	private String selectedDir;
	private String selectedStop;
	Multimap<LocalTime, Integer> graphData;
	@FXML
	private ObservableList<String> routeComboBoxData = FXCollections.observableArrayList();
	private ObservableList<String> dirBoxData = FXCollections.observableArrayList();
	private ObservableList<String> stopBoxData = FXCollections.observableArrayList();
	private ObservableList<String> timeBoxData = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		if (routeComboBoxData.isEmpty()) {
			for (Route rt : dao.getAllRoutes()) {
				routeComboBoxData.add(rt.getRtnm());
				System.out.println(rt.getRtnm());
			}
		}
		myBox.setItems(routeComboBoxData);
		stopBox.setDisable(true);
		dirBox.setDisable(true);
		timeBox.setDisable(true);
		myBox.setOnAction((event) -> {
			dirBoxData.clear();
			selectedRoute = myBox.getSelectionModel().getSelectedItem();
			stopBox.setDisable(true);
			if (selectedRoute != null) {
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
			if (selectedRoute != null && selectedDir != null) {
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
			if (selectedRoute != null && selectedDir != null && selectedStop != null) {
				timeBox.setDisable(false);
				timeBoxData.clear();
				for (String time : dao.getTimesFromRouteIDandStopIDandDir(selectedRoute, selectedStop, selectedDir)) {
					timeBoxData.add(time);
				}
				ObservableList<String> times = FXCollections.observableArrayList(timeBoxData);
				timeBox.setItems(times);
			}
			stopBoxData.clear();
			// pass ston lat, lon, scheduledtime(HH:mm) **Do not Include second* and route
			graphData = service.filterBusHistory("", "", "","");
			setBarGraph(graphData);

		});
	}

	public void setBarGraph(Multimap<LocalTime, Integer> barGraphData) {
		XYChart.Series series = new XYChart.Series();
		series.setName("Arrivals");
		myBarChart.getData().clear();
		Set<LocalTime> keys = barGraphData.keySet();
		for(LocalTime key : keys) {
			for(int freq: barGraphData.get(key)) {
				series.getData().add(new XYChart.Data<>(key.toString().substring(0, 5), freq));				
			}
		}
		myBarChart.getData().add(series);
	}

}
