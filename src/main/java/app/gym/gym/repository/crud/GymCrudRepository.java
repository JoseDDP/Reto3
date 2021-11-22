package app.gym.gym.repository.crud;

import org.springframework.data.repository.CrudRepository;
import app.gym.gym.model.Gymmachine;

/**
 *
 * @author Jose D
 */
public interface GymCrudRepository extends CrudRepository<Gymmachine,Integer> {
    
}
