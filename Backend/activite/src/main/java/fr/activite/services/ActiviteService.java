package fr.activite.services;

import fr.activite.Entities.Activite;
import fr.activite.Entities.GPSLocation;
import fr.activite.Repository.ActiviteRepository;
import fr.activite.services.dto.GetActiviteResponse;
import fr.activite.services.dto.PostActiviteRequest;
import fr.activite.services.dto.PostActiviteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public List<GetActiviteResponse> getActivite(Double latitude,Double longitude,Double distance){
        List<Activite> activites=this.activiteRepository.findAll();
        if (activites== null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte not found");
        }
        GPSLocation position=new GPSLocation(latitude,longitude);
        Predicate<Activite> predicat=activite -> activite.getAdresse().distanceVers(position)<distance;

        return activites.stream()
                .filter(predicat)
                .map(c ->GetActiviteResponse.builder()
                        .id(c.getId())
                        .logo(c.getLogo())
                        .lien(c.getLien())
                        .position(c.getAdresse())
                        .build()).collect(Collectors.toList());

    }
}
