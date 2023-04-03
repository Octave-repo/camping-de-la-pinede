package fr.camping.services;

import fr.camping.entity.Camping;
import fr.camping.repository.CampingRepository;
import fr.camping.services.dto.PostCampingRequest;
import fr.camping.services.dto.PostCampingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampingService {

    @Autowired
    private CampingRepository campingRepository;

    public PostCampingResponse createCamping(PostCampingRequest postCampingRequest){
        Camping campingSave = this.campingRepository.save(Camping.builder()
                        .nom(postCampingRequest.getNom())
                        .prix(postCampingRequest.getPrix())
                        .emplacementLibres(postCampingRequest.getEmplacementLibres())
                        .note(postCampingRequest.getNote())
                        .numeroTelephone(postCampingRequest.getNumeroTelephone())
                        .adresseMail(postCampingRequest.getAdresseMail())
                        .equipement(postCampingRequest.getEquipement())
                        .typeLogements(postCampingRequest.getTypeLogements())
                        .nombreEtoiles(postCampingRequest.getNombreEtoiles())
                        .adresse(postCampingRequest.getAdresse())
                .build());
        return buildCreateCampingReponse(campingSave);
    }

    public PostCampingResponse buildCreateCampingReponse(Camping campingSave){
        return PostCampingResponse.builder()
                .id(campingSave.getId())
                .nom(campingSave.getNom())
                .prix(campingSave.getPrix())
                .emplacementLibres(campingSave.getEmplacementLibres())
                .note(campingSave.getNote())
                .numeroTelephone(campingSave.getNumeroTelephone())
                .adresseMail(campingSave.getAdresseMail())
                .equipement(campingSave.getEquipement())
                .typeLogements(campingSave.getTypeLogements())
                .nombreEtoiles(campingSave.getNombreEtoiles())
                .adresse(campingSave.getAdresse())
                .build();
    }
}
