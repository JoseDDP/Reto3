package app.gym.gym.service;

import app.gym.gym.model.Categoria;
import app.gym.gym.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose D
 */
@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> getAll(){
        return categoriaRepository.getAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }
    
    public Categoria save(Categoria p){
        if (p.getId() == null) {
            return categoriaRepository.save(p);
        } else {
            Optional<Categoria> paux = categoriaRepository.getCategoria(p.getId());
            if (paux.isEmpty()) {
                return categoriaRepository.save(p);
            } else {
                return p;
            }

        }
    }
    
    public Categoria update(Categoria c){
        if (c.getId()!=null){
            Optional<Categoria>g=categoriaRepository.getCategoria(c.getId());
            if (!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoriaRepository.save(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteCategoria(int id){
        Optional<Categoria> c=getCategoria(id);
        if(!c.isEmpty()){
            categoriaRepository.delete(c.get());
            return true;
        }
        return false;
    }
        
    
}
