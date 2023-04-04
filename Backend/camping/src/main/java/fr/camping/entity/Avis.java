package fr.camping.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avis {

    @Id
    @GeneratedValue
    private long id;

    private long utilisateur;

    private long camping;

    private String titre;

    private String contenu;

}
