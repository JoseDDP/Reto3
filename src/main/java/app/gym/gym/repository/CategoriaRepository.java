package app.gym.gym.repository;

import app.gym.gym.model.Categoria;
import app.gym.gym.repository.crud.CategoriaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose D
 */
@Repository
public class CategoriaRepository {
    
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }
    
    public Optional<Categoria>getCategoria(int id){
            return categoriaCrudRepository.findById(id);
    }
    
    //crear y actualizar si ya exite
    public Categoria save(Categoria c){
        return categoriaCrudRepository.save(c);
    }
    
    public void delete(Categoria c){
       categoriaCrudRepository.delete(c);
    }
    
}
