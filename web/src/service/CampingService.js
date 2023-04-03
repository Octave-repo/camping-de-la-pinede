import CampingApi from "@/api/CampingApi";

class CampingService{
    //TODO Changer pour faire fonctionner avec des filtres
    getCampings(){
        return CampingApi.getCampings();
    }
    getCamping(id){
        return CampingApi.getCamping(id);
    }
}

export default new CampingService();