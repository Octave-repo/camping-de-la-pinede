package fr.reservation.service.dto;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetReservationResponse {
    private long idCamping;
    private String nomCamping;
    private long idReservation;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nombrePersonne;

}
