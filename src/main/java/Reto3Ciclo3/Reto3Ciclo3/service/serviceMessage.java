package Reto3Ciclo3.Reto3Ciclo3.service;

import Reto3Ciclo3.Reto3Ciclo3.model.entityMessage;
import Reto3Ciclo3.Reto3Ciclo3.repository.repositoryMessage;
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
public class serviceMessage {

    @Autowired
    private repositoryMessage methodsCrud;

    public List<entityMessage> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<entityMessage> getMessage(int idMessage){
        return methodsCrud.getMessage(idMessage);
    }

    public entityMessage save(entityMessage message){
        if (message.getIdMessage()==null){
            return methodsCrud.save(message);
        }else{
            Optional<entityMessage> e=methodsCrud.getMessage(message.getIdMessage());
            if (e.isEmpty()){
                return methodsCrud.save(message);
            }else {
                return message;
            }
        }
    }

    public entityMessage update(entityMessage message){
        if(message.getIdMessage()!=null){
            Optional<entityMessage> e= methodsCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            methodsCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
