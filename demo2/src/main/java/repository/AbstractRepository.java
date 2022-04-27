package repository;

import model.Client;
import model.Entity;

import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<ID, E extends Entity<ID>> implements Repository<ID, E>{

    public abstract Map<ID,E> getEntities();

    public abstract void deleteOneClient(ID id, E e);

    public abstract void deleteFriendship(Client client);

    public abstract List<E> findClient(Long id);
}