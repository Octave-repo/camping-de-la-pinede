import UtilisateurApi from "@/api/UtilisateurApi";
 
class UtilisateurService{
    //TODO Changer pour faire fonctionner avec des filtres
    constructor (){
        this.utilisateurLocal = null;
    }
    getUtilisateurById(id){
        return UtilisateurApi.getUtilisateurById(id);
    }
    getUtilisateurByMail(mail){
        return UtilisateurApi.getUtilisateurByMail(mail);
    }
    postUtilisateur(utilisateur){
        return UtilisateurApi.postUtilisateur(utilisateur);
    }
    //Permet de sauvegarder localement les données d'un utilisateur
    //Afin de minimiser les fonctions get
    setUtlisateurLocal(utilisateur){
        this.utilisateurLocal = utilisateur;
    }
    resetUtlisateurLocal(){
        this.utilisateurLocal = null;
    }
    getUtilisateurLocal(){
        return this.utilisateurLocal;
    }
}

export default new UtilisateurService();