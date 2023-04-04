package fr.reservation.service.dto;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostReservationRequest {
    private  long idCamping;
    private  long idUtilisateur;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nombrePersonne;
}
