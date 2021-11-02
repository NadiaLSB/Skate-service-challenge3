package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.reports.countClients;
import Reto3Ciclo3.Reto3Ciclo3.reports.reservationStatus;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositoryReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
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

    public reservationStatus getReservationStatusReport(){
        List<entityReservation> completed= methodsCrud.getReservationByStatus("completed");
        List<entityReservation> cancelled= methodsCrud.getReservationByStatus("cancelled");
        return new reservationStatus(completed.size(), cancelled.size());
    }

    public List<entityReservation> getReservationPeriod(String dateOne, String dateTwo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(dateOne);
            Date endDate = dateFormat.parse(dateTwo);
            if (startDate.before(endDate)){
                return methodsCrud.getReservationPeriod(startDate,endDate);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<countClients> getTopClients(){
        return methodsCrud.getTopClients();
    }
}
