import InstanceAxios from "./index";

//Pour changer entre le chemin réel et le chemin mock
const url = 'http://localhost:'
const mock_port = '3000'

const path = `${url}${mock_port}`
class CampingApi{
    //TODO Changer pour faire fonctionner avec les filtres
    getCampings(){
        return InstanceAxios.get(`${path}/campings`);
    }
}

export default new CampingApi();