package fr.camping.services.dto;

import fr.camping.entity.Equipement;
import fr.camping.entity.GPSLocation;
import fr.camping.entity.TypeLogements;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCampingResponse {
    private long id;
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private String numeroTelephone;
    private String adresseMail;
    private List<Equipement> equipements;
    private List<TypeLogements> typeLogements;
    private int nombreEtoiles;
    private GPSLocation adresse;
}
