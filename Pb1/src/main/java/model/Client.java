package model;

import java.util.Objects;

public class Client extends Entity<Integer> {
    private String username;
    private String password;
    private String NameClient;
    private String addressClient;


    @Override
    public String toString() {
        return "Client{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", NameClient='" + NameClient + '\'' +
                ", addressClient='" + addressClient + '\'' +

                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameClient() {
        return NameClient;
    }

    public void setNameClient(String nameClient) {
        NameClient = nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }



    public Client(String username, String password, String nameClient, String addressClient) {
        this.username = username;
        this.password = password;
        NameClient = nameClient;
        this.addressClient = addressClient;



    }
}