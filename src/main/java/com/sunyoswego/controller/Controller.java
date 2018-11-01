package com.sunyoswego.controller;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	@FXML
	private Button myButton;

	@FXML
	private TextField myTextField;

	public void showDateTime(ActionEvent event) {
		System.out.println("Button Clicked!");

		Date now = new Date();

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");

		String dateTimeString = df.format(now);

		myTextField.setText(dateTimeString);

	}

	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}