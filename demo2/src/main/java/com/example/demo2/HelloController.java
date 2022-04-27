package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.FlightCompanyService;

import java.io.IOException;

public class HelloController {

    public TextField Username;
    public PasswordField Password;
    public Label Error;
    private  FlightCompanyService service;

    public void setService(FlightCompanyService service){
        this.service= service;
    }
    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {

        if (service.logInClient(Username.getText(),Password.getText())){
            goToMainWindow();
        }
        else {
            Error.setText("Credentiale invalide!");
        }

    }
    private void goToMainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("mainScreen.fxml"));

            Parent root = (Parent)fxmlLoader.load();
            MainScreen controller = fxmlLoader.<MainScreen>getController();
            controller.setService(service);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
