package repository.dataBaze;
import model.Client;
import model.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.JDBCUtils;

import repository.RepositoryClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class RepositoryDBClient extends RepositoryClient {
    private final JDBCUtils databaseUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryDBClient(Properties properties, Client client) {
        super(client);
        logger.info("Initialising RaceDBRepository with properties: {}", properties);
        databaseUtils = new JDBCUtils(properties);
    }


    @Override
    public Client findOne(Integer integer) {
        logger.traceEntry();
        Connection connection = databaseUtils.getConnection();
        Client client = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from " + " where id=?")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var clientFirstName = resultSet.getString("FirstName");
                    var clientLastName = resultSet.getString("LastName");
                    var clientFistNameT = resultSet.getString("FistNameTourist");
                    var clientLastNameT = resultSet.getString("LastNameTourist");
                    var clientAddress = resultSet.getString("Address");
                    var clientNumberOfPlace = resultSet.getInt("NumberOfPlace");
                    client = new Client(clientFirstName,clientLastName,clientFistNameT,clientLastNameT,clientAddress,clientNumberOfPlace);
                    client.setId(id);
                }
                logger.traceExit("Found 1 instance");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return client;
    }

    @Override
    public Iterable<Client> findAll() {
        logger.traceEntry("Finding task");
        Connection connection = databaseUtils.getConnection();
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Client")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    var id = resultSet.getInt("id");
                    var clientFirstName = resultSet.getString("FirstNameClient");
                    var clientLastName = resultSet.getString("LastNameClient");
                    var clientFistNameT = resultSet.getString("FirstNameTourist");
                    var clientLastNameT = resultSet.getString("LastNameTourist");
                    var clientAddress = resultSet.getString("Address");
                    var clientNumberOfPlace = resultSet.getInt("NumberOfPlace");
                    Client client = new Client(clientFirstName,clientLastName,clientFistNameT,clientLastNameT,clientAddress,clientNumberOfPlace);
                    client.setId(id);
                    clients.add(client);
                }
                logger.traceExit("Found {} instances", clients.size());
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return clients;
    }

    @Override
    public Entity save(Object o) {
        return null;
    }

    @Override
    public Client save(Client entity) {
        logger.traceEntry("Saving client {}", entity);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into Client (FirstNameClient, LastNameClient, FirstNameTourist, LastNameTourist, Address, NumberOfPlace) values (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getFirstNameClient());
            preparedStatement.setString(2, entity.getLastNameClient());
            preparedStatement.setString(3, entity.getFirstNameTourist());
            preparedStatement.setString(4, entity.getLastNameTourist());
            preparedStatement.setString(5, entity.getAddressClient());
            preparedStatement.setInt(6, entity.getNumberOfPlace());
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

        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from Client where id=?")) {
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
    public Client update(Client entity) {
        logger.traceEntry("Updating task {}", entity);
        Connection connection = databaseUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("update  set FirstNameClient =?, LastNameClient =?, FirstNameTourist =?, LastNameTourist =?, Address =?, NumberOfPlace =? where id=?")) {
            preparedStatement.setString(1, entity.getFirstNameClient());
            preparedStatement.setString(2, entity.getLastNameClient());
            preparedStatement.setString(3, entity.getFirstNameTourist());
            preparedStatement.setString(4, entity.getLastNameTourist());
            preparedStatement.setString(5, entity.getAddressClient());
            preparedStatement.setInt(6, entity.getNumberOfPlace());
            int result = preparedStatement.executeUpdate();
            logger.traceExit("Updated {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }

}




