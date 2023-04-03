package fr.camping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Camping {
    @Id
    @GeneratedValue
    private long id;

    private String nom;

    private double prix;

    private int emplacementLibres;

    private double note;

    private String numeroTelephone;

    private String adresseMail;

    //@Enumerated (EnumType.STRING)
    @ElementCollection
    private List<Equipement> equipement;

    @ElementCollection
    private List<TypeLogements> typeLogements;

    private int nombreEtoiles;

    @OneToOne
    private GPSLocation adresse;
}
