<template>
    <div class="container">
        <h1>Réserver</h1>
        <label>Choisir date: </label>
        <VueDatePicker class="date-picker" v-model="date"
            dark
            range :partial-range="true"
            :enable-time-picker="false"
            :min-date="new Date()"></VueDatePicker>
        <br/>
        <label>Nombre de personne: </label>
        <input type ="number"/>
        <br/>
        <button>Réserver !</button>
    </div>    
</template>
<script>

import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'
//On assume qque ce composant n'est afficher que si
//L'utilisateur est connecté
//TODO Changer le formattage de la date
//parcque les ricains c'est des débiles
export default{
    components:{
        VueDatePicker
    },
    data(){
        return {
            date: null
        };
    },
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

</style>