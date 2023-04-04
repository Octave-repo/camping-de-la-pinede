package fr.reservation.controller;

import fr.reservation.controller.common.HttpErreurFonctionnelle;
import fr.reservation.service.ReservationService;
import fr.reservation.service.dto.GetReservationCampingResponse;
import fr.reservation.service.dto.GetReservationResponse;
import fr.reservation.service.dto.PostReservationRequest;
import fr.reservation.service.dto.PostReservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    private ResponseEntity createReservation(@RequestBody PostReservationRequest postReservationRequest){
        //On vérifie que les données en entrées sont correctes
        if (postReservationRequest == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostReservationResponse response = this.reservationService.createReservation(postReservationRequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }

    @GetMapping("/utilisateur")
    private ResponseEntity getReservationUtilisateur(@RequestParam("id") long id){
        try{
            List<GetReservationResponse> response = this.reservationService.getReservationUtilisateur(id);
            if (response==null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }
    @GetMapping("/camping")
    private ResponseEntity GetReservationCampingResponse(@RequestParam("id") long id){
        try{
            List<GetReservationCampingResponse> response = this.reservationService.getReservationByCamping(id);
            if (response==null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }


}
