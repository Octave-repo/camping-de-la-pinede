<template>
    <h1>{{ utilisateur.prenom }} {{ utilisateur.nom }}</h1>
    <p>{{ utilisateur.mail }}</p>
    <p>{{ utilisateur.telephone }}</p>
    <p>{{ utilisateur.adresse.nom }}</p>
    <Map :pos1="position"></Map>
</template>
<script>
import UtilisateurService from '@/service/UtilisateurService';
import { useAuth0 } from '@auth0/auth0-vue';
import Map from '@/components/Map.vue';
export default {
    name: 'UtilisateurView',
    components:{
        Map
    },
    data(){
        return{
            auth0: useAuth0(),
            utilisateur: {},
            position:[0,0]
        }
    },
    beforeMount(){
        this.utilisateur.adresse = {};
        if (this.auth0.isAuthenticated){
            this.getUtilisateur();
        } else {
            this.$router.push('/'); 
        }
    },
    methods:{
        async getUtilisateur(){
            try{
                let response = await UtilisateurService.getUtilisateurByMail(this.auth0.user.email);
                this.utilisateur = response.data;
                this.position = [this.utilisateur.adresse.latitude, this.utilisateur.adresse.longitude];
            } catch (error)
            {
                console.log(error);
                this.$router.push('/');
            }
        }
    }
}
</script>