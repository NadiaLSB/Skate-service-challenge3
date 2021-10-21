package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;
import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositoryClient {

    @Autowired
    private interfaceClient crud;

    public List<entityClient> getAll(){

        return (List<entityClient>) crud.findAll();
    }

    public Optional<entityClient> getClient(int id){

        return crud.findById(id);
    }

    public entityClient save(entityClient client){

        return crud.save(client);
    }

    public void delete(entityClient client){
        crud.delete(client);
    }
}
