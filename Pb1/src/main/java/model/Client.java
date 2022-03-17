package model;

import java.util.Objects;

public class Client extends Entity<Integer>{

    String firstNameClient;
    String firstNameTourist;
    String lastNameClient;
    String lastNameTourist;
    String addressClient;
    int numberOfPlace;

    public Client(String firstNameClient, String firstNameTourist, String lastNameClient, String lastNameTourist, String addressClient, int numberOfPlace)
    {
        this.firstNameClient = firstNameClient;
        this.firstNameTourist = firstNameTourist;
        this.lastNameClient = lastNameClient;
        this.lastNameTourist = lastNameTourist;
        this.addressClient = addressClient;
        this.numberOfPlace = numberOfPlace;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getFirstNameTourist() {
        return firstNameTourist;
    }

    public void setFirstNameTourist(String firstNameTourist) {
        this.firstNameTourist = firstNameTourist;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getLastNameTourist() {
        return lastNameTourist;
    }

    public void setLastNameTourist(String lastNameTourist) {
        this.lastNameTourist = lastNameTourist;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    @Override
    public String toString() {
        return "The Client's dates: " +
                "Fist name:" + firstNameClient  +
                "| Last name:" + lastNameClient + '\n'+"The Tourist dates:" +
                "First name" + firstNameTourist +
                " |Last name:" + lastNameTourist + '\n' +
                " |Address:" + addressClient + '\n' +
                " |Number of places:" + numberOfPlace ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return numberOfPlace == client.numberOfPlace && Objects.equals(firstNameClient, client.firstNameClient) && Objects.equals(firstNameTourist, client.firstNameTourist) && Objects.equals(lastNameClient, client.lastNameClient) && Objects.equals(lastNameTourist, client.lastNameTourist) && Objects.equals(addressClient, client.addressClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNameClient, firstNameTourist, lastNameClient, lastNameTourist, addressClient, numberOfPlace);
    }
}
