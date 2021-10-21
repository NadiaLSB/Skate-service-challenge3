package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceSkate;
import Reto3Ciclo3.Reto3Ciclo3.model.entitySkate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositorySkate {

    @Autowired
    private interfaceSkate crud;

    public List<entitySkate> getAll(){

        return (List<entitySkate>) crud.findAll();
    }

    public Optional <entitySkate> getSkate(int id){

        return crud.findById(id);
    }

    public entitySkate save(entitySkate skate){

        return crud.save(skate);
    }

    public void delete(entitySkate skate){
        crud.delete(skate);
    }
}
