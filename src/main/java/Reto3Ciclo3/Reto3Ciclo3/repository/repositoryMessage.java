package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.model.entityMessage;
import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
@Repository
public class repositoryMessage{

    @Autowired
    private interfaceMessage crud;

    public List<entityMessage> getAll(){

        return (List<entityMessage>) crud.findAll();
    }

    public Optional<entityMessage> getMessage(int id){

        return crud.findById(id);
    }

    public entityMessage save(entityMessage message){

        return crud.save(message);
    }

    public void delete(entityMessage message){
        crud.delete(message);
    }
}
