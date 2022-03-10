using System.Collections.Generic;
using ClassLibrary1.Model;

namespace ClassLibrary1.Repository
{
    public abstract class RepositoryFlight: IRepository<int, Flight>
    {
        public abstract Flight FindOne(int id);
        public abstract IEnumerable<Flight> FindAll();
        public abstract Flight Save(Flight entity);
        public abstract Flight Delete(int id);
        public abstract Flight Update(Flight entity);
        
    }
}