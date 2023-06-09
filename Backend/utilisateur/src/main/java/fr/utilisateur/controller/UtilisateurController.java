package fr.utilisateur.controller;

import fr.utilisateur.controller.common.HttpErreurFonctionnelle;
import fr.utilisateur.services.dto.GetUtilisateurResponse;
import fr.utilisateur.services.dto.PutUtilisateurRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.utilisateur.services.UtilisateurService;
import fr.utilisateur.services.dto.PostUtilisateurRequest;
import fr.utilisateur.services.dto.PostUtilisateurResponse;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping
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
            if (response!=null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e){
            if (e.getStatus().equals(HttpStatus.NOT_FOUND)){
                return  ResponseEntity.notFound().build();
            } else{
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }

    @GetMapping("mail")
    private ResponseEntity getUtilisateur(@RequestParam("mail") String mail){
        try {
            GetUtilisateurResponse response = this.utilisateurService.getUtilisateurByMail(mail);
            if (response != null)
                return ResponseEntity.ok().body(response);
            else
                return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e){
            if (e.getStatus().equals(HttpStatus.NOT_FOUND)){
                return  ResponseEntity.notFound().build();
            } else{
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
        }
    }

    @PutMapping
    private ResponseEntity uptdateUtilisateur(@RequestBody PutUtilisateurRequest putUtilisateurRequest){
        //On vérifie que les données en entrées sont correctes
        if (putUtilisateurRequest == null || putUtilisateurRequest.getNom() == null ||
                putUtilisateurRequest.getPrenom() == null || putUtilisateurRequest.getTelephone() == null
                || putUtilisateurRequest.getMail() ==null ||
                putUtilisateurRequest.getAdresse() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostUtilisateurResponse response = this.utilisateurService.updateUtilisateur(putUtilisateurRequest);
                return ResponseEntity.ok().body(response);
            } catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }

}
