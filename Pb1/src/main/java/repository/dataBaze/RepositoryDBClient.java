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


public class RepositoryDBClient implements RepositoryClient {

    private final JDBCUtils databaseUtils;
    private static final Logger logger = LogManager.getLogger();

    public RepositoryDBClient(Properties properties) {

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
                    var clientUsername = resultSet.getString("Username");
                    var clientPassword = resultSet.getString("Password");
                    var clientName = resultSet.getString("ClientName");
                    var clientAddress = resultSet.getString("Address");

                    client = new Client(clientUsername,clientPassword,clientName,clientAddress);
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
                    var clientUsername = resultSet.getString("Username");
                    var clientPassword = resultSet.getString("Password");
                    var clientName = resultSet.getString("ClientName");
                    var clientAddress = resultSet.getString("Address");

                    Client client = new Client(clientUsername,clientPassword,clientName,clientAddress);
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
    public Client save(Client entity) {
        logger.traceEntry("Saving client {}", entity);
        Connection connection = databaseUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into Client (Userneme, Password,NameClient, Address) values (?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getNameClient());
            preparedStatement.setString(4, entity.getAddressClient());

            int result = preparedStatement.executeUpdate();
            logger.traceExit("Saved {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }

    @Override
    public Client delete(Integer integer) {
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
        return null;
    }

    @Override
    public Client update(Client entity) {
        logger.traceEntry("Updating task {}", entity);
        Connection connection = databaseUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("update  set UserName =?, Password =?,NameClient =?, Address =? where id=?")) {
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getNameClient());
            preparedStatement.setString(4, entity.getAddressClient());

            int result = preparedStatement.executeUpdate();
            logger.traceExit("Updated {} instances", result);
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return entity;
    }

    private Client buildRefereeFromResultSet(ResultSet resultSet) throws SQLException {
        Client client  = null;
        var id = resultSet.getInt("id");
        var clientUsername = resultSet.getString("Username");
        var clientPassword = resultSet.getString("Password");
        var clientName = resultSet.getString("ClientName");
        var clientAddress = resultSet.getString("Address");

        client = new Client(clientUsername,clientPassword,clientName,clientAddress);
        client.setId(id);
        return client;
    }

    public Client findByUsername(String username) {
        logger.traceEntry("Finding task {}", username);
        Connection connection = databaseUtils.getConnection();
        Client referee = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Client where Username=?")) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    referee = buildRefereeFromResultSet(resultSet);
                }
                logger.traceExit("Found 1 instance");
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
        return referee;
    }
}




