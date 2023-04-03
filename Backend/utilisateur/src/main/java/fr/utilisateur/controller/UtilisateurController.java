package fr.utilisateur.controller;

import fr.utilisateur.controller.common.HttpErreurFonctionnelle;
import fr.utilisateur.services.dto.GetUtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.utilisateur.services.UtilisateurService;
import fr.utilisateur.services.dto.PostUtilisateurRequest;
import fr.utilisateur.services.dto.PostUtilisateurResponse;

import java.util.List;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    private ResponseEntity createUtilisateur(@RequestBody PostUtilisateurRequest postUtilisateurRequest){
        //On vérifie que les données en entrées sont correctes
        if (postUtilisateurRequest == null || postUtilisateurRequest.getNom() == null ||
                postUtilisateurRequest.getPrenom() == null || postUtilisateurRequest.getTelephone() == null
                || postUtilisateurRequest.getMail() ==null ||
                postUtilisateurRequest.getAdresse() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostUtilisateurResponse response = this.utilisateurService.createUtilisateur(postUtilisateurRequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
    @GetMapping
    private ResponseEntity getUtilisateur(@RequestParam("id") long id){
        try{
            GetUtilisateurResponse response = this.utilisateurService.getUtilisateur(id);
            if (response==null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }
}
