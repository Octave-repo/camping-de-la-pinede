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
}

export default new CampingService();