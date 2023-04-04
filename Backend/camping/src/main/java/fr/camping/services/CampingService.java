package fr.camping.services;

import fr.camping.entity.Avis;
import fr.camping.entity.Camping;
import fr.camping.repository.AvisRepository;
import fr.camping.repository.CampingRepository;
import fr.camping.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampingService {

    @Autowired
    private CampingRepository campingRepository;
    @Autowired
    private AvisRepository avisRepository;

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

    public GetCampingResponse getCamping (long id){
        Camping camping = this.campingRepository.findCampingById(id);
        if (camping == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compte not found");
        }
        return GetCampingResponse.builder()
                .id(camping.getId())
                .nom(camping.getNom())
                .prix(camping.getPrix())
                .emplacementLibres(camping.getEmplacementLibres())
                .note(camping.getNote())
                .equipement(camping.getEquipement())
                .typeLogements(camping.getTypeLogements())
                .nombreEtoiles(camping.getNombreEtoiles())
                .adresse(camping.getAdresse())
                .build();
    }
    public PostCampingResponse updatecamping(PutCampingRequest campingRequest){
        Camping camping = this.campingRepository.findCampingById(campingRequest.getId());
        if (camping == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
        camping.setNom(campingRequest.getNom());
        camping.setPrix(campingRequest.getPrix());
        camping.setEmplacementLibres(campingRequest.getEmplacementLibres());
        camping.setNote(campingRequest.getNote());
        camping.setEquipement(campingRequest.getEquipement());
        camping.setTypeLogements(campingRequest.getTypeLogements());
        camping.setAdresse(campingRequest.getAdresse());
        this.campingRepository.save(camping);
        return buildCreateCampingReponse(camping);
    }
    public List<GetCampingAvisResponse> getCampingAvis (@RequestParam("id") long id){
        return this.avisRepository.findByCamping(id)
                .stream()
                .map(c-> GetCampingAvisResponse.builder()
                        .id(c.getId())
                        .utilisateur(c.getUtilisateur())
                        .camping(c.getCamping())
                        .titre(c.getTitre())
                        .contenu(c.getContenu())
                        .build())
                .collect(Collectors.toList());
    }

    public PostCampingAvisResponse createCampingAvis(PostCampingAvisRequest postCampingAvisRequest) {
        Avis avisSave = this.avisRepository.save(Avis.builder()
                        .camping(postCampingAvisRequest.getCamping())
                        .utilisateur(postCampingAvisRequest.getUtilisateur())
                        .titre(postCampingAvisRequest.getTitre())
                        .contenu(postCampingAvisRequest.getContenu())
                        .build());
        return buildCreateCampingAvisResponse(avisSave);
    }

    public PostCampingAvisResponse buildCreateCampingAvisResponse(Avis avisSave){
        return PostCampingAvisResponse.builder()
                .id(avisSave.getId())
                .camping(avisSave.getCamping())
                .utilisateur(avisSave.getUtilisateur())
                .titre(avisSave.getTitre())
                .contenu(avisSave.getContenu())
                .build();
    }

    public List<GetListeCampingResponse> getListeCamping (@RequestParam ("id") long id){
        return this.campingRepository.findAll()
                .stream()
                .map(c-> GetListeCampingResponse.builder()
                        .id(c.getId())
                        .nom(c.getNom())
                        .prix(c.getPrix())
                        .emplacementLibres(c.getEmplacementLibres())
                        .note(c.getNote())
                        .nombreEtoiles(c.getNombreEtoiles())
                        .adresse(c.getAdresse())
                        .build())
                .collect(Collectors.toList());
    }
}
