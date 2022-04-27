package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.RepositoryClient;
import repository.RepositoryFlight;
import repository.RepositoryRezervation;
import repository.dataBaze.RepositoryDBClient;
import repository.dataBaze.RepositoryDBFlight;
import repository.dataBaze.RepositoryDBRezervation;
import service.FlightCompanyService;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Properties properties= new Properties();
        try {
            properties.load(new FileReader("C:/Users/user/Desktop/demo2/src/main/resources/db.config.properties"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config " + e);
        }

        RepositoryClient repositoryClient = new RepositoryDBClient(properties);
        RepositoryFlight repositoryFlight = new RepositoryDBFlight(properties);
        RepositoryRezervation repositoryRezervation = new RepositoryDBRezervation(properties);
        FlightCompanyService service = new FlightCompanyService(repositoryClient,repositoryFlight,repositoryRezervation);

        Parent root = (Parent)fxmlLoader.load();
        HelloController controller = fxmlLoader.<HelloController>getController();
        controller.setService(service);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}