package fr.camping.controller;

import fr.camping.controller.common.HttpErreurFonctionnelle;
import fr.camping.services.CampingService;
import fr.camping.services.dto.PostCampingRequest;
import fr.camping.services.dto.PostCampingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class campingController {
    @Autowired
    private CampingService campingServiceService;

    @PostMapping
    private ResponseEntity createcamping(@RequestBody PostCampingRequest postCampingRequest){
        //On vérifie que les données en entrées sont correctes
        if (postCampingRequest == null || postCampingRequest.getNom() == null ||
                postCampingRequest.getPrix() <= 0 || postCampingRequest.getEmplacementLibres() <= 0
                || postCampingRequest.getNote() <= 0 || postCampingRequest.getNumeroTelephone() == null
                || postCampingRequest.getAdresseMail() == null || postCampingRequest.getEquipement() == null
                || postCampingRequest.getTypeLogements() == null || postCampingRequest.getNombreEtoiles() <= 0
                || postCampingRequest.getAdresse() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostCampingResponse response = this.campingServiceService.createCamping(postCampingRequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
}
