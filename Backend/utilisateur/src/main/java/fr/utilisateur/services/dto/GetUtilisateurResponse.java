package fr.utilisateur.services.dto;

import fr.utilisateur.entities.GPSLocation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetUtilisateurResponse {
    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private GPSLocation adresse;
}
