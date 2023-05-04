<template>
    <h1 style="background-color: RGB(255, 250, 250); padding: 10px;">Réservations</h1>
    <ul class="list-container">
        <li v-for="reservation in listeReservation" :key="reservation.idReservation" class="reservation" @click="goCamping(reservation.idCamping)">
            {{ reservation.nomCamping }} - {{  reservation.dateDebut }} - {{ reservation.dateFin }}
        </li>
    </ul>
</template>
<script>
import UtilisateurService from '@/service/UtilisateurService';
import ReservationService from '@/service/ReservationService';
export default{
    name: 'ListeReservations',
    data(){
        return {
            listeReservation: []
        }
    },
    beforeMount(){
        this.getReservations();
    },
    methods: {
        dateToString(date){
            return(`${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()}`);
        },
        async getReservations(){
            let utilisateur = UtilisateurService.getUtilisateurLocal()
            if (utilisateur === null)
                console.log('Ce message ne devrait pas s\'afficher')
            else{
                try {
                    let response = await ReservationService.getReservationUtilisateur(utilisateur.id)
                    console.log(response.data)
                    this.listeReservation = response.data;
                    this.listeReservation.forEach((reservation)=>{
                        reservation.dateDebut =this.dateToString(new Date(reservation.dateDebut));
                        reservation.dateFin = this.dateToString(new Date(reservation.dateFin));
                    });
                } catch (error){
                    console.log(error)
                }
            }
        },
        goCamping(id){
            this.$router.push({name: 'campingView', params: {id}});
        }
    }
}
</script>
<style scoped>
.list-container{
    height: 100px;
    width:40%;
    overflow-x: scroll;
    margin:auto;
}
.reservation:hover{
    cursor: pointer;
    background-color: lightgray;
}
</style>