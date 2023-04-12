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
    getCamping(id){
        return InstanceAxios.get(`${path}/camping/${id}`);
    }
    postCamping(content){
        return InstanceAxios.post(`${path}/camping/`, content);
    }
    postAvis(content){
        return InstanceAxios.post(`${path}/camping/avis`, content)
    }
}

export default new CampingApi();