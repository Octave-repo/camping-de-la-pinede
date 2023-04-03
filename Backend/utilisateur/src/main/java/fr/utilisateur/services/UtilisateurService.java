package fr.utilisateur.services;

import fr.utilisateur.entities.Utilisateur;
import fr.utilisateur.services.dto.PostUtilisateurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import fr.utilisateur.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import fr.utilisateur.services.dto.PostUtilisateurRequest;

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

}
