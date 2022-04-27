using System.Collections.Generic;
using p1.Model;

namespace p1.Repository
{
    public interface IRepository <in TId, TE> where TE : Entity<TId>
    {

        TE FindOne(TId id);
        IEnumerable<TE> FindAll();
        TE Save(TE entity);
        int Delete(TId id);
        TE Update(TE entity);

    }
}