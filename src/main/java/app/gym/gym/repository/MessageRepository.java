package app.gym.gym.repository;

import app.gym.gym.model.Message;
import app.gym.gym.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose D
 */
@Repository
public class MessageRepository {
     @Autowired
    private MessageCrudRepository messageCrudRepository;
        
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    //crear y actualizar si ya exite
    public Message save(Message p){
        return messageCrudRepository.save(p);
    }
    
    public void delete (Message p){
        messageCrudRepository.delete(p);
    }
}
