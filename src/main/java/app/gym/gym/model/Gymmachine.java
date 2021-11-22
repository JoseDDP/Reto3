package app.gym.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Jose D
 */
@Entity
@Table(name="machines")
public class Gymmachine implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private String brand;
private Integer year;
private String description;

@ManyToOne
@JoinColumn(name = "category")
@JsonIgnoreProperties({"machines","messages","reservations"})
private Categoria category;


@ManyToOne
@JoinColumn(name = "messages")
@JsonIgnoreProperties({"machines","messages","reservations"})
private Message messages;

@ManyToOne
@JoinColumn(name = "reservations")
@JsonIgnoreProperties({"machines","messages","reservations"})
private Reservation reservations;


    public Gymmachine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public Message getMessages() {
        return messages;
    }

    public void setMessages(Message messages) {
        this.messages = messages;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

  
    
    
   
    
}
