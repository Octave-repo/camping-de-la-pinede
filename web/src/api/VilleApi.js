import InstanceAxios from "./index";

//https://adresse.data.gouv.fr/api-doc/adresse
//API Mise en place pou récupérer des informations sur des villes

const path = 'https://api-adresse.data.gouv.fr/search/'

class VilleApi{
    getVille(adresse, codePostal){
        return InstanceAxios.get(path, {
            params:{
                q: adresse,
                postcode: codePostal,
                limit: 10
            }
        });
    }
}
export default new VilleApi();