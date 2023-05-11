import ActiviteApi from "@/api/ActiviteApi";

class ActiviteService{
    postActivite(content){
        return ActiviteApi.postActivite(content)
    }
    getActivites(longitude, latitude, distance){
        return ActiviteApi.getActivites(longitude, latitude,distance)
    }
}
export default new ActiviteService();