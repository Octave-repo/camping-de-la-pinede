package fr.reservation.service.dto;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetReservationCampingResponse {
    private long idUtilisateur;
    private String nomUtilisateur;
    private long idReservation;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nombrePersonne;
}
