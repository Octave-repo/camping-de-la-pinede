package fr.activite.services.dto;

import fr.activite.Entities.GPSLocation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostActiviteRequest {
    public String logo;
    public String lien;
    public GPSLocation position;
}
