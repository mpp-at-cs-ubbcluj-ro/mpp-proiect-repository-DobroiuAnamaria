package repository;

import model.Client;
import model.Entity;

import java.util.List;
import java.util.Map;

public class RepositoryClient <ID, E extends Entity<ID>> extends AbstractRepository<ID, E> implements Repository<ID,E>
{
    protected Map<ID, E> client;


    @Override
    public E findOne(ID id) {
        if (id == null)
            throw new IllegalArgumentException("id must be not null");
        return client.get(id);
    }

    @Override
    public Iterable<E> findAll() {
        return client.values();
    }



    @Override
    public E save(E entity) {
        if (entity == null)
            throw new IllegalArgumentException("id null");

        if (client.get(entity.getId()) != null) {
            return entity;
        } else client.put(entity.getId(), entity);
        return null;
    }


    @Override
    public E delete(ID id) {
        E entity = client.get(id);
        if(entity==null){
            throw new IllegalArgumentException("nu exista entitatea");
        }

        return client.remove(id);
    }


    public E update(E entity) {

        if (entity == null)
            throw new IllegalArgumentException("entitatea-i null");


        client.put(entity.getId(), entity);

        if (client.get(entity.getId()) != null) {
            client.put(entity.getId(), entity);
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
