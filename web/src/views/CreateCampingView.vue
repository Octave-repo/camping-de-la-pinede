<template>
    <h1>Nouveau Camping</h1>
    <div>
        <label>Nom: </label>
        <input type="text" v-model="camping.nom">
        <label>Prix: </label>
        <input type="number" v-model="camping.prix">
        <label>Nombre d'emplacements: </label>
        <input type="number" v-model="camping.emplacementLibres">
        <label>Note: </label>
        <input type="number" v-model="camping.note">
        <label>Numero de Téléphone: </label>
        <input type="tel" v-model="camping.numeroTelephone">
        <label>Adresse mail</label>
        <input type="mail" v-model="camping.adresseMail">
        <label>Nombre d'étoiles</label>
        <input type="number" v-model="camping.nombreEtoiles">
        <fieldset>
            <legend>Types de logements</legend>
            <div>
                <input type="checkbox" value="TENTE" v-model="checkedLogements">
                <label>Tente</label>
                <input type="checkbox" value="MOBILE_HOME" v-model="checkedLogements">
                <label>Mobile home</label>
                <input type="checkbox" value="CAMPINGCAR" v-model="checkedLogements">
                <label>Camping Car</label>
            </div>
        </fieldset>
        <fieldset>
            <legend>Types d'équipements</legend>
            <div class="test">
                <input type="checkbox" value="TELEVISION" v-model="checkedEquipement">
                <label>Télévision</label>
                <input type="checkbox" value="MACHINE_A_LAVER" v-model="checkedEquipement">
                <label>Machine à laver</label>
                <input type="checkbox" value="PISCINE" v-model="checkedEquipement">
                <label>Piscine</label>
                <input type="checkbox" value="RESTAURANT" v-model="checkedEquipement">
                <label>Restaurant</label>
                <input type="checkbox" value="BOITE_DE_NUIT" v-model="checkedEquipement">
                <label>Boîte de Nuit</label>
                <input type="checkbox" value="MINI_GOLF" v-model="checkedEquipement">
                <label>Mini Golf</label>
            </div>
        </fieldset>
        <button @click="confirmer">Confirmer</button>
    </div>
    <h1>Adresse:</h1>
    <CityPicker
        @adresse="(n)=>this.camping.adresse.nom=n"
        @latitude="(n)=>this.camping.adresse.latitude=n"
        @longitude="(n)=>this.camping.adresse.longitude=n"/>
</template>
<script>
import CityPicker from '@/components/CityPicker.vue';
import CampingService from '@/service/CampingService';
export default{
    name: 'CreateCampingView',
    components:{
        CityPicker
    },
    data(){
        return {
            camping: {},
            checkedLogements:[],
            checkedEquipement:[],
        }
    },
    beforeMount(){
        this.camping.adresse = {};
    },
    methods: {
        async confirmer(){
            this.camping.typeLogements = this.checkedLogements;
            this.camping.equipement = this.checkedEquipement;
            console.log(this.camping);
            try{
                /*this.camping.adresse.nom = "Valenciennes";
                this.camping.adresse.latitude = 50.3333;
                this.camping.adresse.longitude = 4.4555;*/
                let response = await CampingService.postCamping(this.camping);
                console.log(response.data);
                alert(response.data.id);
                this.$router.push('/');
            } catch (error){
                console.log(error);
                alert("Une erreur lors de la création d'un camping");
            }
        }
    }
}
</script>