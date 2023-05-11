package fr.camping.controller;

import fr.camping.controller.common.HttpErreurFonctionnelle;
import fr.camping.services.*;
import fr.camping.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping
public class CampingController {
    @Autowired
    private CampingService campingServiceService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:8080")
    private ResponseEntity createcamping(@RequestBody PostCampingRequest postCampingRequest){
        //On vérifie que les données en entrées sont correctes
        if (postCampingRequest == null || postCampingRequest.getNom() == null ||
                postCampingRequest.getPrix() < 0 || postCampingRequest.getEmplacementLibres() < 0
                || postCampingRequest.getNote() < 0 || postCampingRequest.getNumeroTelephone() == null
                || postCampingRequest.getAdresseMail() == null || postCampingRequest.getEquipement() == null
                || postCampingRequest.getTypeLogements() == null || postCampingRequest.getNombreEtoiles() < 0){
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
    private ResponseEntity createcampingavis(@RequestBody PostCampingAvisRequest postCampingAvisRequest){
        if (postCampingAvisRequest == null ||postCampingAvisRequest.getTitre() == null ||
        postCampingAvisRequest.getContenu() == null){
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        }
        else{
            try{
                PostCampingAvisResponse response = this.campingServiceService.createCampingAvis(postCampingAvisRequest);
                return ResponseEntity.ok().body(response);
            }catch (ResponseStatusException e){
                if (e.getStatus().equals(HttpStatus.NOT_FOUND)){
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
            catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }

    @GetMapping("/{id}")
    private ResponseEntity getCamping(@PathVariable Long id) {
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

    @GetMapping
    private ResponseEntity getListeCaping(@RequestParam(value="note", required=false) Double note,
                                          @RequestParam(value="prix", required=false) Double prix,
                                          @RequestParam(value="longitude",required=false) Double longitude,
                                          @RequestParam(value="latitude",required=false) Double latitude,
                                          @RequestParam(value="distance",required=false) Double distance,
                                          @RequestParam(value="etoiles",required=false) Integer etoiles){
        try{
            List<GetListeCampingResponse> response = this.campingServiceService.getListeCamping(note, prix, longitude,
                    latitude, distance, etoiles);
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
    @PostMapping("/{id}/note")
    //PostNoteRequest
    private ResponseEntity ajoutNote(@PathVariable Long id, @RequestBody PostNoteRequest postNoteRequest ){
        if (postNoteRequest.getNote() < 0.0 && postNoteRequest.getNote() > 5.0)
            return ResponseEntity.badRequest().body(
                    new HttpErreurFonctionnelle("Les donnnées en entrée du service sont non renseignes ou incorrectes"));
        else{
            try{
                this.campingServiceService.postNote(id, postNoteRequest);
                return ResponseEntity.ok().build();
            }catch (Exception e){
                return ResponseEntity.internalServerError().body("Une erreur interne a été rencontrée");
            }
        }
    }
}
