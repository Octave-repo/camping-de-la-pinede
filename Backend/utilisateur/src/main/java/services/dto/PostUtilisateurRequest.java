package services.dto;

import fr.utilisateur.entities.GPSLocation;
import lombok.*;

import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostUtilisateurRequest {
    private String nom;
    private String prenom;
    private String telephone;
    private String mail;
    private GPSLocation adresse;
}
