package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.reports.countClients;
import Reto3Ciclo3.Reto3Ciclo3.reports.reservationStatus;
import Reto3Ciclo3.Reto3Ciclo3.service.serviceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllerReservation {

    @Autowired
    private serviceReservation service;

    @GetMapping("/all")
    public List<entityReservation> getReservation(){
        return service.getAll();
    }

    @GetMapping("/id")
    public Optional<entityReservation> getReservation(@PathVariable("id") int reservationId){
        return service.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public entityReservation save(@RequestBody entityReservation reservation){
        return service.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public entityReservation update(@RequestBody entityReservation reservation) {
        return service.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return service.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public reservationStatus getReservationsStatusReport(){
        return service.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<entityReservation> getReservationReportDate(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return service.getReservationPeriod(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<countClients> getClients(){
        return service.getTopClients();
    }
}
