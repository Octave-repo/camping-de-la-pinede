package fr.camping.services.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCampingAvisResponse {
    private long id;
    private long utilisateur;
    private long camping;
    private String titre;
    private String contenu;
}
