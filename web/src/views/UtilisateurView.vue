<template>
    <h1>{{ utilisateur.prenomUtilisateur }} {{ utilisateur.nomUtilisateur }}</h1>
    <p>{{ utilisateur }}</p>
</template>
<script>
import UtilisateurService from '@/service/UtilisateurService';
export default {
    name: 'UtilisateurView',
    data(){
        return{
            utilisateur: {}
        }
    },
    beforeMount(){
        this.id = this.$route.params.id;
        this.getUtilisateur(this.id);
    },
    methods:{
        async getUtilisateur(id){
            try{
                let response = await UtilisateurService.getUtilisateurById(id);
                console.log(response.data);
                this.utilisateur = response.data;
                console.log(this.utilisateur);
            }
            catch (error){
                console.log('Erreur');
            }
        }
    }
}
</script>