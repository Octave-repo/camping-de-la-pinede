package fr.reservation.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.Timestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue
    private  long id;

    private long camping;

    private long utilisateur;

    private Timestamp date_arriver;

    private Timestamp date_depart;

    private int nombre_personne;
}