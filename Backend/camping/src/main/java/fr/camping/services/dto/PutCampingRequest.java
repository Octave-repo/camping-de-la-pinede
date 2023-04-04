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
public class PutCampingRequest {
    private long id;
    private String nom;
    private double prix;
    private int emplacementLibres;
    private double note;
    private List<Equipement> equipement;
    private List<TypeLogements> typeLogements;
    private int nombreEtoiles;
    private GPSLocation adresse;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class GetCampingAvisResponse {

        private long id;
        private long utilisateur;
        private long camping;
        private String titre;
        private String contenu;
    }
}
