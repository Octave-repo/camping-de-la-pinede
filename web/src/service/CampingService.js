import CampingApi from "@/api/CampingApi";

class CampingService{
    //TODO Changer pour faire fonctionner avec des filtres
    getCampings(){
        return CampingApi.getCampings();
    }
}

export default new CampingService();