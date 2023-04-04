package fr.utilisateur.services;

import fr.utilisateur.entities.Utilisateur;
import fr.utilisateur.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import fr.utilisateur.repository.UtilisateurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public PostUtilisateurResponse createUtilisateur (PostUtilisateurRequest postUtilisateurRequest){
        Utilisateur utiliateurSave =this.utilisateurRepository.save(
                Utilisateur.builder()
                        .nom(postUtilisateurRequest.getNom())
                        .prenom(postUtilisateurRequest.getPrenom())
                        .telephone(postUtilisateurRequest.getTelephone())
                        .mail(postUtilisateurRequest.getMail())
                        .adresse(postUtilisateurRequest.getAdresse())
                        .build());

        return buildCreateUtilisateurResponse(utiliateurSave);
    }

    public PostUtilisateurResponse buildCreateUtilisateurResponse (Utilisateur utiliateurSave){
        return PostUtilisateurResponse.builder()
                .id(utiliateurSave.getId())
                .nom(utiliateurSave.getNom())
                .prenom(utiliateurSave.getPrenom())
                .telephone(utiliateurSave.getTelephone())
                .mail(utiliateurSave.getMail())
                .adresse(utiliateurSave.getAdresse())
                .build();
    }

    public GetUtilisateurResponse getUtilisateur (long id){
        Utilisateur utilisateur = this.utilisateurRepository.findUtilisateurById(id);
        if (utilisateur== null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte not found");
        }
        return GetUtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .telephone(utilisateur.getTelephone())
                .mail(utilisateur.getMail())
                .adresse(utilisateur.getAdresse())
                .build();
    }

    public GetUtilisateurResponse getUtilisateurByMail (String mail){
        Utilisateur utilisateur = this.utilisateurRepository.findUtilisateurByMail(mail);
        if (utilisateur== null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte not found");
        }
        return GetUtilisateurResponse.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .telephone(utilisateur.getTelephone())
                .mail(utilisateur.getMail())
                .adresse(utilisateur.getAdresse())
                .build();
    }
    public PostUtilisateurResponse updateUtilisateur(PutUtilisateurRequest utilisateurRequest){
        Utilisateur utilisateur = this.utilisateurRepository.findUtilisateurById(utilisateurRequest.getId());
        if (utilisateur == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        utilisateur.setNom(utilisateurRequest.getNom());
        utilisateur.setPrenom(utilisateurRequest.getPrenom());
        utilisateur.setTelephone(utilisateurRequest.getTelephone());
        utilisateur.setMail(utilisateurRequest.getMail());
        utilisateur.setAdresse(utilisateurRequest.getAdresse());
        this.utilisateurRepository.save(utilisateur);
        return buildCreateUtilisateurResponse(utilisateur);
    }


}
