<template>
    <h1>Création du compte</h1>
    <div>
        <label>Nom: </label>
        <input type="text" v-model="utilisateur.nom">
        <label>Prénom: </label>
        <input type="text" v-model="utilisateur.prenom">
    </div>
    <div>
        <label>Télephone: </label>
        <input type="text" v-model="utilisateur.telephone">
        <label>Mail: </label>
        <input disabled="true" type="text" v-model="utilisateur.mail">
    </div>
    <CityPicker
        @adresse="(n)=>this.utilisateur.adresse.nom=n"
        @latitude="(n)=>this.utilisateur.adresse.latitude=n"
        @longitude="(n)=>this.utilisateur.adresse.longitude=n"/>
    <button @click="confirm">Confirmer</button>
</template>

<script>
import CityPicker from '@/components/CityPicker.vue';
import { useAuth0 } from '@auth0/auth0-vue';
import UtilisateurService from '@/service/UtilisateurService';
export default{
    name: 'SignUpView',
    components:{
        CityPicker
    },
    data(){
        return {
            utilisateur: {},
            auth0: useAuth0(),
            user: useAuth0().user,
            authenticated: useAuth0().isAuthenticated,
        }
    },
    beforeMount() {
        if (!this.authenticated)
            this.$router.push('/');
        else{
            this.utilisateur.adresse = {};
            this.utilisateur.nom = this.user.family_name;
            this.utilisateur.prenom = this.user.given_name;
            this.utilisateur.mail = this.user.email;
            console.log(this.user);
        }
    },
    methods:{
        async confirm(){
            if(Object.keys(this.utilisateur.adresse).length === 0){
                alert('Veuillez séléctionner une adresse')
                return
            }
            try{
                let response = await UtilisateurService.postUtilisateur(this.utilisateur);
                //On met l'utilisateur crée en tant qu'utilisateur actuel
                UtilisateurService.setUtlisateurLocal(response.data);
                console.log(response.data);
                this.$router.push('profile');
            } catch (error){
                alert('Erreur lors de la création de l\'utilisateur');
            }
        }
    }
}
</script>