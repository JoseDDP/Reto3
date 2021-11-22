package app.gym.gym.service;

import app.gym.gym.model.Gymmachine;
import app.gym.gym.repository.GimnasioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose D
 */
@Service
public class GimnasioService {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    public List<Gymmachine> getAll() {
        return gimnasioRepository.getAll();

    }

    public Optional<Gymmachine> getGimnasio(int id) {
        return gimnasioRepository.getGimnasio(id);
    }

    public Gymmachine save(Gymmachine p) {
        if (p.getId() == null) {
            return gimnasioRepository.save(p);
        } else {
            Optional<Gymmachine> paux = gimnasioRepository.getGimnasio(p.getId());
            if (paux.isEmpty()) {
                return gimnasioRepository.save(p);
            } else {
                return p;
            }

        }
    }
     public Gymmachine update(Gymmachine c){
        if (c.getId()!=null){
            Optional<Gymmachine>g=gimnasioRepository.getGimnasio(c.getId());
            if (!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                if(c.getBrand()!=null){
                    g.get().setBrand(c.getBrand());
                }
                if(c.getYear()!=null){
                    g.get().setYear(c.getYear());
                }
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                             
                return gimnasioRepository.save(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteGimnasio(int id){
        Optional<Gymmachine> c=getGimnasio(id);
        if(!c.isEmpty()){
            gimnasioRepository.delete(c.get());
            return true;
        }
        return false;
    }

}
