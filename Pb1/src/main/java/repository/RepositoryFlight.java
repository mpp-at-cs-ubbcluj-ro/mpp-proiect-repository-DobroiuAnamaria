package repository;

import model.Client;
import model.Entity;

import java.util.List;
import java.util.Map;

public class RepositoryFlight <ID, E extends Entity<ID>> extends AbstractRepository<ID, E> implements Repository<ID,E>
{
    protected Map<ID, E> flights;


    @Override
    public E findOne(ID id) {
        if (id == null)
            throw new IllegalArgumentException("id must be not null");
        return flights.get(id);
    }

    @Override
    public Iterable<E> findAll() {
        return flights.values();
    }



    @Override
    public E save(E entity) {
        if (entity == null)
            throw new IllegalArgumentException("id null");

        if (flights.get(entity.getId()) != null) {
            return entity;
        } else flights.put(entity.getId(), entity);
        return null;
    }


    @Override
    public E delete(ID id) {
        E entity = flights.get(id);
        if(entity==null){
            throw new IllegalArgumentException("nu exista entitatea");
        }

        return flights.remove(id);
    }


    public E update(E entity) {

        if (entity == null)
            throw new IllegalArgumentException("entitatea-i null");

        flights.put(entity.getId(), entity);

        if (flights.get(entity.getId()) != null) {
            flights.put(entity.getId(), entity);
            return null;
        }
        return entity;

    }

    @Override
    public Map<ID, E> getEntities() {
        return null;
    }

    @Override
    public void deleteOneClient(ID id, E e) {

    }

    @Override
    public void deleteFriendship(Client client) {

    }

    @Override
    public List<E> findClient(Long id) {
        return null;
    }
    @Override
    public E save(ID id) {
        return null;
    }
}
