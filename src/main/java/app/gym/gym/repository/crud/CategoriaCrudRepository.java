package app.gym.gym.repository.crud;

import org.springframework.data.repository.CrudRepository;
import app.gym.gym.model.Categoria;

/**
 *
 * @author Jose D
 */
public interface CategoriaCrudRepository extends CrudRepository<Categoria,Integer> {
    
}