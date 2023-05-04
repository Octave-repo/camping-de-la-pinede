import CampingApi from "@/api/CampingApi";

class CampingService{
    //TODO Changer pour faire fonctionner avec des filtres
    getCampings(){
        return CampingApi.getCampings();
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
}

export default new CampingService();