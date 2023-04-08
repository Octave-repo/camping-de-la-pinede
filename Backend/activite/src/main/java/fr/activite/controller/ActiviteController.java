package fr.activite.controller;

import fr.activite.Entities.GPSLocation;
import fr.activite.controller.common.HttpErreurFonctionnelle;
import fr.activite.services.ActiviteService;
import fr.activite.services.dto.GetActiviteResponse;
import fr.activite.services.dto.PostActiviteRequest;
import fr.activite.services.dto.PostActiviteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ActiviteController {
    @Autowired
    public ActiviteService activiteService;

    @PostMapping
    private ResponseEntity createActivite(@RequestBody PostActiviteRequest postActiviterequest){
        //On vérifie que les données en entrées sont correctes
        if (postActiviterequest == null || postActiviterequest.getLogo()==null|| postActiviterequest.getLien()==null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostActiviteResponse response = this.activiteService.createActivite(postActiviterequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
    @GetMapping
    private ResponseEntity getActivite(@RequestParam("latitude")Double latitude,@RequestParam("longitude")Double longitude,
    @RequestParam("distance")Double distance){
        if(latitude==null || longitude==null || distance==null) {
            return ResponseEntity
                    .badRequest()
                    .body(new HttpErreurFonctionnelle("Les données en entrées sont incorrectes"));
        }
        else{
            try{
                List<GetActiviteResponse> response = this.activiteService.getActivite(latitude,longitude,distance);
                if (!response.isEmpty())
                    return ResponseEntity.ok().body(response);
                else
                    return ResponseEntity.noContent().build();
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
        }
}
