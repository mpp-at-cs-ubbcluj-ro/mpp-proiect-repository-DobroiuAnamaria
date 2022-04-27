package com.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Flight;
import service.FlightCompanyService;

import java.util.ArrayList;
import java.util.List;

public class MainScreen {


    public TextField clientNameField;
    public ListView<String> showFlights;
    public TextField nameFlight;
    public TextField numberOfTicketsField;
    public Label reserveMatchStatusLabel;
    public Button signOutButton;
    private Flight selectedFlight;
    private FlightCompanyService service;

    public void setService(FlightCompanyService service){
        this.service= service;
    }

    private void loadAllFlight() {
        ObservableList<String> flights = FXCollections.observableArrayList();
        List<Flight> flightList = new ArrayList<>();
        for (Flight flight : service.getFlight()) {
            flights.add(flight.getId() + ", " + flight.getAirport() + ", " + flight.getDestiantion() +";"+flight.getArrival()+";"+flight.getTimeDeparture()+";"+flight.getDateDeparture()+";"+
                    (flight.getNumberOfplace() > 0 ?  flight.getNumberOfplace() + " available tickets" : "SOLD OUT"));
            flightList.add(flight);
        }
        showFlights.setItems(flights);
    }

    public void showFlights(MouseEvent mouseEvent) {
        String flight = showFlights.getSelectionModel().getSelectedItem();
        String[] rows = flight.split(",");

        selectedFlight = service.getByID(Integer.parseInt(rows[0]));
        System.out.println(selectedFlight);

        nameFlight.setText(selectedFlight.getAirport());



    }

    public void makeReservationPress(ActionEvent actionEvent) {
        if(selectedFlight == null) {
            reserveMatchStatusLabel.setText("Please select a flight!");
            return;
        }

        String clientName = clientNameField.getText();
        if (clientName.length() == 0) {
            reserveMatchStatusLabel.setText("Client must have a name!");
            return;
        }

        int numberOfTickets = 0;
        try {
            numberOfTickets = Integer.parseInt(numberOfTicketsField.getText());
        } catch (NumberFormatException e) {
            reserveMatchStatusLabel.setText("No. of tickets must be a number!");
            return;
        }

        if (selectedFlight.getNumberOfplace() < numberOfTickets) {
            reserveMatchStatusLabel.setText("Not enough tickets available!");
            return;
        }

        service.makeReservation(selectedFlight,  clientName, numberOfTickets);
        reserveMatchStatusLabel.setText("Successful reservation!");
        clientNameField.setText("");
        numberOfTicketsField.setText("");
        loadAllFlight();

    }

    public void allFlight(ActionEvent actionEvent) {
        loadAllFlight();
    }

    public void availableFlight(ActionEvent actionEvent) {
        ObservableList<String> flights = FXCollections.observableArrayList();
        List<Flight> flightList = new ArrayList<>();
        for (Flight flight : service.getFlight()) {
            if(flight.getNumberOfplace() > 0)
            flights.add(flight.getId() + ", " + flight.getAirport() + ", " + flight.getDestiantion()+ ";"+ flight.getArrival() +";"+ flight.getTimeDeparture() +";"+ flight.getDateDeparture() +";" +
                    (flight.getNumberOfplace() > 0 ? flight.getNumberOfplace() + " available tickets" : "SOLD OUT"));
        }
        showFlights.setItems(flights);

    }

    public void signOutPress(ActionEvent actionEvent) {
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.close();
    }
}
