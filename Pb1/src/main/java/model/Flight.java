package model;

import java.util.Objects;

public class Flight extends Entity<Integer>{

    String destiantion;
    String arrival;
    String dateDeparture;
    String timeDeparture;
    String airport;
    int numberOfplace;

    public Flight(String destiantion, String arrival, String dateDeparture, String timeDeparture, String airport, int numberOfplace) {
        this.destiantion = destiantion;
        this.arrival = arrival;
        this.dateDeparture = dateDeparture;
        this.timeDeparture = timeDeparture;
        this.airport = airport;
        this.numberOfplace = numberOfplace;
    }

    public String getDestiantion() {
        return destiantion;
    }

    public void setDestiantion(String destiantion) {
        this.destiantion = destiantion;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getNumberOfplace() {
        return numberOfplace;
    }

    public void setNumberOfplace(int numberOfplace) {
        this.numberOfplace = numberOfplace;
    }



    @Override
    public String toString() {
        return "Flight{" +
                "destiantion='" + destiantion + '\'' +
                ", arrival='" + arrival + '\'' +
                ", dateDeparture='" + dateDeparture + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", airport='" + airport + '\'' +
                ", numberOfplace=" + numberOfplace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return numberOfplace == flight.numberOfplace && Objects.equals(destiantion, flight.destiantion) && Objects.equals(arrival, flight.arrival) && Objects.equals(dateDeparture, flight.dateDeparture) && Objects.equals(timeDeparture, flight.timeDeparture) && Objects.equals(airport, flight.airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destiantion, arrival, dateDeparture, timeDeparture, airport, numberOfplace);
    }



}
