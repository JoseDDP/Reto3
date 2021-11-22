/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.gym.gym.service;

import app.gym.gym.model.Reservation;
import app.gym.gym.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose D
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p) {
        if (p.getIdReservation()== null) {
            return reservationRepository.save(p);
        } else {
            Optional<Reservation> paux = reservationRepository.getReservation(p.getIdReservation());
            if (paux.isEmpty()) {
                return reservationRepository.save(p);
            } else {
                return p;
            }

        }
    }
    
    public Reservation update(Reservation c){
        if (c.getIdReservation()!=null){
            Optional<Reservation>g=reservationRepository.getReservation(c.getIdReservation());
            if (!g.isEmpty()){
                if(c.getStartDate()!=null){
                    g.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    g.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getScore()!=null){
                    g.get().setScore(c.getScore());
                }
                             
                return reservationRepository.save(g.get());
            }
        }
        return c;
    }
    
    public boolean deleteReservation(int id){
        Optional<Reservation> c=getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }
    
}
