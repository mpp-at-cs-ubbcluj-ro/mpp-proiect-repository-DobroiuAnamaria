using System;
using System.Collections.Generic;
using System.IO;

using log4net.Config;
using p1.Repository.DB;

namespace p1
{
    internal class Program
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
    }
}