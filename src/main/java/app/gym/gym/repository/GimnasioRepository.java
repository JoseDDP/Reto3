package app.gym.gym.repository;

import app.gym.gym.model.Gymmachine;
import app.gym.gym.repository.crud.GymCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose D
 */
@Repository
public class GimnasioRepository {
    
    @Autowired
    private GymCrudRepository gymCrudRepository;
        
    public List<Gymmachine> getAll(){
        return (List<Gymmachine>) gymCrudRepository.findAll();
    }
    
    public Optional<Gymmachine> getGimnasio(int id){
        return gymCrudRepository.findById(id);
    }
    
    //crear y actualizar si ya exite
    public Gymmachine save(Gymmachine p){
        return gymCrudRepository.save(p);
    }
    
    public void delete (Gymmachine p){
        gymCrudRepository.delete(p);
    }
    
}
