package model;

public class Rezervation extends Entity<Integer>{

    private int id_flight;
    private int id_client;
    private int numberOfPlace;
    private String touristName;

    public Rezervation(int id_flight, int id_client,  String touristName,int numberOfPlace) {
        this.id_flight = id_flight;
        this.id_client = id_client;
        this.numberOfPlace = numberOfPlace;
        this.touristName = touristName;
    }

    public int getId_flight() {
        return id_flight;
    }

    public void setId_flight(int id_flight) {
        this.id_flight = id_flight;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    @Override
    public String toString() {
        return "Rezervation{" +
                "id_flight=" + id_flight +
                ", id_client=" + id_client +
                ", numberOfPlace=" + numberOfPlace +
                ", touristName='" + touristName + '\'' +
                '}';
    }
}
