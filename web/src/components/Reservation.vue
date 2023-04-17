<template>
    <div class="container">
        <!--Je sais pas pourquoi le style s'applique que comme ça-->
        <h1 class="title" style="background-color: RGB(255, 250, 250); padding: 10px;">Réserver</h1>
        <VueDatePicker class="date-picker" v-model="date"
            dark
            range :partial-range="true"
            :enable-time-picker="false"
            :min-date="new Date()"
            locale="fr"></VueDatePicker>
        <br/>
        <label>Nombre de personne: </label>
        <input type ="number" v-model="nbReservation"/>
        <br/>
        <button @click="confirmer">Réserver !</button>
    </div>    
</template>
<script>

import ReservationService from '@/service/ReservationService';
import UtilisateurService from '@/service/UtilisateurService';
import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'
//On assume qque ce composant n'est afficher que si
//L'utilisateur est connecté
/*
    private  long idCamping;
    private  long idUtilisateur;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nombrePersonne;

*/
export default{
    components:{
        VueDatePicker
    },
    props:{
        campingId:{
            type: Number,
            required: true
        }
    },
    data(){
        return {
            date: null,
            reservation: {},
            nbReservation: 0
        };
    },
    methods:{
        async confirmer(){
            let utilisateur = UtilisateurService.getUtilisateurLocal();
            if (utilisateur === null){
                alert('Ce message ne devrait pas s\'afficher');
            }
            if (this.date === null)
                alert('Veuillez séléctionner une date.');
            else if (this.nbReservation <= 0)
                alert('Une réservation doit contenir au moins une personne.');
            else if (this.date[1] === null){
                alert('Veuillez choisir une date de fin.');
            }
            else {
                this.reservation.idCamping = this.campingId;
                this.reservation.idUtilisateur = utilisateur.id;
                this.reservation.dateDebut = this.date[0];
                this.reservation.dateFin = this.date[1];
                console.log(this.reservation);
                try{
                    await ReservationService.postReservation(this.reservation);
                    alert('Réservation faite ! Vous allez recevoir un mail confirmant votre réservation.')
                } catch (error){
                    console.log(error);
                    alert('Erreur lors de la création d\'une réservation.');
                }
            }
        }
    }
}
</script>
<style scoped>
.date-picker {
    margin:auto;
    width: 20%;
};
.container {
    display: flex;
    justify-content: center;
    align-items: center;
};
.titre {
  background-color: red !important;
  padding: 10px;
};

</style>