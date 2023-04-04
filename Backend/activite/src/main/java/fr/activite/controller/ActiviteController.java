package fr.activite.controller;

import fr.activite.controller.common.HttpErreurFonctionnelle;
import fr.activite.services.ActiviteService;
import fr.activite.services.dto.PostActiviteRequest;
import fr.activite.services.dto.PostActiviteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ActiviteController {
    @Autowired
    public ActiviteService activiteService;

    @PostMapping
    private ResponseEntity createActivite(@RequestBody PostActiviteRequest postActiviteequest){
        //On vérifie que les données en entrées sont correctes
        if (postActiviteequest == null || postActiviteequest.getLogo()==null|| postActiviteequest.getLien()==null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostActiviteResponse response = this.activiteService.createActivite(postActiviteequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
}
