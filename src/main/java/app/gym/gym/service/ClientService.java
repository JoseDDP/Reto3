package app.gym.gym.service;

import app.gym.gym.model.Client;
import app.gym.gym.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose D
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clienteRepository;

    public List<Client> getAll() {
        return clienteRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clienteRepository.getClient(id);
    }

    public Client save(Client p) {
        if (p.getIdClient()== null) {
            return clienteRepository.save(p);
        } else {
            Optional<Client> paux = clienteRepository.getClient(p.getIdClient());
            if (paux.isEmpty()) {
                return clienteRepository.save(p);
            } else {
                return p;
            }

        }
    }

    public Client update(Client c) {
        if (c.getIdClient()!= null) {
            Optional<Client> g = clienteRepository.getClient(c.getIdClient());
            if (!g.isEmpty()) {
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    g.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    g.get().setPassword(c.getPassword());
                }
                if(c.getAge()!=null){
                    g.get().setAge(c.getAge());
                }
                return clienteRepository.save(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteClient(int id){
        Optional<Client> c=getClient(id);
        if(!c.isEmpty()){
            clienteRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
