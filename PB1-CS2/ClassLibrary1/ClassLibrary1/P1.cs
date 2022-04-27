using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
using ClassLibrary1.Model;
using ClassLibrary1.Repository.DB;
using log4net.Config;

namespace ClassLibrary1;

public class P1
{
    public static void Main(string[] args)
    {
        XmlConfigurator.Configure(new FileInfo(args[0]));
        IDictionary<string, string> properties = new SortedList<string, string>();
        properties.Add("ConnectionString", "FlightsCompany.db");
        RepositoryDBClient repositoryDbClient = new RepositoryDBClient(properties,null);
        foreach (var client in repositoryDbClient.FindAll())
        {
            Console.WriteLine(client);
        }
    }

    static string GetConnectionStringByName(string name)
    {
        ConnectionStringSettings settings = ConfigurationManager.ConnectionStrings[name];
        return settings.ConnectionString;
    }
}