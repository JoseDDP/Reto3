package app.gym.gym.service;

import app.gym.gym.model.Message;
import app.gym.gym.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose D
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }
    public Message save(Message p) {
        if (p.getIdMessage()== null) {
            return messageRepository.save(p);
        } else {
            Optional<Message> paux = messageRepository.getMessage(p.getIdMessage());
            if (paux.isEmpty()) {
                return messageRepository.save(p);
            } else {
                return p;
            }

        }
    }
    
    public Message update(Message c){
        if (c.getIdMessage()!=null){
            Optional<Message>g=messageRepository.getMessage(c.getIdMessage());
            if (!g.isEmpty()){
                if(c.getMessageText()!=null){
                    g.get().setMessageText(c.getMessageText());
                }
                             
                return messageRepository.save(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteGimnasio(int id){
        Optional<Message> c=getMessage(id);
        if(!c.isEmpty()){
            messageRepository.delete(c.get());
            return true;
        }
        return false;
    }
    


}
