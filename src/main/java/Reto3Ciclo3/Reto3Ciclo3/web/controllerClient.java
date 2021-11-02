package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;
import Reto3Ciclo3.Reto3Ciclo3.service.serviceClient;
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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllerClient {

    @Autowired
    private serviceClient service;

    @GetMapping("/all")
    public List<entityClient> getClient(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<entityClient> getClient(@PathVariable("id") int clientId){
        return service.getClient(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public entityClient save(@RequestBody entityClient client){
        return service.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public entityClient update(@RequestBody entityClient client) {
        return service.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return service.deleteClient(clientId);
    }
}
