<template>
    <h1 class="title" style="background-color: RGB(255, 250, 250); padding: 10px;">Commentaire</h1>
    <p>Laissez nous un commentaire !</p>
    <div class="container">
        <input type="text" v-model="titre"/>
    </div>
    <div class="container">
        <p><textarea style="height: 100px;" v-model="contenu"/></p>
    </div>
    <button @click="confirmer">Envoyer</button>
</template>
<script>
import UtilisateurService from '@/service/UtilisateurService';
import CampingService from '@/service/CampingService'
export default{
    name: 'Avis',
    data(){
        return{
            titre: "",
            contenu: ""
        }
    },
    props:{
        campingId:{
            type:Number,
            required: true
        }
    },
    methods:{
        async confirmer(){
            let utilisateur = UtilisateurService.getUtilisateurLocal()
            let avis = {}
            avis.utilisateur = utilisateur.id;
            avis.camping = this.campingId;
            avis.titre = this.titre;
            avis.contenu = this.contenu;
            try{
                let response = await CampingService.postAvis(avis);
                console.log(response.data)
                alert('Merci pour votre commentaire !')
            } catch (error){
                console.log(error)
            }
        }
    }
}
</script>
<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
};
</style>