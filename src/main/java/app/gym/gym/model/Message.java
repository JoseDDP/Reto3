package app.gym.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Jose D
 */
@Entity
@Table(name="messages")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(length=250)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "machines")
    @JsonIgnoreProperties({"messages","reservations"})
    private Gymmachine machines;  
    
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties({"messages","reservations"})
    private Categoria category;
    
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;            
    
    public Message() {
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Gymmachine getMachines() {
        return machines;
    }

    public void setMachines(Gymmachine machines) {
        this.machines = machines;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
    

    
    
}
