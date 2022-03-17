import model.Client;
import model.Flight;
import repository.RepositoryClient;
import repository.RepositoryFlight;
import repository.dataBaze.RepositoryDBClient;
import repository.dataBaze.RepositoryDBFlight;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class P1 {

    public static void main(String[] args) {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("D:/mpp-proiect-repository-DobroiuAnamaria/Pb1/src/main/db.config.properties"));
        } catch (IOException ignored) {}
        Client client = null;
        RepositoryClient clientRepository = new RepositoryDBClient(properties,client);
        clientRepository.save(new Client("Marin", "Rares","Costel", "Alex","Matei Basarab",2));
        System.out.println("Toti din DB:");
        for (var clients : clientRepository.findAll()) System.out.println(clients);
        System.out.println('\n');

        Properties propertiesFlight = new Properties();
        try {
            properties.load(new FileReader("D:/mpp-proiect-repository-DobroiuAnamaria/Pb1/src/main/db.config.properties"));
        } catch (IOException ignored) {}
        Flight flight = null;
        RepositoryFlight flightRepository = new RepositoryDBFlight(properties,flight);
        flightRepository.save(new Flight("Maldive", "France","12.09.2022", "11:50","Barceo",200));
        System.out.println("Toti din DB:");
        for (var flights : flightRepository.findAll()) System.out.println(flights);
    }

}
