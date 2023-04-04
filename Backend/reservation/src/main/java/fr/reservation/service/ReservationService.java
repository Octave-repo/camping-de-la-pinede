package fr.reservation.service;

import fr.reservation.entity.Reservation;
import fr.reservation.repository.ReservationRepository;
import fr.reservation.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private WebClient.Builder webClient;

    public PostReservationResponse createReservation (PostReservationRequest postReservationRequest){
        Reservation reservationSave =this.reservationRepository.save(
                Reservation.builder()
                        .camping(postReservationRequest.getIdCamping())
                        .utilisateur(postReservationRequest.getIdUtilisateur())
                        .date_arriver(postReservationRequest.getDateDebut())
                        .date_depart(postReservationRequest.getDateFin())
                        .nombre_personne(postReservationRequest.getNombrePersonne())
                        .build());

        return buildCreateReservationResponse(reservationSave);
    }
    public PostReservationResponse buildCreateReservationResponse (Reservation reservationSave ){
        return PostReservationResponse.builder()
                .idCamping(reservationSave.getCamping())
                .idUtilisateur(reservationSave.getUtilisateur())
                .dateDebut(reservationSave.getDate_arriver())
                .dateFin(reservationSave.getDate_depart())
                .nombrePersonne(reservationSave.getNombre_personne())
                .build();
    }

    public CampingNomResponse getNomCamping(long id){
       return webClient.baseUrl("http://camping/")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/camping/"+id)
                        .build())
                .retrieve()
                .bodyToMono(CampingNomResponse.class)
                .block();

    }

    public List<GetReservationResponse> getReservationUtilisateur(long id){
        return this.reservationRepository.findByUtilisateur(id)
                .stream()
                .map(c -> GetReservationResponse.builder()
                        .idCamping(c.getCamping())
                        .nomCamping(getNomCamping(c.getCamping()).nom)
                        .idReservation(c.getId())
                        .dateDebut(c.getDate_arriver())
                        .dateFin(c.getDate_depart())
                        .nombrePersonne(c.getNombre_personne())
                        .build())
                .collect(Collectors.toList());
    }

    public UtilisateurNomResponse getNomUtilisateur(long id){
        return webClient.baseUrl("http://utilisateur/")
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/utilisateur/")
                        .queryParam("id",id)
                        .build())
                .retrieve()
                .bodyToMono(UtilisateurNomResponse.class)
                .block();

    }

    public List<GetReservationCampingResponse> getReservationByCamping(long id){
        return this.reservationRepository.findByCamping(id)
                .stream()
                .map(c -> GetReservationCampingResponse.builder()
                        .idUtilisateur(c.getUtilisateur())
                        .nomUtilisateur(getNomUtilisateur(c.getUtilisateur()).nom)
                        .idReservation(c.getId())
                        .dateDebut(c.getDate_arriver())
                        .dateFin(c.getDate_depart())
                        .nombrePersonne(c.getNombre_personne())
                        .build())
                .collect(Collectors.toList());
    }
}
