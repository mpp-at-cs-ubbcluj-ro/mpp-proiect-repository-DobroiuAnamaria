using System.Collections.Generic;
using System.Data;

namespace p1.Utils;

public class DbUtils
{
    

    private static IDbConnection? _connection;

    public static IDbConnection GetConnection(IDictionary<string, string> properties)
    {
        if (_connection == null || _connection.State == ConnectionState.Closed)
        {
            _connection = CreateNewConnection(properties);
            _connection.Open();
        }
        return _connection;
    }
    

    private static IDbConnection CreateNewConnection(IDictionary<string, string> properties)
    {
        return ConnectionFactory.Instance.CreateConnection(properties);
    }
}