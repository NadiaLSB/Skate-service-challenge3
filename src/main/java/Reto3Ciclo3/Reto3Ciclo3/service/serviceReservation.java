package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositoryReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceReservation {

    @Autowired
    private repositoryReservation methodsCrud;

    public List<entityReservation> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<entityReservation> getReservation(int idReservation){
        return methodsCrud.getReservation(idReservation);
    }

    public entityReservation save(entityReservation reservation){
        if (reservation.getIdReservation()==null){
            return methodsCrud.save(reservation);
        }else{
            Optional<entityReservation> e=methodsCrud.getReservation(reservation.getIdReservation());
            if (e.isEmpty()){
                return methodsCrud.save(reservation);
            }else {
                return reservation;
            }
        }
    }

    public entityReservation update(entityReservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<entityReservation> e= methodsCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            methodsCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
