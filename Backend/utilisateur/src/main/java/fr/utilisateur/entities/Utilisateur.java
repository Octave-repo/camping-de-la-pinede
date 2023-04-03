package fr.utilisateur.entities;

import lombok.*;

import javax.persistence.*;


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

    @OneToOne(cascade = {CascadeType.ALL})
    private GPSLocation adresse;


}
