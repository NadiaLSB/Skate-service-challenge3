package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entityCategory;
import Reto3Ciclo3.Reto3Ciclo3.model.entitySkate;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCategory {

    @Autowired
    private repositoryCategory methodsCrud;

    public List<entityCategory> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<entityCategory> getCategory(int id){
        return methodsCrud.getCategory(id);
    }

    public entityCategory save(entityCategory category){
        if (category.getId()==null){
            return methodsCrud.save(category);
        }else{
            Optional<entityCategory> g=methodsCrud.getCategory(category.getId());
            if (g.isEmpty()){
                return methodsCrud.save(category);
            }else {
                return category;
            }
        }
    }

    public entityCategory update(entityCategory category){
        if(category.getId()!=null){
            Optional<entityCategory> g=methodsCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return methodsCrud.save(g.get());
            }
        }
        return category;
    }

    public boolean deleteCategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            methodsCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
