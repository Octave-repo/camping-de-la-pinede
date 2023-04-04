import VilleApi from "@/api/VilleApi";

class VilleService{
    getVille(adresse, codePostal){
        return VilleApi.getVille(adresse, codePostal);
    }
}

export default new VilleService();