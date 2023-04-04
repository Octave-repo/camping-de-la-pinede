package fr.camping.services.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetCampingAvisResponse{
    private long id;

    private long utilisateur;

    private long camping;

    private String titre;

    private String contenu;
}
