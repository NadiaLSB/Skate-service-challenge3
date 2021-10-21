package Reto3Ciclo3.Reto3Ciclo3.repository;

import Reto3Ciclo3.Reto3Ciclo3.repository.crud.interfaceCategory;
import Reto3Ciclo3.Reto3Ciclo3.model.entityCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class repositoryCategory {
    @Autowired
    private interfaceCategory crud;

    public List<entityCategory> getAll(){
        return (List<entityCategory>) crud.findAll();
    }

    public Optional<entityCategory> getCategory(int id){
        return crud.findById(id);
    }

    public entityCategory save(entityCategory category){
        return  crud.save(category);
    }

    public void delete(entityCategory category){
        crud.delete(category);
    }
}
