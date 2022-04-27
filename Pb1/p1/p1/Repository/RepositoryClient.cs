 using System.Collections.Generic;
using p1.Model;

namespace p1.Repository
{
    public abstract class RepositoryClient : IRepository<int, Client>
    {
        private Client _client;
        protected RepositoryClient(Client client)
        {
            _client = client;
        }

        public abstract Client FindOne(int id);
        public abstract IEnumerable<Client> FindAll();
        public abstract Client Save(Client entity);
        public abstract int Delete(int id);
        public abstract Client Update(Client entity);
    }
}