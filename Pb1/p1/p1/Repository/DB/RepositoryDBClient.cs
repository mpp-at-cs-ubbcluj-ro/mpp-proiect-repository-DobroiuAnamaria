using System.Collections.Generic;
using System.Data;
using p1.Model;
using p1.Utils;
using log4net;
namespace p1.Repository.DB;

public class RepositoryDBClient : RepositoryClient
{
    private static readonly ILog logger = LogManager.GetLogger("RepositoryBDClient");
    private IDictionary<string, string> properties;
    
    public RepositoryDBClient(IDictionary<string, string> properties, Client client) : base(client)
    {
        logger.Info("Creating RepositoryBDClient");
        this.properties = properties;
    }



    public override Client FindOne(int id)
    {
        logger.InfoFormat("Entering FindOne with value {0}", id);
        IDbConnection connection = DbUtils.GetConnection(properties);
        using (var command = connection.CreateCommand())
        {
            command.CommandText = "select * from Client where id=@id";
            var parameterId = command.CreateParameter();
            parameterId.ParameterName = "@id";
            parameterId.Value = id;
            command.Parameters.Add(parameterId);
            using (var dataReader = command.ExecuteReader())
            {
                if (dataReader.Read())
                {
                    int _id = dataReader.GetInt32(0);
                    string username = dataReader.GetString(1);
                    string password = dataReader.GetString(2);
                    string clientName = dataReader.GetString(3);
                    string address = dataReader.GetString(4);
                    var client = new Client(username,password,clientName,address);
                    client.Id = _id;
                    logger.InfoFormat("Exiting FindOne with value {0}", client);
                    return client;
                }
            }
        }
        logger.InfoFormat("Exiting FindOne with value {0}", null);
        return null;
    }
    
    public override IEnumerable<Client> FindAll()
    {
        logger.Info("Entering FindAll");
        IDbConnection connection = DbUtils.GetConnection(properties);
        IList<Client> clients = new List<Client>();
        using (var command = connection.CreateCommand())
        {
            command.CommandText = "select * from Client";
            using (var dataReader = command.ExecuteReader())
            {
                while (dataReader.Read())
                {
                    int _id = dataReader.GetInt32(0);
                    string username = dataReader.GetString(1);
                    string password = dataReader.GetString(2);
                    string clientName = dataReader.GetString(3);
                    string address = dataReader.GetString(4);
                    var client = new Client(username,password,clientName,address);
                    client.Id = _id;
                    clients.Add(client);
                }
            }
        }
        logger.Info("Exiting FindAll");
        return clients;
    }
    
    public override Client Save(Client entity)
    {
        logger.InfoFormat("Entering Save with value {0}", entity);
        IDbConnection connection = DbUtils.GetConnection(properties);
        using (var command = connection.CreateCommand())
        {
            command.CommandText = "insert into Client (Username, Password, ClientName, Address) values (@Username, @Password,  @ClientName, @Address)";
            
            var username  = command.CreateParameter();
            username.ParameterName = "@Username";
            username.Value = entity.Username;
            command.Parameters.Add(username);
            
            var password = command.CreateParameter();
            password.ParameterName = "@Password";
            password.Value = entity.Password;
            command.Parameters.Add(password);
            
            var nameClient  = command.CreateParameter();
            nameClient.ParameterName = "@ClientName";
            nameClient.Value = entity.NameClient;
            command.Parameters.Add(nameClient);
            
          
            var addressParameter = command.CreateParameter();
            addressParameter.ParameterName = "@Address";
            addressParameter.Value =  entity.Address;
            command.Parameters.Add(addressParameter);
            
         
            
            var result = command.ExecuteNonQuery();
            logger.InfoFormat("Exiting Save with value {0}", result);
        }
        return entity;
    }
    
    public override int Delete(int id)
    {
        logger.InfoFormat("Entering Delete with value {0}", id);
        IDbConnection connection = DbUtils.GetConnection(properties);
        using (var command = connection.CreateCommand())
        {
            command.CommandText = "delete from Client where id=@id";
            var idParameter = command.CreateParameter();
            idParameter.ParameterName = "@id";
            idParameter.Value = id;
            command.Parameters.Add(idParameter);
            var result = command.ExecuteNonQuery();
            logger.InfoFormat("Exiting Delete with value {0}", result);
        }
        return id;
    }
    
    public override Client Update(Client entity)
    {
        logger.InfoFormat("Entering Update with value {0}", entity);
        IDbConnection connection = DbUtils.GetConnection(properties);
        using (var command = connection.CreateCommand())
        {
            command.CommandText = "update Client set Username=@Username, Password=@Password, ClientName=@ClientName, Address=@Address where id=@id";
            var username  = command.CreateParameter();
            username.ParameterName = "@Username";
            username.Value = entity.Username;
            command.Parameters.Add(username);
            
            var password = command.CreateParameter();
            password.ParameterName = "@Password";
            password.Value = entity.Password;
            command.Parameters.Add(password);
            
            var nameClient  = command.CreateParameter();
            nameClient.ParameterName = "@ClientName";
            nameClient.Value = entity.NameClient;
            command.Parameters.Add(nameClient);
            
          
            var addressParameter = command.CreateParameter();
            addressParameter.ParameterName = "@Address";
            addressParameter.Value =  entity.Address;
            command.Parameters.Add(addressParameter);

            var result = command.ExecuteNonQuery();
            logger.InfoFormat("Exiting Update with value {0}", result);
        }
        return entity;
    }
} 
