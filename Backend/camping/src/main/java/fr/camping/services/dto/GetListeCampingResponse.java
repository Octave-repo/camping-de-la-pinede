package fr.camping.services.dto;

import fr.camping.entity.GPSLocation;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetListeCampingResponse {
    private long id;
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private int nombreEtoiles;
    private GPSLocation adresse;
}
