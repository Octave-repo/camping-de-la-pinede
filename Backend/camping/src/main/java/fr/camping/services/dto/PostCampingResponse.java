package fr.camping.services.dto;

import fr.camping.entity.Equipement;
import fr.camping.entity.Equipement;
import fr.camping.entity.GPSLocation;
import fr.camping.entity.TypeLogements;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCampingResponse {
    private long id;
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private String numeroTelephone;
    private String adresseMail;
    private List<Equipement> equipement;
    private List<TypeLogements> typeLogements;
    private int nombreEtoiles;
    private GPSLocation adresse;
}
