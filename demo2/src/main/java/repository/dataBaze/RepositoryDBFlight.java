package repository.dataBaze;

import model.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.RepositoryFlight;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class RepositoryDBFlight extends RepositoryFlight {
    private final JDBCUtils databaseUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryDBFlight(Properties properties) {

        logger.info("Initialising RaceDBRepository with properties: {}", properties);
        databaseUtils = new JDBCUtils(properties);
    }


    @Override
    public Flight findOne(Integer integer) {
        logger.traceEntry();
        Connection connection = databaseUtils.getConnection();
        Flight flight = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Flight where id=?")) {
            preparedStatement.setInt(1, integer);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var flightDeparture = resultSet.getString("Departure");
                    var flightArrival = resultSet.getString("Arrival");
                    var flightDateDeparture = resultSet.getString("DateDeparture");
                    var flightTimeDeparture = resultSet.getString("TimeDeparture");
                    var flightAirport = resultSet.getString("Airport");
                    var flightNumberOfPlace = resultSet.getInt("NumberOfPlace");
                    flight = new Flight(flightDeparture,flightArrival,flightDateDeparture,flightTimeDeparture,flightAirport,flightNumberOfPlace);
                    flight.setId(id);
                }
                logger.traceExit("Found 1 instance");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return flight;
    }

    @Override
    public Iterable<Flight> findAll() {
        logger.traceEntry("Finding task");
        Connection connection = databaseUtils.getConnection();
        List<Flight> flights = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Flight")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var flightDeparture = resultSet.getString("Departure");
                    var flightArrival = resultSet.getString("Arrival");
                    var flightDateDeparture = resultSet.getString("DateDeparture");
                    var flightTimeDeparture = resultSet.getString("TimeDeparture");
                    var flightAirport = resultSet.getString("Airport");
                    var flightNumberOfPlace = resultSet.getInt("NumberOfPlace");
                    Flight flight = new Flight(flightDeparture,flightArrival,flightDateDeparture,flightTimeDeparture,flightAirport,flightNumberOfPlace);
                    flight.setId(id);
                    flights.add(flight);
                }
                logger.traceExit("Found {} instances", flights.size());
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return flights;
    }


    @Override
    public Flight save(Flight entity) {
        logger.traceEntry("Saving client {}", entity);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into Flight" + " (Departure, Arrival, DateDeparture, TimeDeparture, Airport, NumberOfPlace) values (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getDestiantion());
            preparedStatement.setString(2, entity.getArrival());
            preparedStatement.setString(3, entity.getDateDeparture());
            preparedStatement.setString(4, entity.getTimeDeparture());
            preparedStatement.setString(5, entity.getArrival());
            preparedStatement.setInt(6, entity.getNumberOfplace());
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }

    @Override
    public Integer delete(Integer integer) {
        logger.traceEntry("Deleting task {}", integer);
        Connection connection = databaseUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from Flight where id=?")) {
            preparedStatement.setInt(1, integer);
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Deleted {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return integer;
    }

    @Override
    public Flight update(Flight entity) {
        logger.traceEntry("Updating task {}", entity);
        Connection connection = databaseUtils.getConnection();


        try (PreparedStatement preparedStatement = connection.prepareStatement("update Flight set Departure=?, Arrival=?, DateDeparture=?, TimeDeparture=?, Airport=?, NumberOfPlace=? where id=?")) {
            preparedStatement.setString(1, entity.getDestiantion());
            preparedStatement.setString(2, entity.getArrival());
            preparedStatement.setString(3, entity.getDateDeparture());
            preparedStatement.setString(4, entity.getTimeDeparture());
            preparedStatement.setString(5, entity.getArrival());
            preparedStatement.setInt(6, entity.getNumberOfplace());
            preparedStatement.setInt(7 ,entity.getId());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }

}




