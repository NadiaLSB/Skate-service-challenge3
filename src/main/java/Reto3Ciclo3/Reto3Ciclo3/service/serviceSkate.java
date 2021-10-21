package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entitySkate;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositorySkate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSkate {
    @Autowired
    private repositorySkate methodsCrud;

    public List<entitySkate> getAll(){

        return methodsCrud.getAll();
    }

    public Optional<entitySkate> getSkate(int skateId){

        return methodsCrud.getSkate(skateId);
    }

    public entitySkate save(entitySkate skate){
        if(skate.getId()==null){
            return methodsCrud.save(skate);
        }else{
            Optional<entitySkate> e=methodsCrud.getSkate(skate.getId());
            if (e.isEmpty()){
                return methodsCrud.save(skate);
            }else {
                return skate;
            }
        }
    }

    public entitySkate update(entitySkate skate){
        if(skate.getId()!=null){
            Optional<entitySkate> e=methodsCrud.getSkate(skate.getId());
            if(!e.isEmpty()){
                if(skate.getName()!=null){
                    e.get().setName(skate.getName());
                }
                if(skate.getBrand()!=null){
                    e.get().setBrand(skate.getBrand());
                }
                if(skate.getYear()!=null){
                    e.get().setYear(skate.getYear());
                }
                if(skate.getDescription()!=null){
                    e.get().setDescription(skate.getDescription());
                }
                if(skate.getCategory()!=null){
                    e.get().setCategory(skate.getCategory());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return skate;
            }
        }else{
            return skate;
        }
    }

    public boolean deleteSkate(int skateId) {
        Boolean aBoolean = getSkate(skateId).map(skate -> {
            methodsCrud.delete(skate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
