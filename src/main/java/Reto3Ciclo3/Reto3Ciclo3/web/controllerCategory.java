package Reto3Ciclo3.Reto3Ciclo3.web;

import Reto3Ciclo3.Reto3Ciclo3.service.serviceCategory;
import Reto3Ciclo3.Reto3Ciclo3.model.entityCategory;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllerCategory {

    @Autowired
    private serviceCategory service;

    @GetMapping("/all")
    public List<entityCategory> getCategory(){
        return service.getAll();
    }

    @GetMapping("/id")
    public Optional<entityCategory> getCategory(@PathVariable("id") int categoryId){
        return service.getCategory(categoryId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public entityCategory save(@RequestBody entityCategory category){
        return service.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public entityCategory update(@RequestBody entityCategory category) {
        return service.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return service.deleteCategory(categoryId);
    }
}
