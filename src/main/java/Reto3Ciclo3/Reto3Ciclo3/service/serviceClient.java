package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entityClient;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
@Service
public class serviceClient {

    @Autowired
    private repositoryClient methodsCrud;

    public List<entityClient> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<entityClient> getClient(int idClient){
        return methodsCrud.getClient(idClient);
    }

    public entityClient save(entityClient client){
        if (client.getIdClient()==null){
            return methodsCrud.save(client);
        }else{
            Optional<entityClient> e=methodsCrud.getClient(client.getIdClient());
            if (e.isEmpty()){
                return methodsCrud.save(client);
            }else {
                return client;
            }
        }
    }

    public entityClient update(entityClient client){
        if(client.getIdClient()!=null){
            Optional<entityClient> e= methodsCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            methodsCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
