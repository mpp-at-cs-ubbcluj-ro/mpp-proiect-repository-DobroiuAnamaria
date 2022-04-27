package repository;

import model.Client;


public interface RepositoryClient  extends Repository<Integer, Client>{
    Client findByUsername(String username);

}
