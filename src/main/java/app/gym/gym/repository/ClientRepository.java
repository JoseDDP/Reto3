package app.gym.gym.repository;

import app.gym.gym.model.Client;
import app.gym.gym.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose D
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client>getClient(int id){
            return clientCrudRepository.findById(id);
    }
    
    //crear y actualizar si ya exite
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    
    public void delete(Client c){
       clientCrudRepository.delete(c);
    }
    
}
