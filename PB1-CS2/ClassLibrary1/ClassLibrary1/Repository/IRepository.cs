using System.Collections.Generic;
using ClassLibrary1.Model;

namespace ClassLibrary1.Repository
{
    public interface IRepository <in TId, TE> where TE : Entity<TId>
    {

        TE FindOne(TId id);
        IEnumerable<TE> FindAll();
        TE Save(TE entity);
        TE Delete(TId id);
        TE Update(TE entity);

    }
}