package app.gym.gym.repository;

import app.gym.gym.model.Reservation;
import app.gym.gym.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose D
 */
@Repository
public class ReservationRepository {
   @Autowired
    private ReservationCrudRepository reservationCrudRepository;
        
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    //crear y actualizar si ya exite
    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }
    
    public void delete (Reservation p){
        reservationCrudRepository.delete(p);
    }  
}
