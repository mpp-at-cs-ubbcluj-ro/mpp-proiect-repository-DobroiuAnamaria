 using System.Collections.Generic;
using ClassLibrary1.Model;

namespace ClassLibrary1.Repository
{
    public abstract class RepositoryClient : IRepository<int, Client>
    {
        public abstract Client FindOne(int id);
        public abstract IEnumerable<Client> FindAll();
        public abstract Client Save(Client entity);
        public abstract Client Delete(int id);
        public abstract Client Update(Client entity);
    }
}