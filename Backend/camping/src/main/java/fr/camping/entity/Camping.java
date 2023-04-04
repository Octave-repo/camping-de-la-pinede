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
    private Long id;

    private String nom;

    private double prix;

    private int emplacementLibres;

    private double note;

    private String numeroTelephone;

    private String adresseMail;

    @ElementCollection(targetClass = Equipement.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<Equipement> equipement;

    @ElementCollection(targetClass = TypeLogements.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<TypeLogements> typeLogements;

    private int nombreEtoiles;

    @OneToOne (cascade = {CascadeType.ALL})
    private GPSLocation adresse;
}
