package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;
import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.reports.countClients;
import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
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

    public List<entityReservation> getReservationByStatus(String status){
        return crud.findAllByStatus(status);
    }

    public List<entityReservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return crud.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<countClients> getTopClients(){
        List<countClients> clientList = new ArrayList<>();
        List<Object[]> report = crud.countTotalReservationByClient();
        for (int i=0;i<report.size();i++){
            clientList.add(new countClients((Long) report.get(i)[1],(entityClient)report.get(i)[0]));
        }
        return clientList;
    }
}
