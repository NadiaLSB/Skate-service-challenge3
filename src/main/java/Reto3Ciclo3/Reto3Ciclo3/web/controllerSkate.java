package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.model.entitySkate;
import Reto3Ciclo3.Reto3Ciclo3.service.serviceSkate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllerSkate {
    @Autowired
    private serviceSkate service;
    @GetMapping("/all")
    public List<entitySkate> getSkates(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<entitySkate> getSkate(@PathVariable("id") int skateId){
        return service.getSkate(skateId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public entitySkate save(@RequestBody entitySkate skate){
        return service.save(skate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public entitySkate update(@RequestBody entitySkate skate) {
        return service.update(skate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int skateId) {
        return service.deleteSkate(skateId);
    }
}

