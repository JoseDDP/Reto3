package app.gym.gym.web;

import app.gym.gym.model.Gymmachine;
import app.gym.gym.service.GimnasioService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jose D
 */
@RestController
@RequestMapping("api/Machine")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GimnasioController {

    @Autowired
    private GimnasioService gimnasioService;

    @GetMapping("/all")
    public List<Gymmachine> getGimnasio() {
        return gimnasioService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gymmachine> getGimnasio(@PathVariable("id") int id) {
        return gimnasioService.getGimnasio(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine save(@RequestBody Gymmachine p) {
        return gimnasioService.save(p);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine update(@RequestBody Gymmachine c) {
        return gimnasioService.update(c);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteGimnasio(@PathVariable("id") int id) {
        return gimnasioService.deleteGimnasio(id);
    }

}
