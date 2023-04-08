<template>
    <h1>Afficahge Utilisateur</h1>
    <p>Je suis un utilisateur</p>
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
    },
    methods:{
    }
}
</script>