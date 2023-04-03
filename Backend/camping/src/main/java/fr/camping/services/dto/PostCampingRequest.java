package fr.camping.services.dto;

import fr.camping.entity.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCampingRequest {
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private String numeroTelephone;
    private String adresseMail;
    private List<Equipements> equipement;
    private List<TypeLogements> typeLogements;
    private int nombreEtoiles;
    private GPSLocation adresse;
}
