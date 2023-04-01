package fr.utilisateur.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import fr.utilisateur.entities.GPSLocation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue
    private long id;

    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private GPSLocation adresse;

}
