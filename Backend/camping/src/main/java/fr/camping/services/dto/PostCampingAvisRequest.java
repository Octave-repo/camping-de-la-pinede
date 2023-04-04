package fr.camping.services.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCampingAvisRequest {
    private long utilisateur;
    private long camping;
    private String titre;
    private String contenu;
}
