package com.sunyoswego.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {
    public ComboBox myBox;
    public Button myButton;
    public TextArea aText;
    public ComboBox stopBox;
    public Button button2;
    public ComboBox dirBox;

    @FXML //Initialize the combo boxes items
        public void initialize() {
        ObservableList routes = FXCollections.observableArrayList("SUNY Oswego Blue Route", "SUNY Oswego Green Route");
            myBox.setItems(routes);
        ObservableList none = FXCollections.observableArrayList("Error hit 'ok'");
            stopBox.setItems(none);
        ObservableList dir = FXCollections.observableArrayList("Outbound" , "Inbound");
         dirBox.setItems(dir);
}


        //Pressing the first ok button
       public void pressButton(ActionEvent event){
            //call to isEqual method to check the contents of the combobox
            isEqual(myBox, dirBox);


        }
        //Pressing the second ok button
                    public void pressButton2(ActionEvent event){
                        aText.setText(myBox.getValue().toString() +"\n" + stopBox.getValue().toString());
        }
        //getting the stops for the appropriate route
        public void isEqual(ComboBox input, ComboBox direction){
            if(input.getValue().toString().equals("SUNY Oswego Blue Route") & direction.getValue().toString().equals("Outbound") ) {
                ObservableList stops = FXCollections.observableArrayList("blue1", "blue2" );
                stopBox.setItems(stops);
            }else if(input.getValue().toString().equals("SUNY Oswego Blue Route") & direction.getValue().toString().equals("Inbound")){
                ObservableList stops1 = FXCollections.observableArrayList("blue 3", "blue 4"  );
                stopBox.setItems(stops1);
            } else if(input.getValue().toString().equals("SUNY Oswego Green Route") & direction.getValue().toString().equals("Outbound") ) {
                ObservableList stops = FXCollections.observableArrayList("green1", "green2");
                stopBox.setItems(stops);
            }else if(input.getValue().toString().equals("SUNY Oswego Green Route") & direction.getValue().toString().equals("Inbound")){
                ObservableList stops1 = FXCollections.observableArrayList("green 3", "green 4"  );
                stopBox.setItems(stops1);
            }else{
                ObservableList none = FXCollections.observableArrayList("Error Try a different Route");
                stopBox.setItems(none);

            }

        }


    }



