package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.model.entityMessage;
import Reto3Ciclo3.Reto3Ciclo3.service.serviceMessage;
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
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllerMessage {

    @Autowired
    private serviceMessage service;

    @GetMapping("/all")
    public List<entityMessage> getMessages(){
        return service.getAll();
    }

    @GetMapping("/id")
    public Optional<entityMessage> getMessage(@PathVariable("id") int messageId){
        return service.getMessage(messageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public entityMessage save(@RequestBody entityMessage message){
        return service.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public entityMessage update(@RequestBody entityMessage message) {
        return service.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return service.deleteMessage(messageId);
    }
}
