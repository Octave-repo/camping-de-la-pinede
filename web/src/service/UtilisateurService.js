import UtilisateurApi from "@/api/UtilisateurApi";

class UtilisateurService{
    //TODO Changer pour faire fonctionner avec des filtres
    getUtilisateurById(id){
        return UtilisateurApi.getUtilisateurById(id);
    }
    getUtilisateurByMail(mail){
        return UtilisateurApi.getUtilisateurByMail(mail);
    }
    postUtilisateur(utilisateur){
        return UtilisateurApi.postUtilisateur(utilisateur);
    }
}

export default new UtilisateurService();