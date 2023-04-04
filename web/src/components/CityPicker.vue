<template>
    <label>Adresse</label>
    <input type="text" v-model="adresse">
    <label>Code Postal</label>
    <input type="number" v-model="postalCode">
    <button @click="fetchCity">Ok</button>
    <Map :pos1="posistion"></Map>
</template>
<script>
import VilleService from '@/service/VilleService'
import Map from '@/components/Map.vue';
export default{
    name: 'CityPicker',
    components:{
        Map
    },
    data () {
        return {
            adresse: "",
            postalCode: 0,
            city: {},
            posistion: [0,0]
        }
    },
    methods:{
        async fetchCity(){
            try{
                let response = await VilleService.getVille(this.adresse, this.postalCode);
                this.city = response.data.features[0];
                this.postalCode = this.city.properties.postcode;
                this.adresse = this.city.properties.label;
                this.posistion = [this.city.geometry.coordinates[1], this.city.geometry.coordinates[0]]; 
            } catch(error){
                console.log(error);
            }
        }
    }
}
</script>