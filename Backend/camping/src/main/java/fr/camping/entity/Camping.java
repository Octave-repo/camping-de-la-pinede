package fr.camping.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private List<Equipements> equipements;

    @ElementCollection
    private List<TypeLogements> typeLogements;

    private int nombreEtoiles;

    @OneToOne
    private GPSLocation adresse;
}
