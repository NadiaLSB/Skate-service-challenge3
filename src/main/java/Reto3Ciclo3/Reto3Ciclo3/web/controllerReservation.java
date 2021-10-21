package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.model.entityReservation;
import Reto3Ciclo3.Reto3Ciclo3.service.serviceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
