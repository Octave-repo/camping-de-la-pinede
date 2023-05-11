import InstanceAxios from "./index";

//Pour changer entre le chemin réel et le chemin mock
const url = 'http://localhost:'
const mock_port = '8084'

const path = `${url}${mock_port}`
class ActiviteApi{
    postActivite(content){
        return InstanceAxios.post(`${path}/activite/`, content)
    }
    getActivites(longitude, latitude, distance){
        return InstanceAxios.get(`${path}/activite/`, {params:{
            latitude:latitude,
            longitude:longitude,
            distance:distance}
        })
    }
}

export default new ActiviteApi();