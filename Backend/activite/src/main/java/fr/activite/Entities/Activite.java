package fr.activite.Entities;


import lombok.*;

import javax.persistence.*;


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

    @OneToOne(cascade = {CascadeType.ALL})
    private GPSLocation adresse;
}
