import InstanceAxios from "./index";

//Pour changer entre le chemin réel et le chemin mock
const url = 'http://localhost:'
const mock_port = '8083'

const path = `${url}${mock_port}`
class UtilisateurApi{
    getUtilisateurById(id){
        return InstanceAxios.get(`${path}/utilisateur/?id=${id}`);
    }
    getUtilisateurByMail(mail){
        return InstanceAxios.get(`${path}/utilisateur/mail/?mail=${mail}`);
    }
    postUtilisateur(utilisateur){
        return InstanceAxios.post(`${path}/utilisateur/`, utilisateur);
    }
}

export default new UtilisateurApi();