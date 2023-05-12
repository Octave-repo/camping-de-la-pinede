<template>
    <label>Adresse</label>
    <input type="text" v-model="adresse" @change="fetchCities">
    <label>Code Postal</label>
    <input type="text" style="width: 50px;" v-model="postalCode" @change="fetchCities">
    <label>Choisir une adresse: </label>
    <select v-model="index" @change="confirmCity">
        <option v-for="(cit, i) in cities" :key="i" :value="i" @change="confirmCity">{{ cit.properties.label }}</option>
    </select>
    <Map v-if="displayMap" :pos1="position"></Map>
</template>
<script>
import VilleService from '@/service/VilleService'
import Map from '@/components/Map.vue';
export default{
    name: 'CityPicker',
    emits:[
        "adresse",
        "longitude",
        "latitude"
    ],
    props:{
        displayMap:{
            type: Boolean,
            required: false,
            default: true
        }
    },
    components:{
        Map
    },
    data () {
        return {
            adresse: "",
            city: {},
            position: [0,0],
            cities: [],
            postalCode: "",
            index:1
        }
    },
    methods:{
        //Récupère les dix villes les plus probables d'être l'adresse
        //entrée
        async fetchCities(){
            try{
                let response = await VilleService.getVille(this.adresse, this.postalCode);
                this.cities = response.data.features;
            } catch(error){
                console.log(error);
            }
        },
        confirmCity(){
            this.city = this.cities[this.index];
            this.postalCode = this.city.properties.postcode;
            this.adresse = this.city.properties.label;
            this.position = [this.city.geometry.coordinates[1], this.city.geometry.coordinates[0]];
            this.emitAll();
        },
        emitAll(){
            this.$emit('adresse', this.adresse);
            this.$emit('latitude', this.position[0]);
            this.$emit('longitude', this.position[1]);
        }
    }
}
</script>