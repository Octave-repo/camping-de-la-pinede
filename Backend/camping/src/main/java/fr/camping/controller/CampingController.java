package fr.camping.controller;

import fr.camping.controller.common.HttpErreurFonctionnelle;
import fr.camping.services.CampingService;
import fr.camping.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CampingController {
    @Autowired
    private CampingService campingServiceService;

    @PostMapping("/avis")
    private ResponseEntity createcamping(@RequestBody PostCampingRequest postCampingRequest){
        //On vérifie que les données en entrées sont correctes
        if (postCampingRequest == null || postCampingRequest.getNom() == null ||
                postCampingRequest.getPrix() < 0 || postCampingRequest.getEmplacementLibres() < 0
                || postCampingRequest.getNote() < 0 || postCampingRequest.getNumeroTelephone() == null
                || postCampingRequest.getAdresseMail() == null || postCampingRequest.getEquipement() == null
                || postCampingRequest.getTypeLogements() == null || postCampingRequest.getNombreEtoiles() < 0
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

    @PostMapping("/avis")
    private ResponseEntity createcampingvis(@RequestBody PostCampingAvisRequest postCampingAvisRequest){
        if (postCampingAvisRequest == null ||postCampingAvisRequest.getTitre() == null ||
        postCampingAvisRequest.getContenu() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostCampingAvisResponse response = this.campingServiceService.createCampingAvis(postCampingAvisRequest);
                return ResponseEntity.ok().body(response);
            }catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }

    @GetMapping
    private ResponseEntity getCamping(@RequestParam("id") long id){
        try{
            GetCampingResponse response = this.campingServiceService.getCamping(id);
            if (response!=null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }

    @GetMapping("/avis")
    private ResponseEntity getCampingAvis(@RequestParam("id") long id){
        try{
            List<GetCampingAvisResponse> response = this.campingServiceService.getCampingAvis(id);
            if (response!=null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Une errreur interne a été rencontrée");
        }
    }

    @PutMapping
    private ResponseEntity updatecamping(@RequestBody PutCampingRequest putCampingRequest){
        //On vérifie que les données en entrées sont correctes
        if (putCampingRequest == null || putCampingRequest.getNom() == null ||
                putCampingRequest.getPrix() < 0 || putCampingRequest.getEmplacementLibres() < 0
                || putCampingRequest.getNote() < 0 || putCampingRequest.getEquipement() == null
                || putCampingRequest.getTypeLogements() == null || putCampingRequest.getNombreEtoiles() < 0
                || putCampingRequest.getAdresse() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostCampingResponse response = this.campingServiceService.updatecamping(putCampingRequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
}
