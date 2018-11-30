package com.sunyoswego.controller;

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
    public BarChart myBarChart;
	private CentroDao dao = new CentroDao();
	private CentroService service = new CentroService();
	private String selectedRoute;
	private String selectedDir;
	private String selectedStop;
	private BarChart<Number, Number> vehicleGraph;
	@FXML
	private ObservableList<String> routeComboBoxData = FXCollections.observableArrayList();
	private ObservableList<String> dirBoxData = FXCollections.observableArrayList();
	private ObservableList<String> stopBoxData = FXCollections.observableArrayList();

	@FXML
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
			stopBoxData.clear();
			service.filterBusHistory("", "");
			System.out.println(selectedStop);
			setBarGraph();

		});
	}

	public void setBarGraph() {
		XYChart.Series series = new XYChart.Series();
			myBarChart.getData().clear();
			series.setName("Arrivals");
			series.getData().add(new XYChart.Data<>("8:45", 26));
			series.getData().add(new XYChart.Data<>("8:50", 20));
			series.getData().add(new XYChart.Data<>("9:00", 13));
			series.getData().add(new XYChart.Data<>("9:05", 15));
			series.getData().add(new XYChart.Data<>("9:10", 2));
			myBarChart.getData().add(series);
		
	}

}
