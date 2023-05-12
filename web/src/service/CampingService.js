import CampingApi from "@/api/CampingApi";

class CampingService{
    //TODO Changer pour faire fonctionner avec des filtres
    getCampings(){
        return CampingApi.getCampings();
    }
    filteredGetCampings(note, prix, longitude, latitude, distance, etoiles){
        return CampingApi.filteredGetCampings(note, prix, longitude, latitude, distance, etoiles)
    }
    getCamping(id){
        return CampingApi.getCamping(id);
    }
    postCamping(content){
        return CampingApi.postCamping(content);
    }
    postAvis(content){
        return CampingApi.postAvis(content);
    }
    getAvis(id){
        return CampingApi.getAvis(id);
    }
    postNote(id, content){
        return CampingApi.postNote(id, content);
    }
}

export default new CampingService();