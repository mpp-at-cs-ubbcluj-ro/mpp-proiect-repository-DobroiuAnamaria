package repository.dataBaze;

import model.Rezervation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import repository.RepositoryRezervation;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepositoryDBRezervation implements RepositoryRezervation {

    private final JDBCUtils databaseUtils;

    // Private Class Properties

    private static final Logger logger = (Logger) LogManager.getLogger();

    public RepositoryDBRezervation(Properties properties, Rezervation rezervation) {
        logger.info("Initialising RepositoryDBReservation with properties: {}", properties);
        databaseUtils = new JDBCUtils(properties);
    }

    @Override
    public Rezervation findOne(Integer integer) {
        logger.traceEntry("Finding task {}", integer);
        Connection connection = databaseUtils.getConnection();
        Rezervation rezervation = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Rezervation where id=?")) {
            preparedStatement.setInt(1, integer);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var flight = resultSet.getInt("IdFlight");
                    var client = resultSet.getInt("IdClient");
                    var tourist = resultSet.getString("Tourist");
                    var numberOfplace = resultSet.getInt("NumberOfPlace");

                    rezervation = new Rezervation(flight,client,numberOfplace, tourist);
                    rezervation.setId(id);
                }
                logger.traceExit("Found 1 instance");
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return rezervation;
    }

    @Override
    public Iterable<Rezervation> findAll() {
        logger.traceEntry("Finding task");
        Connection connection = databaseUtils.getConnection();
        List<Rezervation> reservationList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Rezervation")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var flight = resultSet.getInt("IdFlight");
                    var client = resultSet.getInt("IdClient");
                    var tourist = resultSet.getString("Tourist");
                    var numberOfplace = resultSet.getInt("NumberOfPlace");

                    Rezervation rezervation = new Rezervation(flight,client,numberOfplace, tourist);
                    rezervation.setId(id);
                    reservationList.add(rezervation);
                }
                logger.traceExit("Found {} instances", reservationList.size());
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return reservationList;
    }


    @Override
    public Rezervation save(Rezervation entity) {
        logger.traceEntry("Saving task {}", entity);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into Rezervation (IdFlight, IdCLient,NumberOfPlace, Tourist) values (?,?,?,?)")) {
            preparedStatement.setInt(1, entity.getId_flight());
            preparedStatement.setInt(2, entity.getId_client());
            preparedStatement.setInt(3, entity.getNumberOfPlace());
            preparedStatement.setString(4, entity.getTouristName());
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }



    @Override
    public Rezervation delete(Integer integer) {
        logger.traceEntry("Deleting task {}", integer);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from Rezervation where id=?")) {
            preparedStatement.setInt(1, integer);
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Deleted {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return null;
    }

    @Override
    public Rezervation update(Rezervation entity) {
        logger.traceEntry("Updating task {}", entity);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("update Rezervation set IdFlight=?, IdClient=?, NumberOfPlace=?, Tourist =? where id=?")) {
            preparedStatement.setInt(1, entity.getId_flight());
            preparedStatement.setInt(2, entity.getId_client());
            preparedStatement.setInt(3, entity.getNumberOfPlace());
            preparedStatement.setString(4, entity.getTouristName());
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Updated {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }
}
