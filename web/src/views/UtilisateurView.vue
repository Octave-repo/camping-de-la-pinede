<template>
    <h1>{{ utilisateur.prenom }} {{ utilisateur.nom }}</h1>
    <p>{{ utilisateur.mail }}</p>
    <p>{{ utilisateur.telephone }}</p>
    <p>{{ utilisateur.adresse.nom }}</p>
    <Map :pos1="position"></Map>
    <ListeReservations/>
</template>
<script>
import UtilisateurService from '@/service/UtilisateurService';
import { useAuth0 } from '@auth0/auth0-vue';
import Map from '@/components/Map.vue';
import ListeReservations from '@/components/ListeReservations.vue';

export default {
    name: 'UtilisateurView',
    components:{
        Map,
        ListeReservations
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
            this.position = [this.utilisateur.adresse.latitude, this.utilisateur.adresse.longitude];
        } else {
            this.$router.push('/'); 
        }
    },
    methods:{
        getUtilisateur(){
            /*Si l'utilisateur n'as pas de compte "camping"
            On le renvoie sur la page d'inscription
            On met ça dans une variable temporaire pour éviter les problèmes
            De render du DOM*/
            let tmp = UtilisateurService.getUtilisateurLocal();
            if (tmp === null){
                this.$router.push('signup');
            } else{
                this.utilisateur = tmp;
            }
            console.log(this.utilisateur);
        }
    }
}
</script>