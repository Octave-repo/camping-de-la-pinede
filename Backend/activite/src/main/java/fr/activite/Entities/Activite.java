package fr.activite.Entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Activite {
    @Id
    @GeneratedValue
    private long id;

    private String logo;
    private String lien;

    @OneToOne
    private GPSLocation adresse;
}
