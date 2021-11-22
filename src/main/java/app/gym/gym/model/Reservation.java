package app.gym.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jose D
 */
@Entity
@Table(name="reservations")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    private Integer score;
    
    @OneToMany (cascade = {CascadeType.PERSIST},mappedBy = "reservations")
    @JsonIgnoreProperties("reservations")
    public List<Gymmachine> machines;
    
    @ManyToOne
    @JoinColumn(name = "messages")
    @JsonIgnoreProperties({"reservations","category","client"})
    private Message messages;
    
    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    
    
   
    public Reservation() {
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Gymmachine> getMachines() {
        return machines;
    }

    public void setMachines(List<Gymmachine> machines) {
        this.machines = machines;
    }

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
   

}
