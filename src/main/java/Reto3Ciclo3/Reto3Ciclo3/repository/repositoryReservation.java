package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;
import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositoryReservation {

    @Autowired
    private interfaceReservation crud;

    public List<entityReservation> getAll(){

        return (List<entityReservation>) crud.findAll();
    }

    public Optional<entityReservation> getReservation(int id){

        return crud.findById(id);
    }

    public entityReservation save(entityReservation reservation){

        return crud.save(reservation);
    }

    public void delete(entityReservation reservation){
        crud.delete(reservation);
    }
}
