package fr.reservation.service.dto;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostReservationResponse {
    private  long id;
    private  long idCamping;
    private  long idUtilisateur;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nombrePersonne;
}
