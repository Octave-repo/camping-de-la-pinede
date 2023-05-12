import InstanceAxios from "./index";

//Pour changer entre le chemin réel et le chemin mock
const url = 'http://localhost:'
const mock_port = '8081'

const path = `${url}${mock_port}`
const headers = {
    headers:{}
}
class CampingApi{
    //TODO Changer pour faire fonctionner avec les filtres
    getCampings(){
        return InstanceAxios.get(`${path}/camping/`);
    }
    filteredGetCampings(note, prix, longitude, latitude, distance, etoiles){
        return InstanceAxios.get(`${path}/camping/`, {params:{
            note:note,
            prix:prix,
            etoiles:etoiles,
            latitude:latitude,
            longitude:longitude,
            distance:distance}
        })
    }
    getCamping(id){
        return InstanceAxios.get(`${path}/camping/${id}`);
    }
    postCamping(content){
        return InstanceAxios.post(`${path}/camping/`, content);
    }
    postAvis(content){
        return InstanceAxios.post(`${path}/camping/avis`, content)
    }
    getAvis(id){
        return InstanceAxios.get(`${path}/camping/avis?id=${id}`)
    }
    postNote(id, content){
        return InstanceAxios.post(`${path}/camping/${id}/note`, content)
    }
}

export default new CampingApi();