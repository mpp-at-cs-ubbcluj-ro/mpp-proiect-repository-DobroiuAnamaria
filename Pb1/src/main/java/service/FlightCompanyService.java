package service;

import model.Client;
import repository.RepositoryClient;
import repository.RepositoryFlight;
import repository.RepositoryRezervation;

import java.util.ArrayList;
import java.util.List;

public class FlightCompanyService {

    private final RepositoryClient repositoryClient;
    private final RepositoryFlight repositoryFlight;
    private final RepositoryRezervation repositoryRezervation;
    private Client loggedInClient = null;


    public FlightCompanyService(RepositoryClient repositoryClient, RepositoryFlight repositoryFlight, RepositoryRezervation repositoryRezervation) {
        this.repositoryClient = repositoryClient;
        this.repositoryFlight = repositoryFlight;
        this.repositoryRezervation = repositoryRezervation;

    }

    public boolean logInClient(String email, String password) {
        Client client = this.repositoryClient.findByUsername(email);
        if (client == null) return false;
        var isLoggedIn = client.getUsername().equals(email) && client.getPassword().equals(password);
        if (isLoggedIn) {
            loggedInClient =client;
        }
        return isLoggedIn;
    }

    public void logOutClient() {
        loggedInClient = null;

    }

    public Client getCurrentClient() {
        return loggedInClient;
    }


    public List<Client> getClient() {
        List<Client> clients = new ArrayList<>();
        this.repositoryClient.findAll().forEach(clients::add);
        return clients;
    }



}
