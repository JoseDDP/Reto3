package app.gym.gym.repository.crud;

import app.gym.gym.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jose D
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer>{
    
}
