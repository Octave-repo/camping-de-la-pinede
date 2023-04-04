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
public class getListeCampingResponse {
    private long id;
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private List<Equipement> equipement;
    private List<TypeLogements> typeLogements;
    private int nombreEtoiles;
    private GPSLocation adresse;
}
