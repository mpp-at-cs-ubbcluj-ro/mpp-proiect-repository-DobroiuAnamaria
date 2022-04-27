import model.Client;
import model.Flight;
import model.Rezervation;
import repository.RepositoryClient;
import repository.RepositoryFlight;
import repository.RepositoryRezervation;
import repository.dataBaze.RepositoryDBClient;
import repository.dataBaze.RepositoryDBFlight;
import repository.dataBaze.RepositoryDBRezervation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class P1 {

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("D:/mpp-proiect-repository-DobroiuAnamaria/Pb1/src/main/db.config.operties"));
        } catch (IOException ignored) {}
        Client client = null;
        RepositoryClient clientRepository = new RepositoryDBClient(properties);
        clientRepository.save(new Client("djjdd","jsdjjdj","Marin", "Rares"));
        System.out.println("Toti din DB:");
        for (var clients : clientRepository.findAll()) System.out.println(clients);
        System.out.println('\n');

        try {
            properties.load(new FileReader("D:/mpp-proiect-repository-DobroiuAnamaria/Pb1/src/main/db.config.properties"));
        } catch (IOException ignored) {}
        Flight flight = null;
        RepositoryFlight flightRepository = new RepositoryDBFlight(properties,flight);
        flightRepository.save(new Flight("Maldive", "France","12.09.2022", "11:50","Barceo",200));
        System.out.println("Toti din DB:");
        for (var flights : flightRepository.findAll()) System.out.println(flights);
        System.out.println('\n');


        try {
            properties.load(new FileReader("D:/mpp-proiect-repository-DobroiuAnamaria/Pb1/src/main/db.config.properties"));
        } catch (IOException ignored) {}
        Rezervation rezervation = null;
        RepositoryRezervation repositoryRezervation = new RepositoryDBRezervation(properties,rezervation);
        repositoryRezervation.save(new Rezervation(1, 1,5, "djdfj"));
        System.out.println("Toti din DB:");
        for (var re : repositoryRezervation.findAll()) System.out.println(re);
        System.out.println('\n');

    }



}
