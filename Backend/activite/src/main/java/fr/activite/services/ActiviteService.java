package fr.activite.services;

import fr.activite.Entities.Activite;
import fr.activite.Repository.ActiviteRepository;
import fr.activite.services.dto.PostActiviteRequest;
import fr.activite.services.dto.PostActiviteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiviteService {
    @Autowired
    public ActiviteRepository activiteRepository;

    public PostActiviteResponse createActivite (PostActiviteRequest postActiviteRequest){
        Activite activiteSave=this.activiteRepository.save(
                Activite.builder()
                        .logo(postActiviteRequest.logo)
                        .lien(postActiviteRequest.lien)
                        .adresse(postActiviteRequest.position).build());

        return buildCreateActiviteResponse(activiteSave);
    }

    public PostActiviteResponse buildCreateActiviteResponse (Activite activiteSave){
       return PostActiviteResponse.builder()
               .id(activiteSave.getId())
               .logo(activiteSave.getLogo())
               .lien(activiteSave.getLien())
               .position(activiteSave.getAdresse())
               .build();
    }
}
